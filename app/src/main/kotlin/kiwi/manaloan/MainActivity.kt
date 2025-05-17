package kiwi.manaloan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import kiwi.manaloan.presentation.app.AppViewModel
import kiwi.manaloan.presentation.app.ManaLoanApp
import kiwi.manaloan.presentation.app.model.AppState
import kiwi.manaloan.theme.ManaLoanTheme
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }
        enableEdgeToEdge()
        setContent {
            ManaLoanTheme {
                KoinAndroidContext { // Actual implementation is async
                    val viewModel = koinViewModel<AppViewModel>()
                    val state = viewModel.state.collectAsStateWithLifecycle()
                    val navController = rememberNavController()
                    when (val appState = state.value) {
                        is AppState.Data -> {
                            keepSplashScreen = false
                            ManaLoanApp(
                                navController = navController,
                                appState = appState
                            )
                        }

                        AppState.Loading -> {}
                    }

                }
            }
        }
    }
}
