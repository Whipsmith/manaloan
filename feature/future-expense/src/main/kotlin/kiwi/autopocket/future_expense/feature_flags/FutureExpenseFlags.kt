package kiwi.autopocket.future_expense.feature_flags

import kiwi.apptly.feature_flag.FeatureFlag
import kiwi.apptly.feature_flag.FeatureFlagValueProvider
import kiwi.apptly.feature_flag.FeatureFlagValueProviderPriority
import java.time.LocalDateTime
import java.time.ZoneOffset


enum class FutureExpenseFlags(val activationDate: Long?) : FeatureFlag {
    TestFlagTrue(0L) {
        override val id: String
            get() = TestFlagTrue::class.toString()
        override val description: String = "A flag to test flags. Enabled"
    },

    TestFlagFalse(null) {
        override val id: String
            get() = TestFlagFalse::class.toString()
        override val description: String = "A flag to test flags. Disabled"
    },

    FutureExpenseFeature(LocalDateTime.of(2025, 2, 1, 0, 0).toEpochSecond(ZoneOffset.UTC)) {
        override val id: String = "FutureExpense"
        override val description: String = "Our main test feature"
    };

    companion object : FeatureFlagValueProvider {
        override val priority: FeatureFlagValueProviderPriority =
            FeatureFlagValueProviderPriority.Default

        override suspend fun isFlagEnabled(flag: FeatureFlag): Boolean? {
            if (flag is FutureExpenseFlags) return flag.activationDate != null
            return null
        }

    }
}