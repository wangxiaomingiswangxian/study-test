package study.jdk.timer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){

        //匿名内部类
        var lister  =new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        var listener = new TimePrinter();
        var timer = new Timer(interval,listener);
        timer.start();
    }

    public static class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
