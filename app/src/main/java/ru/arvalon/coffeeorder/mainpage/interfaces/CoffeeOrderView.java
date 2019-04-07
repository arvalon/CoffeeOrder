package ru.arvalon.coffeeorder.mainpage.interfaces;

import ru.arvalon.coffeeorder.system.Logger;

/**
 * Created by arvalon on 26.03.2018.
 */

public interface CoffeeOrderView extends Logger {

    void updateCoffeeCount();
    void updatePrice();
    void updateTotalPrice();
}
