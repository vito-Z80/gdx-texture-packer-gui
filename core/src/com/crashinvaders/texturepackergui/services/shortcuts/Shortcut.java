package com.crashinvaders.texturepackergui.services.shortcuts;


import com.badlogic.gdx.Input;
import com.crashinvaders.texturepackergui.utils.CommonUtils;

@SuppressWarnings("PointlessBitwiseExpression")
public class Shortcut {
    private static int FLAG_SHIFT = 1<<0;
    private static int FLAG_CONTROL = 1<<1;
    private static int FLAG_ALT = 1<<2;
    private static int FLAG_SYM = 1<<3;

    private final String actionName;
    private int keyCode;

    /** Represents priority for handling order */
    private int flags = 0;

    public Shortcut(String actionName) {
        this.actionName = actionName;
    }

    Shortcut setKey(int keyCode) {
        if (keyCode == Input.Keys.SHIFT_LEFT || keyCode == Input.Keys.SHIFT_RIGHT) {
            flags ^= FLAG_SHIFT;
            return this;
        }
        if (keyCode == Input.Keys.CONTROL_LEFT || keyCode == Input.Keys.CONTROL_RIGHT) {
            flags ^= FLAG_CONTROL;
            return this;
        }
        if (keyCode == Input.Keys.ALT_LEFT || keyCode == Input.Keys.ALT_RIGHT) {
            flags ^= FLAG_ALT;
            return this;
        }
        if (keyCode == Input.Keys.SYM) {
            flags ^= FLAG_SYM;
            return this;
        }

        this.keyCode = keyCode;
        return this;
    }

    public String getActionName() {
        return actionName;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isShift() {
        return (flags & FLAG_SHIFT) != 0;
    }
    public boolean isControl() {
        return (flags & FLAG_CONTROL) != 0;
    }
    public boolean isAlt() {
        return (flags & FLAG_ALT) != 0;
    }
    public boolean isSym() {
        return (flags & FLAG_SYM) != 0;
    }

    public int getPriority() {
        return CommonUtils.getSetBits(flags);
    }
}