package kiwi.manaloan.feature_flag

fun Any.isFeatureEnabled(valueFunction: (FeatureFlag) -> Boolean): Boolean {
    return (this as? Flagged)?.featureFlag?.let {
        valueFunction(it)
    } != false
}

suspend fun Any.isFeatureEnabledAsync(valueFunction: suspend (FeatureFlag) -> Boolean): Boolean {
    return (this as? Flagged)?.featureFlag?.let {
        valueFunction(it)
    } != false
}
