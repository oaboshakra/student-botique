package com.studentbotique;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.runner.RunWith;
import org.junit.Test;
import com.studentbotique.ui.LandingActivity;
@RunWith(AndroidJUnit4.class)
public class StudentUserEspressoTest {

    ActivityScenario<LandingActivity> activityScenario;

    @Test
    public void testStudentWithSilverMembership() {
        activityScenario = ActivityScenario.launch(LandingActivity.class);
        onView(withId(R.id.depositBox)).perform(typeText("200"));
        onView(withId(R.id.membershipSpinner)).perform(click());
        onData(is("Silver"))).perform(click());
        onView(withId(R.id.calculateDiscountButton)).perform(click());
        onView(withId(R.id.totalDiscountLabel)).check(matches(withText("$20.0")));
    }

    @Test
    public void testStudentWithGoldMembership() {
        activityScenario = ActivityScenario.launch(LandingActivity.class);
        onView(withId(R.id.depositBox)).perform(typeText("200"));
        onView(withId(R.id.membershipSpinner)).perform(click());
        onData((is("Gold"))).perform(click());
        onView(withId(R.id.calculateDiscountButton)).perform(click());
        onView(withId(R.id.totalDiscountLabel)).check(matches(withText("$30.0")));
    }

    @Test
    public void testStudentWithPlatinumMembership() {
        activityScenario = ActivityScenario.launch(LandingActivity.class);
        onView(withId(R.id.depositBox)).perform(typeText("200"));
        onView(withId(R.id.membershipSpinner)).perform(click());
        onData(is("Platinum"))).perform(click());
        onView(withId(R.id.calculateDiscountButton)).perform(click());
        onView(withId(R.id.totalDiscountLabel)).check(matches(withText("$40.0")));
    }

}
