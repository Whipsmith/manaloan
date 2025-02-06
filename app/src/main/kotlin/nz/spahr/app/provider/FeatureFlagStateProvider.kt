package nz.spahr.app.provider

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import nz.spahr.app.model.AppStateDataBuilder
import nz.spahr.app.model.AppStateProvider
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.FeatureFlagValueProvider

class FeatureFlagStateProvider(
    private val featureFlags: List<FeatureFlag>,
    private val featureFlagValueProviders: List<FeatureFlagValueProvider>,
) : AppStateProvider {
    override val updates: Flow<AppStateDataBuilder.() -> Unit>
        get() = flow<Map<FeatureFlag, Boolean>> {
            emit(featureFlags.associateWith { getValue(it) })
        }.map {
            {
                features(it)
            }
        }

    private suspend fun getValue(featureFlag: FeatureFlag) =
        featureFlagValueProviders.sortedBy { it.priority }
            .firstNotNullOfOrNull { it.isFlagEnabled(featureFlag) } == true
}