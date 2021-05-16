package com.github.actar233.danmaku;

import com.github.actar233.danmaku.utils.ScreenUtil;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Random;


class Bullet extends VBox {

    private static Random random = new Random();

    public Bullet(DanMaKu danMaKu){
        Text text = new Text(danMaKu.getMessage());
        text.setFont(danMaKu.getFont());
        text.setFill(danMaKu.getColor());
        this.getChildren().add(text);
        this.setStyle("-fx-background:transparent;");

        double width = ScreenUtil.visualBoundWidth;
        double height = ScreenUtil.visualBoundHeight;

        this.setTranslateX(width);

        this.setTranslateY(random.nextInt((int)height));
    }
}
