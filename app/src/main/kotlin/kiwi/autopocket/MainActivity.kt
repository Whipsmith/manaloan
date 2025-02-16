package kiwi.autopocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import kiwi.autopocket.presentation.app.AppViewModel
import kiwi.autopocket.presentation.app.AutoPocketApp
import kiwi.autopocket.presentation.app.model.AppState
import kiwi.autopocket.theme.AutoPocketTheme
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
            AutoPocketTheme {
                KoinAndroidContext { // Actual implementation is async
                    val viewModel = koinViewModel<AppViewModel>()
                    val state = viewModel.state.collectAsStateWithLifecycle()
                    val navController = rememberNavController()
                    when (val appState = state.value) {
                        is AppState.Data -> {
                            keepSplashScreen = false
                            AutoPocketApp(
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
