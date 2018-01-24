package com.dominos.codingchallenge.cheese;

import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.internal.util.Checks.checkNotNull;

@RunWith(AndroidJUnit4.class)
public class CheeseListActivityTest {

    @Rule
    public ActivityTestRule<CheeseListActivity> mActivityTestRule = new ActivityTestRule<>(CheeseListActivity.class);

    @Test
    public void testWelcomeTest(){
        onView(withText(R.string.welcome_text))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testSortedListView(){
        //FIXME: 2. This Android test is failing, it appears that the list of cheeses being displayed is not sorted.
        onView(withId(R.id.cheese_list_view))
                .check(matches(atPosition(0, withText("Abbaye de Belloc"))))
                .check(matches(atPosition(1, withText("Abbaye du Mont des Cats"))))
                .check(matches(atPosition(2, withText("Abertam"))))
                .check(matches(atPosition(3, withText("Abondance"))));
    }

    public static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
        checkNotNull(itemMatcher);
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(final RecyclerView view) {
                RecyclerView.ViewHolder viewHolder = view.findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    // has no item on such position
                    return false;
                }
                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }
}
