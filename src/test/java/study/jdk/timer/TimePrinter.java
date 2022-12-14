package study.jdk.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimePrinter implements ActionListener {
    /**
     * 当到达指定的时间间隔时，定时器就调用actionPerformed方法
     * @param e the event to be processed 提供事件的相关信息，例如发生事件的时间
     *         e.getWhen() 表示纪元以来的毫秒数 1970年1月1日
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone ,the time is "
        + Instant.ofEpochMilli(e.getWhen())
        );
        //默认的工具箱，包含有关GUI环境的信息 beep 发出一声铃响
        Toolkit.getDefaultToolkit().beep();
    }

}
