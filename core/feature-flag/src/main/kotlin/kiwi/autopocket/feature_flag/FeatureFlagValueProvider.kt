package kiwi.autopocket.feature_flag

interface FeatureFlagValueProvider {
    val priority: FeatureFlagValueProviderPriority
    suspend fun isFlagEnabled(flag: FeatureFlag): Boolean?
}