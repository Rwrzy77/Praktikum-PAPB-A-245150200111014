package com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.Routes
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.RetrofitClient
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.remote.StudentRemoteDataSource
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.data.repository.DefaultStudentRepository
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.home.HomeViewModel
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.theme.screen.AboutScreen
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.theme.screen.DetailScreen
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.theme.screen.HomeScreen
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.theme.screen.ProfileScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.praktikum5_navigation_compose_245150200111014_Razy_De_Averroes.ui.detail.DetailViewModel

@Composable
fun NavigationLabApp() {
    val remoteDataSource = remember {
        StudentRemoteDataSource(RetrofitClient.apiService)
    }
    val repository = remember {
        DefaultStudentRepository(remoteDataSource)
    }
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.factory(repository)
            )
           // val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

            val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
            val searchQuery by homeViewModel.searchQuery.collectAsStateWithLifecycle()

            HomeScreen(
                uiState = uiState,
                searchQuery = searchQuery,
                onSearchQueryChange = homeViewModel::onSearchQueryChange,
                onStudentClick = { id -> navController.navigate(Routes.detail(id)) },
                onRetry = homeViewModel::retry,
                onRefresh = homeViewModel::refresh
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: -1

            val viewModel: DetailViewModel = viewModel(
                factory = DetailViewModel.factory(repository)
            )
            val detailUiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(studentId) {
                viewModel.loadStudent(studentId)
            }

            DetailScreen(
                uiState = detailUiState,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.PROFILE) { ProfileScreen(onBack = { navController.popBackStack() }) }
        composable(Routes.ABOUT) { AboutScreen(onBack = { navController.popBackStack() }) }
    }
}
