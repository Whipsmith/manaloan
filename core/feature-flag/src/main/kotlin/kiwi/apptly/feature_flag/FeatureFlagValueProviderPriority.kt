package kiwi.apptly.feature_flag

enum class FeatureFlagValueProviderPriority {
    QaOverride,
    RemoteToggled,
    CompileTime,
    Default
}