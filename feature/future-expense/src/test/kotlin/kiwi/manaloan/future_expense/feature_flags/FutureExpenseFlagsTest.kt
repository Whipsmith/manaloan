package kiwi.manaloan.future_expense.feature_flags

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import kiwi.manaloan.feature_flag.FeatureFlag
import kiwi.manaloan.feature_flag.FeatureFlagValueProvider
import org.junit.Test

class FutureExpenseFlagsTest {
    private val underTest: FeatureFlagValueProvider = FutureExpenseFlags

    @Test
    fun `test that a flag with an activated date returns true`() = runTest {
        val actual = underTest.isFlagEnabled(FutureExpenseFlags.TestFlagTrue)
        assertThat(actual).isTrue()
    }

    @Test
    fun `test that a flag without an activated date, returns false`() = runTest {
        val actual = underTest.isFlagEnabled(FutureExpenseFlags.TestFlagFalse)
        assertThat(actual).isFalse()
    }

    @Test
    fun `test that an unknown flag returns null`() = runTest {
        val mockFlag = object : FeatureFlag {
            override val id: String = "test id"
            override val description: String = "test description"
        }

        val actual = underTest.isFlagEnabled(mockFlag)

        assertThat(actual).isNull()
    }
}