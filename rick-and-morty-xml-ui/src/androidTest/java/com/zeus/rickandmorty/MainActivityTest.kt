package com.zeus.rickandmorty

import androidx.navigation.findNavController
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testMainActivityOnHomeFragment() {
        val scenario = activityRule.scenario

        scenario.onActivity {
            val navController = it.findNavController(R.id.nav_host)

            assertEquals(navController.currentDestination?.id, R.id.home_fragment)
        }
    }
}
