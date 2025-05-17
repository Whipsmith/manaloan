package kiwi.manaloan.feature_flag

enum class FeatureFlagValueProviderPriority {
    QaOverride,
    RemoteToggled,
    CompileTime,
    Default
}