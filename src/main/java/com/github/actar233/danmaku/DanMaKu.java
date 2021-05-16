package com.github.actar233.danmaku;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DanMaKu {
    private String message;
    private Font font;
    private Color color;

    public DanMaKu(String message, Font font, Color color) {
        this.message = message;
        this.font = font;
        this.color = color;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "DanMaKu{" +
                "message='" + message + '\'' +
                ", font=" + font +
                ", color=" + color +
                '}';
    }
}
