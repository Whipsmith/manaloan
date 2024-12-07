package nz.spahr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.navigation.FutureExpenseHome
import nz.spahr.theme.SpahrTheme
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpahrTheme {
                KoinAndroidContext {
                    val featureGraphs: List<FeatureNavGraph> = koinInject()
                    val navController = rememberNavController()
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = FutureExpenseHome,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            featureGraphs.forEach { feature ->
                                feature.navigationGraph(this, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}
