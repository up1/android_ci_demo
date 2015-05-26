package workshop.temperatureconvertor.espresso;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

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
public class FlowConvertTemperatureFahrenheitToCelsiusTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private String fahrenheit;
    private String celsius;

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"32", "0.0"},
                {"64", "17.77777777777778"}
        });
    }

    public FlowConvertTemperatureFahrenheitToCelsiusTest(String fahrenheit, String celsius) {
        this.fahrenheit = fahrenheit;
        this.celsius = celsius;
    }

    @Test
    public void convert() {
        onView(withId(R.id.fahrenheit_value)).perform(ViewActions.typeText(this.fahrenheit));
        onView(withId(R.id.celsius_value)).check(matches(withText(this.celsius)));
    }

}
