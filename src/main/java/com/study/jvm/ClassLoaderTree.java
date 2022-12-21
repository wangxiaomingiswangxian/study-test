package com.study.jvm;

/**
 * @author 王贤
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader c = ClassLoaderTree.class.getClassLoader();
        while (c != null){
            System.out.println(c.getClass().getName());
            c = c.getParent();
        }
        if (c ==null){
            System.out.println("BootstrapLoader is implemented by C");
        }
    }
}
