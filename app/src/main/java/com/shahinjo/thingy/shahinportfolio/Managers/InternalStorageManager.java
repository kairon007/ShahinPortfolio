package com.shahinjo.thingy.shahinportfolio.Managers;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by shahin on 1/14/17.
 */

public class InternalStorageManager {

    public static void writePortfolioListToFile(Context context, String fileName, Object contents) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(contents);
            os.close();
            fos.close();
        } catch (IOException ex) {

        }

    }

    public static Object readPortfolioListFromFile(Context context, String fileName) {
        Object simpleClass = new Object();
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            simpleClass = is.readObject();
            is.close();
            fis.close();
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }

        return simpleClass;
    }

    public static void writeObjectListToFile(Context context, String fileName, Object contents) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(contents);
            os.close();
            fos.close();
        } catch (IOException ex) {

        }

    }

    public static Object readObjectListFromFile(Context context, String fileName) {
        Object simpleClass = new Object();
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            simpleClass = is.readObject();
            is.close();
            fis.close();
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }

        return simpleClass;
    }

}
