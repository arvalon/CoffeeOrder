package ru.arvalon.coffeeorder.general;

import org.junit.Before;
import org.junit.Test;

// работает
import ru.arvalon.coffeeorder.model.CoffeeOrder;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


//import static junit.framework.TestCase.assertNotNull;  // тоже работает
//import static org.junit.Assert.assertNotNull; // и это тоже работает

//копипаста из учебного проекта
//import static junit.framework.TestCase.assertEquals;
//import static org.junit.Assert.assertNotNull;


/**
 * Unit-тест кофейного заказа
 * Created by arvalon on 25.03.2018.
 */

public class CoffeOrderUnitTests {

    private final static double PRICE_TEST = 5.0d;
    private CoffeeOrder mOrder;

    @Before
    public void setUp(){
        mOrder = new CoffeeOrder();
    }

    @Test
    public void orderIsNotNull(){
        assertNotNull(mOrder);
    }

    @Test
    public void orderDecrement(){
        mOrder.decrementCoffeeCount();
        assertEquals(0,mOrder.getCoffeeCount());

        mOrder.setCoffeeCount(25);
        mOrder.decrementCoffeeCount();
        assertEquals(24,mOrder.getCoffeeCount());

    }

    @Test
    public void orderIncrement(){

        mOrder.incrementCoffeeCount();
        assertEquals(1,mOrder.getCoffeeCount());

        mOrder.setCoffeeCount(25);
        mOrder.incrementCoffeeCount();
        assertEquals(26,mOrder.getCoffeeCount());
    }

    @Test
    public void orderTotalPrice(){
        assertEquals(0.0d,mOrder.getTotalPrice());

        mOrder.setCoffeeCount(25);
        assertEquals(PRICE_TEST*25,mOrder.getTotalPrice());
    }

    @Test
    public void orderSetCoffeeCount(){
        assertEquals(0,mOrder.getCoffeeCount());

        mOrder.setCoffeeCount(25);
        assertEquals(25,mOrder.getCoffeeCount());
    }

    @Test
    public void changePrice(){
        mOrder.setCoffeeCount(2);
        mOrder.setCoffeePrice(2.0d);
        assertEquals(4d,mOrder.getTotalPrice());

        mOrder.setCoffeePrice(3.0d);
        assertEquals(6.0d,mOrder.getTotalPrice());

        mOrder.decrementCoffeeCount();
        assertEquals(3.0d,mOrder.getTotalPrice());

        mOrder.incrementCoffeeCount();
        mOrder.incrementCoffeeCount();
        assertEquals(9.0d,mOrder.getTotalPrice());

    }

}
