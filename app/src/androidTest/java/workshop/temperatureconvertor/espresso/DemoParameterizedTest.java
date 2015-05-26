package workshop.temperatureconvertor.espresso;


import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import workshop.temperatureconvertor.MainActivity;
import workshop.temperatureconvertor.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(Parameterized.class)
public class DemoParameterizedTest {

    private final String celsius;
    private final String fahrenheit;

    @Rule
    public ActivityTestRule activityActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"0", "32.0"},
                {"1", "33.8"}
        });
    }

    public DemoParameterizedTest(String celsius, String fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    @Test
    public void convertDataFromCelsiusToFahrenheit() {
        onView(withId(R.id.celsius_value)).perform(ViewActions.typeText(this.celsius));
        onView(withId(R.id.fahrenheit_value)).check(matches(withText(this.fahrenheit)));
    }

}
