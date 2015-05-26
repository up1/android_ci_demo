package workshop.temperatureconvertor.espresso;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import workshop.temperatureconvertor.LongListActivity;
import workshop.temperatureconvertor.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DemoLongListviewTest {

    public static final String LAST_ITEM = "item: 99";
    private static final String TEXT_ITEM_30 = "item: 30";
    private static final String TEXT_ITEM_30_SELECTED = "30";
    private static final String TEXT_ITEM_60 = "item: 60";
    @Rule
    public ActivityTestRule<LongListActivity> longListActivityActivityTestRule = new ActivityTestRule<LongListActivity>(LongListActivity.class);


    @Test
    public void lastItem_notDisplayed_if_list_not_scrolldown() {
        onView(withText(LAST_ITEM)).check(doesNotExist());
    }

    @Test
    public void lastItem_NotDisplayed() {
        onView(withText(LAST_ITEM)).check(doesNotExist());
    }

    @Test
    public void row_Click() {
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click());

        onView(withId(R.id.selection_row_value))
                .check(matches(withText(TEXT_ITEM_30_SELECTED)));
    }

    @Test
    public void toggle_Click() {
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).perform(click());

        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).check(matches(isChecked()));
    }

    @Test
    public void toggle_ClickDoesntPropagate() {
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click());

        onRow(TEXT_ITEM_60).onChildView(withId(R.id.rowToggleButton)).perform(click());

        onView(ViewMatchers.withId(R.id.selection_row_value))
                .check(matches(withText(TEXT_ITEM_30_SELECTED)));
    }

    private static DataInteraction onRow(String value) {
        return onData(allOf(
                is(instanceOf(Map.class)), hasEntry(equalTo(LongListActivity.ROW_TEXT), is(value))));
    }




}
