package com.chimy.bankuishchallenge.ui



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.chimy.bankuishchallenge.data.network.RetrofitClient
import com.chimy.bankuishchallenge.data.repository.Repository
import com.chimy.bankuishchallenge.ui.theme.BankuishChallengeTheme
import com.chimy.bankuishchallenge.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankuishChallengeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SetupApp()
                }
            }
        }
    }
}

@Composable
fun SetupApp() {
    val navController = rememberNavController()

    // Crear el ViewModel manualmente si no usas Koin
    val repository = Repository(RetrofitClient.apiService)
    val viewModel = MainViewModel(repository)

    // Llamar a fetchRepositories al iniciar
    LaunchedEffect(Unit) {
        viewModel.fetchRepositories()
    }

    SetupNavGraph(navController = navController, viewModel = viewModel)
}

