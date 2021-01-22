package ru.denisshishin.task3foxminded;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.denisshishin.task3foxminded.collections.CollectionsFragment;
import ru.denisshishin.task3foxminded.maps.MapsFragment;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITests {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void instanceOfCollectionsFragmentIsSavedWhenRotating() {
        MainActivity mainActivityCollectionsFragment = activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.tietInputNumberCollectionsFragment)).perform(replaceText("50000"));
        mainActivityCollectionsFragment.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        onView(withId(R.id.tietInputNumberCollectionsFragment)).check(matches(withText("50000")));
    }


    @Test
    public void instanceOfMapsFragmentIsSavedWhenRotating() {
        MainActivity mainActivityMapsFragment = activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.tietInputNumberMapsFragment)).perform(replaceText("70000"));
        mainActivityMapsFragment.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        onView(withId(R.id.tietInputNumberMapsFragment)).check(matches(withText("70000")));
    }

    @Test
    public void viewPagerIsDisplayed() {
        onView(withId(R.id.viewPager)).check(matches(isDisplayed()));
    }

    @Test
    public void toastMessageInCollectionsFragmentIsDisplayed() {
        Bundle bundle = new Bundle();
        FragmentFactory fragmentFactory = new FragmentFactory();
        FragmentScenario.launchInContainer(CollectionsFragment.class, bundle, R.style.Theme_Task3Foxminded, fragmentFactory);
        onView(withId(R.id.btnCollectionsFragment)).perform(click());
        onView(withText("Please input number")).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));
    }

    @Test
    public void toastMessageInMapsFragmentIsDisplayed() {
        Bundle bundle = new Bundle();
        FragmentFactory fragmentFactory = new FragmentFactory();
        FragmentScenario.launchInContainer(MapsFragment.class, bundle, R.style.Theme_Task3Foxminded, fragmentFactory);
        onView(withId(R.id.btnMapsFragment)).perform(click());
        onView(withText("Please input number")).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));
    }


}






