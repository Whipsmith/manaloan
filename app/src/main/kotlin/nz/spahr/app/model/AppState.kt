package nz.spahr.app.model

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableMap
import nz.spahr.feature_flag.FeatureFlag


@Stable
sealed interface AppState {
    data object Loading : AppState
    data class Data(
        val featureMap: ImmutableMap<FeatureFlag, Boolean>
    ) : AppState
}