package com.example.watch

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf

@RunWith(AndroidJUnit4::class)
class BundleTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testSpinner() {
        onView(withId(R.id.list_spinner)).perform(click())
        onData(Matchers.equalTo("Most Popular Movies")).perform(click())

        onView(withId(R.id.search)).perform(click())

    }

    @After
    fun teardown() {
        scenario.close()
    }
    /*
    @Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun search(){
        onView(withId(R.id.list_spinner)).perform(click())
        onData(Matchers.equalTo("Most Popular Movies")).perform(click())
        onView(withId(R.id.search)).perform(click())
    }
 */
}