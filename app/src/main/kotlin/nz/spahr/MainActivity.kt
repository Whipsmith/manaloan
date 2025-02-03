package nz.spahr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nz.spahr.app.AppViewModel
import nz.spahr.app.SpahrApp
import nz.spahr.app.model.AppState
import nz.spahr.theme.SpahrTheme
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
            SpahrTheme {
                KoinAndroidContext { // Actual implementation is async
                    val viewModel = koinViewModel<AppViewModel>()
                    val state = viewModel.state.collectAsStateWithLifecycle()
                    when (val appState = state.value) {
                        is AppState.Data -> {
                            keepSplashScreen = false
                            SpahrApp(appState)
                        }

                        AppState.Loading -> {}
                    }

                }
            }
        }
    }
}
