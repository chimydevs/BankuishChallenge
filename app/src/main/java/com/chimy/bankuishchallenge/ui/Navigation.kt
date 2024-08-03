package com.chimy.bankuishchallenge.ui


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
            val repoName = backStackEntry.arguments?.getString("repoName") ?: return@composable
            val repo = viewModel.repositories.collectAsState().value.find { it.name == repoName }
            if (repo != null) {
                DetailScreen(navController = navController, repo = repo)
            } else {
                // Manejo de error: puedes mostrar una pantalla de error o un mensaje aquí
                Text(text = "Repository not found")
            }
        }
    }
}