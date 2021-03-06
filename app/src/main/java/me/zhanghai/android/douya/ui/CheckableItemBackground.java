/*
 * Copyright (c) 2018 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;

import me.zhanghai.android.douya.R;
import me.zhanghai.android.douya.util.ViewUtils;

// We cannot use color theme attribute as drawable in XML resource, so we have to do this in Java.
public class CheckableItemBackground {

    private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };
    private static final int[] EMPTY_STATE_SET = {};

    private CheckableItemBackground() {}

    @NonNull
    public static StateListDrawable create(@NonNull Context context) {
        StateListDrawable checkableItemBackground = new StateListDrawable();
        int controlHighlightColor = ViewUtils.getColorFromAttrRes(R.attr.colorControlHighlight, 0,
                context);
        Drawable controlHighlightColorDrawable = new ColorDrawable(controlHighlightColor);
        checkableItemBackground.addState(CHECKED_STATE_SET, controlHighlightColorDrawable);
        Drawable transparentDrawable = new ColorDrawable(Color.TRANSPARENT);
        checkableItemBackground.addState(EMPTY_STATE_SET, transparentDrawable);
        return checkableItemBackground;
    }
}
