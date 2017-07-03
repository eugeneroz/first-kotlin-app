package com.eugene.tab_navigation

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeRight
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.orhanobut.logger.Logger
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by eugene on 21/06/2017.
 */
@RunWith(AndroidJUnit4::class)
class TabNavigationTest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testOpenActivity() {
        activityTestRule.activity.tabListener = object : TabListener {
            override val TAG: String
                get() = "Mock Tab Listener"

            override fun onTabClicked(position: Int) {
                Logger.t(TAG).d("onTabClicked $position", position)
                Assert.assertEquals(1, position)
            }

            override fun onContainerSelected(position: Int) {
                Logger.t(TAG).d("onContainerSelected $position", position)
                Assert.assertEquals(1, position)
            }
        }
    }

    @Test
    fun testSwipeFromFirstToSecondTab() {
        onView(withId(R.id.container)).perform(swipeRight()).check(matches(isDisplayed()))
    }
}