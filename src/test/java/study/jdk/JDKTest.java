package study.jdk;

import org.junit.Test;
import study.jdk.record.StudyRecord;
import study.jdk.timer.TimePrinter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.function.BiFunction;

public class JDKTest {
    @Test
    public void testRecord(){
        var p =new StudyRecord();
        p.u().setCreatorName("set");
        System.out.println(p.u().getCreatorName());
    }
    @Test
    public void timerTest(){
//        var listener = new TimePrinter();
//        //构造一个定时器，每经过interval毫秒通知listener一次
//        Timer t = new Timer(1000,listener);
        //构造一个定时器，每经过interval毫秒通知listener一次
        var t = new Timer(1000,e -> {
            System.out.println("At the tone ,the time is "
                    + Instant.ofEpochMilli(e.getWhen())
            );
            //默认的工具箱，包含有关GUI环境的信息 beep 发出一声铃响
            Toolkit.getDefaultToolkit().beep();
        });
        //启动定时器
        t.start();
        //显示一个对话狂，包含一个提示消息和一个ok按钮
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    @Test
    public void BiFunctionTest(){
        BiFunction<String,String,Integer> com = (first,second)-> first.length() - second.length();
    }

    public static void repeatMessage(String text,int delay){
        ActionListener listener = e -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay,listener).start();
    }

    @Test
    public void repeatMessageTest(){
        repeatMessage("hello",1000);
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
