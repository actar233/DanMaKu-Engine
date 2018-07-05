# DanMaKu-Engine
## 说明
```
  这是一个屏幕弹幕引擎,主要作用是在屏幕中发送弹幕.
  运用场景:比如说年会,活动... 需要在屏幕中发送弹幕的场景
```

## 使用方法

[DanMaKu-Engine](https://github.com/actar676309180/DanMaKu-Engine/releases/)

1. 点击上方链接,下载jar文件  
2. 在你的项目中引入jar文件
3.
```
    DanMaKuEngine.open();
    DanMaKu danMaKu = new DanMaKu("This is a Test.", Font.font(22.0), Color.GREEN);
    DanMaKuEngine.launch(danMaKu);
```

本项目基于JavaFX,需要jdk1.8及以上  
如果使用的是openjdk,则需要引入openjfx

```
DanMaKuEngine.open();
```
用于打开一个窗口,此方法是阻塞的.耗时2-3秒.

```
new DanMaKu("This is a Test.", Font.font(22.0), Color.GREEN)
```
用于创建一个弹幕 DanMaKu("消息",字体,颜色)

```
DanMaKuEngine.launch(danMaKu)
```
用于发送弹幕