package ru.arvalon.coffeeorder.trash;

/**
 * Created by arvalon on 27.03.2018.
 */

public class WaterSource {
    public int getWaterPressure(){
        return 0;
    }

    public void doSelfCheck(){
        throw new IllegalArgumentException("Wrong argument");
    }
}
