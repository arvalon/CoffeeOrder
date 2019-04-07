package ru.arvalon.coffeeorder.trash;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by arvalon on 25.03.2018.
 */

public class Foo extends RealmObject {

    @PrimaryKey
    private String PK;

    public Stuff getStuff(){
        return new Stuff();
    }

    public int getNum(){
        return 1;
    }
}
