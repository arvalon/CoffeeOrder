package ru.arvalon.coffeeorder.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Кофейный заказ
 * Created by arvalon on 25.03.2018.
 */

public class CoffeeOrder extends RealmObject implements ICoffeeOrder {

    private static final double DEFAULT_COFFEE_PRICE = 5.0;

    /** UUID в качестве PK */
    @PrimaryKey
    private String PK= UUID.randomUUID().toString();

    /** Стоимость 1 порции */
    private double mCoffeePrice;

    /** количество порций */
    private int mCoffeeCount;

    /** итоговая стоимость заказа */
    private double mTotalPrice;

    public CoffeeOrder() {
        mCoffeeCount = 0;
        mTotalPrice = 0;
        this.mCoffeePrice = DEFAULT_COFFEE_PRICE;
    }

    @Override
    public void setCoffeeCount(int count) {
        if (count >= 0) {
            this.mCoffeeCount = count;
        }
        calculateTotalPrice();
    }

    @Override
    public void setCoffeePrice(double price){
        mCoffeePrice=price;
        calculateTotalPrice();
    }

    @Override
    public int getCoffeeCount() {
        return mCoffeeCount;
    }

    @Override
    public void incrementCoffeeCount() {
        mCoffeeCount++;
        calculateTotalPrice();
    }

    @Override
    public void decrementCoffeeCount() {
        if (mCoffeeCount > 0) {
            mCoffeeCount--;
            calculateTotalPrice();
        }
    }

    @Override
    public double getPrice(){
        return mCoffeePrice;
    }

    @Override
    public double getTotalPrice() {
        return mTotalPrice;
    }

    private void calculateTotalPrice() {
        mTotalPrice = mCoffeePrice * mCoffeeCount;
    }
}