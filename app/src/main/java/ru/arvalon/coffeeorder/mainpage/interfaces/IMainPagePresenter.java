package ru.arvalon.coffeeorder.mainpage.interfaces;

import ru.arvalon.coffeeorder.model.IOrderOperation;
import ru.arvalon.coffeeorder.system.Logger;

/**
 * Created by arvalon on 26.03.2018.
 */

public interface IMainPagePresenter extends Logger, IOrderOperation {

    void setView(CoffeeOrderView view);
    void unregisterView();

    void updateView();

    /** установить новый заказ */
    void resetOrder();

}
