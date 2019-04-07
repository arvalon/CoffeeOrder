package ru.arvalon.coffeeorder.bill;

import android.content.Context;
import androidx.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import io.realm.Realm;
import ru.arvalon.coffeeorder.bill.impl.BillPresenterImpl;
import ru.arvalon.coffeeorder.bill.interfaces.IBillModel;
import ru.arvalon.coffeeorder.bill.interfaces.IBillView;
import ru.arvalon.coffeeorder.model.CoffeeOrder;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class BillPresenterTest {

    @Mock IBillView view;

    @Mock IBillModel model;

    BillPresenterImpl presenter;

    @Before
    public void setUp(){
        System.out.println("@Before setUp");

        Context ctx = InstrumentationRegistry.getContext();

        Realm.init(ctx);

        presenter = BillPresenterImpl.getInstance();
        presenter.setView(view);
    }

    @Test
    public void initPresenter(){

        System.out.println("initPresenter");

        presenter.init();

        assertNotNull(presenter.getCoffeeOrder());

        verify(view).showOrder(any(CoffeeOrder.class));
        verifyNoMoreInteractions(view);
    }

    @Test
    public void testLog(){
        System.out.println("testLog");
    }
}