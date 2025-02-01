package nz.spahr.feature_flag

enum class FeatureFlagValueProviderPriority {
    QaOverride,
    RemoteToggled,
    CompileTime,
    Default
}