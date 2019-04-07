package ru.arvalon.coffeeorder.model;

/**
 * Общие операции над заказом
 * Created by arvalon on 27.03.2018.
 */

public interface IOrderOperation {
    double getPrice();
    double getTotalPrice();
    int getCoffeeCount();

    void incrementCoffeeCount();
    void decrementCoffeeCount();

    void setPrice(double price);
}
