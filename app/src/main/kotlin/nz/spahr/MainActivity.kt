package nz.spahr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.future_expense.presentation.home.FutureExpenseHome
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
                    val mainNavItems: List<MainNavItem> = koinInject(named<MainNavItem>())
                    val navController = rememberNavController()

                    var currentBackStackEntry =
                        navController.currentBackStackEntryAsState().value
                    val currentDestination: NavDestination? =
                        currentBackStackEntry?.destination
                    val displayNavBar = mainNavItems.any { item ->
                        currentDestination?.let { item.isSelected(it) } == true
                    }

                    val adaptiveInfo = currentWindowAdaptiveInfo()
                    val customNavSuiteType = with(adaptiveInfo) {
                        if (displayNavBar) {
                            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
                        } else {
                            NavigationSuiteType.None
                        }
                    }

//                    TODO: Wrap this in a scaffold to house nav drawer and account image? (See google photos)
                    NavigationSuiteScaffold(
                        modifier = Modifier.fillMaxSize(),
                        layoutType = customNavSuiteType,
                        navigationSuiteItems = {
                            mainNavItems.forEach { item ->
                                val selected =
                                    currentDestination?.let { item.isSelected(it) } == true
                                item(
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
                        },
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = FutureExpenseHome,
                            modifier = Modifier,
                            enterTransition = {
                                fadeIn(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideIntoContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                                )
                            },
                            exitTransition = {
                                fadeOut(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseOut),
                                    towards = AnimatedContentTransitionScope.SlideDirection.End
                                )
                            }
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
