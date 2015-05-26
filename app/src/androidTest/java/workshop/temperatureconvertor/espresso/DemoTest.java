package workshop.temperatureconvertor.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import workshop.temperatureconvertor.MainActivity;
import workshop.temperatureconvertor.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DemoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test public void
    convert_temperator_from_0_celsius_should_32_fahrenheit() {
        onView(withId(R.id.celsius_value)).perform(typeText("0"));

        onView(withId(R.id.fahrenheit_value)).check(matches(withText("32.0")));
    }



}
