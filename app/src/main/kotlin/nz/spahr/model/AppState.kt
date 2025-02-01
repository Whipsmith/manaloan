package nz.spahr.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toPersistentHashMap
import nz.spahr.feature_flag.FeatureFlag

@Composable
fun rememberAppState(featureMap: Map<FeatureFlag, Boolean>): AppState {
    return remember(featureMap) {
        AppState(featureMap.toPersistentHashMap())
    }
}

@Stable
class AppState(
    val featureMap: ImmutableMap<FeatureFlag, Boolean>
) {
}