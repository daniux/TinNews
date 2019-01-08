package com.tinnews.tinnews.common;

import android.os.Bundle;

/**
 * Created by dxie on 12/15/18.
 */

public interface TinFragmentManager {
    void doFragmentTransaction(TinBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);
}
