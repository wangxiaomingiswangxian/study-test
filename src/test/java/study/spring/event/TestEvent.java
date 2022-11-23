package study.spring.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class TestEvent extends ApplicationEvent {
    public String msg;
    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String message) {
        super(source);
        this.msg=message;
    }
    public void print(){
        System.out.println(msg);
    }
}
