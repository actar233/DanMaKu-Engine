package com.github.actar233.danmaku.utils;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

 public class ScreenUtil {

    public final static Double boundWidth;
    public final static Double boundHeight;
    public final static Double visualBoundWidth;
    public final static Double visualBoundHeight;

    static {
        final Screen primary = Screen.getPrimary();
        final Rectangle2D bounds = primary.getBounds();
        boundWidth = bounds.getWidth();
        boundHeight = bounds.getHeight();
        final Rectangle2D visualBounds = primary.getVisualBounds();
        visualBoundWidth = visualBounds.getWidth();
        visualBoundHeight = visualBounds.getHeight();
    }

}
