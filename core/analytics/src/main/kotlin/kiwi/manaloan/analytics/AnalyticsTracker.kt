package kiwi.manaLoan.analytics

interface AnalyticsTracker {
    fun logEvent(name: String, params: Map<String, Any> = emptyMap())
}