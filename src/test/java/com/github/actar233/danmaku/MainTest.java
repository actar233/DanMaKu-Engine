package com.github.actar233.danmaku;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        DanMaKuEngine.open();
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(500);
            DanMaKuEngine.launch(new DanMaKu("test "+i,Font.font(40), Color.GREEN));
        }
    }
}
