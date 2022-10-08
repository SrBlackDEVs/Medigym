package login;

import java.awt.*;
import javax.swing.ImageIcon;

public class detectHover extends Thread {
    public static boolean hov = false;
    public static int mouseX;
    public static int mouseY;

    public static boolean detThread = true;

    public detectHover() {
        Thread detT = new Thread(this);
        detT.start();
    }

    @Override

    public void run() {
        while (!hov && detThread) {
            Point mouse = MouseInfo.getPointerInfo().getLocation();
            mouseX = mouse.x;
            mouseY = mouse.y;

            if (mouseX > 465 && mouseX < 908 && mouseY > 509 && mouseY < 560) {
                hov = true;
                if (hov) {
                    mainWindow.loginButton
                            .setIcon(new ImageIcon(mainWindow.class.getResource("/login/recurs/hover.png")));
                    hov = false;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                hov = false;
                mainWindow.loginButton.setFocusPainted(false);
                mainWindow.loginButton.setBorderPainted(false);
                mainWindow.loginButton.setContentAreaFilled(false);
                mainWindow.loginButton.setIcon(null);
            }
        }
    }
}
