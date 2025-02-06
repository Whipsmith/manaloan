package nz.spahr.app.provider

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.FeatureFlagValueProvider

class GetFeatureFlagMap(
    private val featureFlags: List<FeatureFlag>,
    private val featureFlagValueProviders: List<FeatureFlagValueProvider>,
) {

    operator fun invoke(): Flow<Map<FeatureFlag, Boolean>> =
        flow<Map<FeatureFlag, Boolean>> {
            emit(featureFlags.associateWith { getValue(it) })
        }

    private suspend fun getValue(featureFlag: FeatureFlag) =
        featureFlagValueProviders.sortedBy { it.priority }
            .firstNotNullOfOrNull { it.isFlagEnabled(featureFlag) } == true
}