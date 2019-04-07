package ru.arvalon.coffeeorder.bill.interfaces;

public interface IBillPresenter extends IBillNotifyOperation {

    void setView(IBillView view);
    void unregisterView();

    /** необходимо вызывать из View при старте презентера для получения данных из старой модели
     * и обображения их на экране */
    void init();

    /** затащить кофейный заказ из модели главной странички */
    void loadCoffeeOrder();

    void saveOrder();

    /** закрытие счёта после записи в БД, возврат на главный экран */
    void closeBill();
}
