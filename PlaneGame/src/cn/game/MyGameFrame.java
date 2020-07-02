package cn.game;

import sun.util.calendar.Gregorian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MyGameFrame extends JFrame {


    public void paint(Graphics g){
        Color c = new Color(238, 28, 69);
        g.setColor(c);
        g.drawLine(100,100,300,300);
        g.drawRect(100,100,300,300);

    }

    public void launchFrame(){
        this.setBackground(new Color(59, 146, 44));
        this.setTitle("张永刚");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

}
