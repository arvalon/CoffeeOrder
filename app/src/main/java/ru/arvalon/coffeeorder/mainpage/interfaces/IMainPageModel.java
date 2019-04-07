package ru.arvalon.coffeeorder.mainpage.interfaces;

import ru.arvalon.coffeeorder.model.CoffeeOrder;
import ru.arvalon.coffeeorder.model.IOrderOperation;
import ru.arvalon.coffeeorder.system.Logger;

/**
 * Created by arvalon on 26.03.2018.
 */

public interface IMainPageModel extends Logger, IOrderOperation {

    /** показать что за кофейный заказ лежит в модели */
    CoffeeOrder getCoffeeOrder();

    /** сгенерировать новый заказ */
    void createCoffeeOrder();
}
