package com.github.actar676309180.danmaku;

import com.github.actar676309180.danmaku.utils.ScreenUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DanMaKuView extends Application implements Runnable {

    private Lock lock = new ReentrantLock();

    private StackPane root = new StackPane();
    private List<Bullet> readyList = new ArrayList<>();
    private List<Bullet> loopList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        DanMaKuEngine.danMaKudanMaKuView = this;

        double width = ScreenUtil.visualBoundWidth;
        double height = ScreenUtil.visualBoundHeight;

        Scene scene = new Scene(root, width, height);

        scene.setFill(null);

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setX(0);
        primaryStage.setY(0);

        primaryStage.setTitle("Dan Ma Ku");
        primaryStage.setScene(scene);
        // 始终悬浮在顶层
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        new Thread(this).start();
    }

    private void ready() {
        lock.lock();
        try {
            for (Bullet bullet : readyList) {
                loopList.add(bullet);
                Platform.runLater(() -> {
                    root.getChildren().add(bullet);
                });
            }
            readyList.clear();
        } finally {
            lock.unlock();
        }
    }

    private void loop() {
        final Iterator<Bullet> iterator = loopList.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            Platform.runLater(()->{
                bullet.setTranslateX(bullet.getTranslateX()-1);
            });
            if (bullet.getTranslateX() <  0){
                Platform.runLater(()->{
                    root.getChildren().remove(bullet);
                });
                iterator.remove();
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            try { Thread.sleep(10); } catch (InterruptedException e) {e.printStackTrace();}
            ready();
            loop();
        }
    }

    /**
     * 发射弹幕
     *
     * @param danMaKu 弹幕
     */
    public void launch(DanMaKu danMaKu) {
        lock.lock();
        try {
            Bullet bullet = new Bullet(danMaKu);
            readyList.add(bullet);
        } finally {
            lock.unlock();
        }
    }
}
