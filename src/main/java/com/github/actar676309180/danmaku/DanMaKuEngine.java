package com.github.actar676309180.danmaku;

import javafx.application.Application;

class DanMaKuEngine {

    private static boolean isOpen = false;

    static DanMaKuView danMaKudanMaKuView = null;

    /**
     * 打开弹幕引擎
     */
    public static synchronized void open() {
        if (!isOpen) {
            new Thread(() -> Application.launch(DanMaKuView.class)).start();
            try {
                while (danMaKudanMaKuView == null) Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException("线程调度失败");
            }
            isOpen = true;
        } else {
            throw new RuntimeException("open 不能被调用两次");
        }
    }

    /**
     * 发射弹幕
     *
     * @param danMaKu 弹幕
     */
    public static void launch(DanMaKu danMaKu) {
        if (isOpen) {
            danMaKudanMaKuView.launch(danMaKu);
        } else {
            throw new RuntimeException("未初始化,无法发射弹幕");
        }
    }

}
