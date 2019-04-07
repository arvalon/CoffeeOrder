package ru.arvalon.coffeeorder.mainpage.impl;

import android.util.Log;

import ru.arvalon.coffeeorder.model.CoffeeOrder;
import ru.arvalon.coffeeorder.mainpage.interfaces.IMainPageModel;

/**
 * Created by arvalon on 26.03.2018.
 */

public class MainPageModelImpl implements IMainPageModel {

    private static MainPageModelImpl instance;

    private CoffeeOrder coffeeOrder;

    private MainPageModelImpl(){
        createCoffeeOrder();
    }

    public static IMainPageModel getInstance(){
        if(instance==null){
            instance=new MainPageModelImpl();
        }
        return instance;
    }

    /** создать новый кофейный заказ */
    @Override
    public void createCoffeeOrder() {
        coffeeOrder=new CoffeeOrder();
    }

    @Override
    public CoffeeOrder getCoffeeOrder() {
        return coffeeOrder;
    }

    @Override
    public double getPrice() {
        return coffeeOrder.getPrice();
    }

    @Override
    public double getTotalPrice() {
        return coffeeOrder.getTotalPrice();
    }

    @Override
    public int getCoffeeCount() {
        return coffeeOrder.getCoffeeCount();
    }

    @Override
    public void incrementCoffeeCount() {coffeeOrder.incrementCoffeeCount();}

    @Override
    public void decrementCoffeeCount() {coffeeOrder.decrementCoffeeCount();}

    @Override
    public void setPrice(double price) {
        coffeeOrder.setCoffeePrice(price);
    }
}
