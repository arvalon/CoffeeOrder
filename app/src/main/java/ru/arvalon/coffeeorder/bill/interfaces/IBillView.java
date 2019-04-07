package ru.arvalon.coffeeorder.bill.interfaces;

import ru.arvalon.coffeeorder.model.CoffeeOrder;
import ru.arvalon.coffeeorder.system.Logger;

public interface IBillView extends IBillNotifyOperation, Logger {

    /** ... */
    void showOrder(CoffeeOrder order);

    /** закрытие счёта после записи в БД, возврат на главный экран */
    void closeBill();
}
