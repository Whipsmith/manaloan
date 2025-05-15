package kiwi.manaLoan.feature_flag

enum class FeatureFlagValueProviderPriority {
    QaOverride,
    RemoteToggled,
    CompileTime,
    Default
}