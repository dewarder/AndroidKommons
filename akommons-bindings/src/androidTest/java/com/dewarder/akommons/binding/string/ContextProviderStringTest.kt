package com.dewarder.akommons.binding.string

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.TestActivity
import com.dewarder.akommons.binding.common.string.BaseStringTest
import com.dewarder.akommons.binding.common.string.TestableString
import org.junit.Rule

class ContextProviderStringTest : BaseStringTest() {

    class Activity : TestActivity() {
        override fun initContextProvider() = TestStringContextProvider(this)
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableString(): TestableString
            = activityRule.activity.getContextProvider()
}