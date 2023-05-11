package com.example.watch

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BundleTest {

    @Test
    fun search(){
        onView(withId(R.id.list_spinner)).perform(click())
        onData(Matchers.equalTo("Most Popular Movies")).perform(click())
        onView(withId(R.id.search)).perform(click())
        //onView(withId(R.id.recyclerview)).check(Matchers.equalTo(isDisplayed()))
    }

}