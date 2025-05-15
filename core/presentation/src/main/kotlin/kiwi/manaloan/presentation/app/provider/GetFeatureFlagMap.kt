package kiwi.manaLoan.presentation.app.provider

import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kiwi.manaLoan.feature_flag.FeatureFlag
import kiwi.manaLoan.feature_flag.FeatureFlagValueProvider

class GetFeatureFlagMap(
    private val featureFlags: List<FeatureFlag>,
    private val featureFlagValueProviders: List<FeatureFlagValueProvider>,
) {

    operator fun invoke(): Flow<Map<FeatureFlag, Boolean>> =
        flow<Map<FeatureFlag, Boolean>> {
            emit(featureFlags.associateWith { getValue(it) })
            awaitCancellation()
        }

    private suspend fun getValue(featureFlag: FeatureFlag) =
        featureFlagValueProviders.sortedBy { it.priority }
            .firstNotNullOfOrNull { it.isFlagEnabled(featureFlag) } == true
}