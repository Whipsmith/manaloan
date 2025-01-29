package nz.spahr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import nz.spahr.theme.SpahrTheme
import nz.spahr.view.MainNavHost
import nz.spahr.view.MainNavigationScaffold
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpahrTheme {
                KoinAndroidContext {

                    val navController = rememberNavController()
//                    TODO: Wrap this in a scaffold to house nav drawer and account image? (See google photos)

                    MainNavigationScaffold(
                        navController = navController,
                        navHost = @Composable {
                            MainNavHost(navController = navController)
                        },
                    )
                }
            }
        }
    }
}
