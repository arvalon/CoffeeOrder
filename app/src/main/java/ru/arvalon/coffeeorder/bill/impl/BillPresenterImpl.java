package ru.arvalon.coffeeorder.bill.impl;

import java.lang.ref.WeakReference;

import ru.arvalon.coffeeorder.bill.interfaces.IBillModel;
import ru.arvalon.coffeeorder.bill.interfaces.IBillPresenter;
import ru.arvalon.coffeeorder.bill.interfaces.IBillView;
import ru.arvalon.coffeeorder.mainpage.impl.MainPageModelImpl;
import ru.arvalon.coffeeorder.mainpage.impl.MainPagePresenterImpl;
import ru.arvalon.coffeeorder.model.CoffeeOrder;

public class BillPresenterImpl implements IBillPresenter {

    private static BillPresenterImpl instance;

    private BillPresenterImpl(){
        model=BillModelImpl.getInstance();
    }

    public static BillPresenterImpl getInstance(){
        if (instance==null){
            instance=new BillPresenterImpl();
        }
        return instance;
    }

    /** View (Activity) */
    private WeakReference<IBillView> view;

    /** заказ из модели стартовой страницы */
    private CoffeeOrder coffeeOrder;

    private IBillModel model;

    public CoffeeOrder getCoffeeOrder() {
        return coffeeOrder;
    }

    @Override
    public void saveOrder() {
        model.saveOrder(coffeeOrder);
    }

    @Override
    public void setView(IBillView view) {
        this.view=new WeakReference<>(view);
    }

    @Override
    public void unregisterView() {
        this.view=null;
    }

    @Override
    public void init() {
        loadCoffeeOrder();
        if (view!=null){
            view.get().showOrder(coffeeOrder);
        }
    }

    @Override
    public void loadCoffeeOrder() {
        coffeeOrder = MainPageModelImpl.getInstance().getCoffeeOrder();
    }

    @Override
    public void notifySuccsess() {
        if(view!=null){
            view.get().notifySuccsess();
            closeBill();
        }
    }

    @Override
    public void notifyError() {
        if(view!=null){
            view.get().notifyError();
            closeBill();
        }
    }

    @Override
    public void closeBill() {
        if (view!=null){
            view.get().closeBill();
            MainPagePresenterImpl.getInstance().resetOrder();
        }
    }
}