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
import com.chimy.bankuishchallenge.di.appModule
import com.chimy.bankuishchallenge.ui.theme.BankuishChallengeTheme
import com.chimy.bankuishchallenge.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin { //iniciar koin
            modules(appModule) //llamando al modulo
        }

        setContent {
            BankuishChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupApp()
                }
            }
        }

    }
    override fun onDestroy() {//llamar al metodo
        super.onDestroy()//esto detiene koin cuando se destruye la actividad
        stopKoin()
    }
}

@Composable
fun SetupApp() {
    val navController = rememberNavController()

    val viewModel : MainViewModel = koinViewModel() //viewmodel con koin

    LaunchedEffect(Unit) {
        viewModel.fetchRepositories() //carga repos cuando inicia
    }

    SetupNavGraph(navController = navController, viewModel = viewModel)
}

