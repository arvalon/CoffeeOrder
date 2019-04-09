package ru.arvalon.coffeeorder.mainpage;

import org.junit.Before;
import org.junit.Test;

import ru.arvalon.coffeeorder.model.CoffeeOrder;
import ru.arvalon.coffeeorder.mainpage.impl.MainPageModelImpl;
import ru.arvalon.coffeeorder.mainpage.impl.MainPagePresenterImpl;
import ru.arvalon.coffeeorder.mainpage.interfaces.CoffeeOrderView;
import ru.arvalon.coffeeorder.mainpage.interfaces.IMainPageModel;
import ru.arvalon.coffeeorder.mainpage.interfaces.IMainPagePresenter;
import ru.arvalon.coffeeorder.model.ICoffeeOrder;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by arvalon on 25.03.2018.
 */

public class MockitoPresenterTests {

    ICoffeeOrder cOrder; //CoffeeOrder cOrder;
    CoffeeOrderView view;
    IMainPagePresenter presenter;
    IMainPageModel model;

    @Before
    public void Init(){
        cOrder = mock(ICoffeeOrder.class); // cOrder = mock(CoffeeOrder.class);

        view = mock(CoffeeOrderView.class);

        presenter= MainPagePresenterImpl.getInstance();
        presenter.setView(view);
        model= MainPageModelImpl.getInstance();


    }

    @Test
    public void testCoffeeOrder(){
        when(cOrder.getCoffeeCount()).thenReturn(10);
        when(cOrder.getTotalPrice()).thenReturn(2.5d);

        assertEquals(10,cOrder.getCoffeeCount());
        assertEquals(2.5d,cOrder.getTotalPrice());
    }

    /** Жём по кнопке "+" и увеличивается значение в поле кол-во*/
    @Test
    public void testIncreasePresenter(){
        presenter.incrementCoffeeCount();

        verify(view).updateCoffeeCount();
        verify(view).updateTotalPrice();

        verifyNoMoreInteractions(view);
    }

    /** Жём по кнопке "-" и уменьшается значение в поле кол-во*/
    @Test
    public void testDecreasePresenter(){
        presenter.decrementCoffeeCount();

        verify(view).updateCoffeeCount();
        verify(view).updateTotalPrice();

        verifyNoMoreInteractions(view);
    }

    /** измелил цену - изменилась цена во view */
    @Test
    public void testPresenterPriceChange(){

        double price =10d;

        //IMainPageModel model = mock(IMainPageModel.class);
        //when(model.getPrice()).thenReturn(price);

        presenter.setPrice(price);

        assertEquals(price,presenter.getPrice());

    }

    /** тестируем verify*/
    @Test
    public void verifyPresenterCall(){
        IMainPagePresenter presenter = mock(MainPagePresenterImpl.class);
        when(presenter.getPrice()).thenReturn(20d);

        presenter.setPrice(20d);

        verify(presenter).setPrice(20d);
    }

    /** spy */
    @Test
    public void testModel(){
        IMainPageModel spyModel = spy(model);
        //doNothing().when(spyModel).log(anyString());
        //doCallRealMethod().when(spyModel).log("test");

        doAnswer(invocation -> {
            System.out.println("Hello answer");
            return null;
        }).when(spyModel).log(anyString());

        //spyModel.log("log test");
        //spyModel.log_clear("clear log test");

        given(spyModel.getPrice()).willReturn(3d);
        assertEquals(3d,spyModel.getPrice());

        reset(spyModel); // просто так

        //given(model.getPrice()).willReturn(3d);
        assertEquals(5d,model.getPrice());

    }
}
