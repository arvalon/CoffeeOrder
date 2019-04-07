package ru.arvalon.coffeeorder.bill.interfaces;

import ru.arvalon.coffeeorder.model.CoffeeOrder;
import ru.arvalon.coffeeorder.system.Logger;

public interface IBillModel extends Logger {
     void saveOrder(CoffeeOrder order);
}