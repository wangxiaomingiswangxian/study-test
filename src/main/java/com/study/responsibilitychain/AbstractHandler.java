package com.study.responsibilitychain;


/**
 * @author 王贤
 */
public abstract class AbstractHandler <T>{

    private AbstractHandler<T> nextHandler;

    public void setNextHandler(AbstractHandler<T> nextHandler){
        this.nextHandler = nextHandler;
    }

    public void filter(T object){
        doFilter(object);
        if(getNextHandler()!=null){
            getNextHandler().filter(object);
        }
    }

    /**
     * 执行过滤 子类实现
     * @param object 校验对象
     */
    protected abstract void doFilter(T object);

    public AbstractHandler<T> getNextHandler() {
        return nextHandler;
    }
}
