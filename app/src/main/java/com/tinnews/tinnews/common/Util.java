package com.tinnews.tinnews.common;

/**
 * Created by dxie on 12/28/18.
 */

public class Util {
    private Util() {

    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
