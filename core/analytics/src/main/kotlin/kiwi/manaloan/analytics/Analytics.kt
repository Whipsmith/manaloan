package kiwi.manaloan.analytics

object Analytics {
    private lateinit var analyticsTracker: AnalyticsTracker

    fun init(tracker: AnalyticsTracker) {
        analyticsTracker = tracker
    }

    fun logEvent(name: String, params: Map<String, Any> = emptyMap()) {
        if (::analyticsTracker.isInitialized) {
            analyticsTracker.logEvent(name, params)
        } else {
            error("Analytics is not initialized. Call Analytics.init() first.")
        }
    }
}
