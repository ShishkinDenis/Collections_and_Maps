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
        MainActivity mainActivityOne = activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.tietInputNumberCollectionsFragment)).perform(replaceText("50000"));
        mainActivityOne.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        onView(withId(R.id.tietInputNumberCollectionsFragment)).check(matches(withText("50000")));
    }

    //@Before
    //ViewPager Tests

//    @Test
//    public void instanceOfMapsFragmentIsSavedWhenRotating(){
//        MainActivity mainActivityThree = activityTestRule.launchActivity(new Intent());
//        onView(withId(R.id.tietInputNumberMapsFragment)).perform(replaceText("100000"));
//        mainActivityThree.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE );
//        onView(withId(R.id.tietInputNumberMapsFragment)).check(matches(withText("100000")));
//    }
//
//    @Test
//    public void toastMessageInMapsFragmentIsDisplayed() {
//        MainActivity mainActivityFour = activityTestRule.launchActivity(new Intent());
//        onView(withId(R.id.btnMapsFragment)).perform(click());
//        onView(withText("Please input number")).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));

    @Test
    public void testCollectionsFragment() {
        Bundle bundle = new Bundle();
        FragmentFactory fragmentFactory = new FragmentFactory();
        FragmentScenario.launchInContainer(CollectionsFragment.class, bundle, R.style.Theme_Task3Foxminded, fragmentFactory);
        onView(withId(R.id.btnCollectionsFragment)).perform(click());
    }

    @Test
    public void testMapsFragment() {
        Bundle bundle = new Bundle();
        FragmentFactory fragmentFactory = new FragmentFactory();
        FragmentScenario.launchInContainer(MapsFragment.class, bundle, R.style.Theme_Task3Foxminded, fragmentFactory);
        onView(withId(R.id.btnMapsFragment)).perform(click());
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
    //после выполнения операциb texrView не равно 0ms

}

    //то же самое для Maps
    //показывается ли и скрывается прогресс бар



