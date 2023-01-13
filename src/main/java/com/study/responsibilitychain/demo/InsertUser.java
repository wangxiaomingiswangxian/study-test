package com.study.responsibilitychain.demo;

import com.study.responsibilitychain.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author 王贤
 */
@Component
public class InsertUser {

    private List<AbstractHandler<User>> abstractHandlerList ;
    private AbstractHandler<User> abstractHandler;

    @PostConstruct
    public void init(){
        for (int i = 0; i < abstractHandlerList.size(); i++) {
            if (i ==0 ){
                abstractHandler = abstractHandlerList.get(0);
            }else {
                AbstractHandler<User> current = abstractHandlerList.get(i-1);
                AbstractHandler<User> next = abstractHandlerList.get(i);
                current.setNextHandler(next);
            }

        }
    }

    public void insert(User user){
        abstractHandler.filter(user);
//        execInsert(user);
    }
    public AbstractHandler<User> getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler<User> abstractHandler) {
        this.abstractHandler = abstractHandler;
    }

    @Autowired
    public void setAbstractHandlerList(List<AbstractHandler<User>> abstractHandlerList) {
        this.abstractHandlerList = abstractHandlerList;
    }
}
