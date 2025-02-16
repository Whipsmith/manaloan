package kiwi.autopocket.feature_flag

enum class FeatureFlagValueProviderPriority {
    QaOverride,
    RemoteToggled,
    CompileTime,
    Default
}