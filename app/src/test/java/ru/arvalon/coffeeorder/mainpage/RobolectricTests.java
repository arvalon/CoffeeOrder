package ru.arvalon.coffeeorder.mainpage;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import ru.arvalon.coffeeorder.BuildConfig;
import ru.arvalon.coffeeorder.R;
import ru.arvalon.coffeeorder.mainpage.impl.MainActivity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by arvalon on 29.03.2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTests {

    MainActivity activity;

    EditText edit_price;
    TextView total_price;

    Button button_reduce;
    Button button_increase;

    @Before
    public void init(){
        //activity = Robolectric.setupActivity(MainActivity.class);
        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();

        edit_price = activity.findViewById(R.id.coffee_price);
        total_price = activity.findViewById(R.id.total_price);

        button_reduce = activity.findViewById(R.id.coffee_decrement);
        button_increase = activity.findViewById(R.id.coffee_increment);
    }

    @Test
    public void helloWorld() throws Exception{

        button_increase.performClick();

        String result = total_price.getText().toString();
        String correct = "5.0";

        assertThat(result,equalTo(correct));

        button_increase.performClick();
        assertThat(total_price.getText().toString(),equalTo("10.0"));

        edit_price.setText("2");
        assertThat(total_price.getText().toString(),equalTo("4.0"));

    }
}
