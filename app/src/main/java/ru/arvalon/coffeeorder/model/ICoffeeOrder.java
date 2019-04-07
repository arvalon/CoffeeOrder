package ru.arvalon.coffeeorder.model;

public interface ICoffeeOrder {

    void setCoffeeCount(int count);

    void setCoffeePrice(double price);

    int getCoffeeCount();

    void incrementCoffeeCount();

    void decrementCoffeeCount();

    double getPrice();

    double getTotalPrice();
}
