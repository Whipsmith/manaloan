package nz.spahr.analytics

interface AnalyticsTracker {
    fun logEvent(name: String, params: Map<String, Any> = emptyMap())
}