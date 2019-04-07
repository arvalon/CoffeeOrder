package ru.arvalon.coffeeorder.mainpage.impl;

import android.util.Log;

import java.lang.ref.WeakReference;

import ru.arvalon.coffeeorder.mainpage.interfaces.CoffeeOrderView;
import ru.arvalon.coffeeorder.mainpage.interfaces.IMainPageModel;
import ru.arvalon.coffeeorder.mainpage.interfaces.IMainPagePresenter;

/**
 * Created by arvalon on 26.03.2018.
 */

public class MainPagePresenterImpl implements IMainPagePresenter {

    private static MainPagePresenterImpl instance;

    IMainPageModel model;

    private WeakReference<CoffeeOrderView> view;

    private MainPagePresenterImpl(){
        model = MainPageModelImpl.getInstance();
    }

    public static IMainPagePresenter getInstance(){
        if(instance==null){
            instance=new MainPagePresenterImpl();
        }
        return instance;
    }

    @Override
    public void setView(CoffeeOrderView view) {
        this.view=new WeakReference<>(view);
    }

    @Override
    public void unregisterView() {
        this.view=null;
    }

    @Override
    public double getPrice() {
        return model.getPrice();
    }

    @Override
    public double getTotalPrice() {
        return model.getTotalPrice();
    }

    @Override
    public int getCoffeeCount() {
        return model.getCoffeeCount();
    }

    @Override
    public void incrementCoffeeCount() {
        model.incrementCoffeeCount();
        updateView();
    }

    @Override
    public void decrementCoffeeCount() {
        model.decrementCoffeeCount();
        updateView();
    }

    @Override
    public void setPrice(double price) {
        model.setPrice(price);
        updateView();
    }

    @Override
    public void updateView() {
        if (view!=null){
            view.get().updateCoffeeCount();
            view.get().updateTotalPrice();
        }
    }

    @Override
    public void resetOrder() {
        log("тут надо запустить цепочку приводящую к сбросу предыдущего заказа и установке нового");
        if (view!=null){
            model.createCoffeeOrder();
            view.get().updateCoffeeCount();
            view.get().updateTotalPrice();
        }
    }
}
