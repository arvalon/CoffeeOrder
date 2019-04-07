package ru.arvalon.coffeeorder.system;

import android.util.Log;

/**
 * Created by arvalon on 26.03.2018.
 */

public interface Logger {

    /** ВСЯ МОЩЬ ЯВЫ7! ПАДАЙТЕ И МОЛИТЕСЬ! ПАДАЙТЕ И МОЛИТЕСЬ! */
    default void log(String message){
        Log.d("vga",message);
    };
}