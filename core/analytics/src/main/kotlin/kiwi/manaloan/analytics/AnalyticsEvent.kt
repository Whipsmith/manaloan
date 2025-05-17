package kiwi.manaloan.analytics

open class AnalyticsEvent(private val name: String, private val params: Map<String, Any>) {
    fun track() {
        Analytics.logEvent(name, params)
    }
}