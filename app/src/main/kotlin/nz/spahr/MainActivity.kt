package nz.spahr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nz.spahr.feature.navigation.BottomNavItem
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.navigation.FutureExpenseHome
import nz.spahr.theme.SpahrTheme
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
                    val featureGraphs: List<FeatureNavGraph> = koinInject(named<FeatureNavGraph>())
                    val bottomNavItems: List<BottomNavItem> = koinInject(named<BottomNavItem>())
                    val navController = rememberNavController()

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            NavigationBar {
                                var currentBackStackEntry =
                                    navController.currentBackStackEntryAsState().value
                                val currentDestination = currentBackStackEntry?.destination
                                bottomNavItems.forEach { item ->
                                    val selected =
                                        currentDestination?.let { item.isSelected(it) } == true
                                    NavigationBarItem(
                                        selected = selected,
                                        onClick = { navController.navigate(item.destination) },
                                        icon = {
                                            Icon(
                                                imageVector = item.icon,
                                                contentDescription = item.label
                                            )
                                        },
                                        label = { Text(text = item.label) }
                                    )
                                }
                            }
                        },
                    ) { innerPadding ->
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
