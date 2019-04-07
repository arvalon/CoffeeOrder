package ru.arvalon.coffeeorder;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("ru.arvalon.coffeeorder", appContext.getPackageName());
    }

    @Test
    public void helloWorld(){
        View view = Mockito.mock(View.class);
        when(view.performClick()).then(invocation -> {
            System.out.println("Click on view");
            return null;
        });

        view.performClick();
    }
}
