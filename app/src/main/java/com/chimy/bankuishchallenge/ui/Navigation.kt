package com.chimy.bankuishchallenge.ui


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chimy.bankuishchallenge.viewmodel.MainViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable("details/{repoName}") { backStackEntry ->
            val repoName = backStackEntry.arguments?.getString("repoName") ?: "Unknown"
            DetailScreen(navController = navController, repoName = repoName)
        }
    }
}