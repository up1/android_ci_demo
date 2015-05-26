package workshop.temperatureconvertor.espresso;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import workshop.temperatureconvertor.MainActivity;
import workshop.temperatureconvertor.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloEspressoTest {

    @Rule
    public ActivityTestRule activityActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void celsiusDisplay() {
        onView(withText("Celsius")).check(matches(isDisplayed()));
    }

    @Test
    public void convertDataFromCelsiusToFahrenheit() {
        onView(withId(R.id.celsius_value)).perform(ViewActions.typeText("0"));
        onView(withId(R.id.fahrenheit_value)).check(matches(withText("32.0")));
    }

    @Test
    public void convertDataFromFahrenheitToCelsius() {
        onView(withId(R.id.fahrenheit_value)).perform(ViewActions.typeText("32"));
        onView(withId(R.id.celsius_value)).check(matches(withText("0.0")));
    }

}
