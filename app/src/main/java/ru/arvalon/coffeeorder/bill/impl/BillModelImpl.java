package ru.arvalon.coffeeorder.bill.impl;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import ru.arvalon.coffeeorder.bill.interfaces.IBillModel;
import ru.arvalon.coffeeorder.bill.interfaces.IBillPresenter;
import ru.arvalon.coffeeorder.model.CoffeeOrder;

public class BillModelImpl implements IBillModel, RealmChangeListener<RealmResults<CoffeeOrder>> {

    private static BillModelImpl instance;

    private BillModelImpl(){
        realm=Realm.getDefaultInstance();
    }

    public static IBillModel getInstance(){
        if (instance==null){
            instance = new BillModelImpl();

            instance.coffeeOrder=instance.realm.where(CoffeeOrder.class).findAll();

            instance.coffeeOrder.addChangeListener(instance);

        }
        return instance;
    }

    private Realm realm;

    private RealmResults<CoffeeOrder> coffeeOrder;

    @Override
    public void saveOrder(CoffeeOrder order) {
        log("Save to ORM...");

        realm.executeTransactionAsync(
                realm -> realm.insertOrUpdate(order),

                () -> {
                    log("Realm.Transaction.OnSuccess");
                    BillPresenterImpl.getInstance().notifySuccsess();},

                error ->{
                    log("Realm.Transaction.OnError ");
                    error.printStackTrace();
                    BillPresenterImpl.getInstance().notifyError();
                });
    }

    @Override
    public void onChange(RealmResults<CoffeeOrder> coffeeOrders) {
        log("Realm onChange");
    }
}
