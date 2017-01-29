package com.shahinjo.thingy.shahinportfolio.Managers;

/**
 * Created by y.shahin on 1/29/2017.
 */

public class TextManager {

    public static final String removeBreakLinCharacters(String text) {

        text = text.replaceAll("(\r\n|\n)", " ");

        return text;
    }
}
