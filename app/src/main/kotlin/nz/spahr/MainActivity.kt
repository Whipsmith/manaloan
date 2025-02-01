package nz.spahr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import kotlinx.collections.immutable.toPersistentHashMap
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.future_expense.feature_flags.FutureExpenseFlags
import nz.spahr.model.rememberAppState
import nz.spahr.theme.SpahrTheme
import nz.spahr.view.MainNavHost
import nz.spahr.view.MainNavigationScaffold
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpahrTheme {
                KoinAndroidContext {

                    val navController = rememberNavController()

//                    TODO: App view model?
                    val featureFlags: List<FeatureFlag> = koinInject(named<FeatureFlag>())
                    val featureFlagValueProvider =
                        FutureExpenseFlags // Actual implementation is async

                    val appState = rememberAppState(
                        featureFlags.associateWith { (it as? FutureExpenseFlags)?.activationDate != null }
                            .toPersistentHashMap()
                    )
//                    TODO: Wrap this in a scaffold to house nav drawer and account image? (See google photos)

                    MainNavigationScaffold(
                        navController = navController,
                        navHost = @Composable {
                            MainNavHost(navController = navController, startDestinations = it)
                        },
                        appState = appState,
                    )
                }
            }
        }
    }
}
