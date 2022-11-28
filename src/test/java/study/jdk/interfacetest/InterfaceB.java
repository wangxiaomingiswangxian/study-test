package study.jdk.interfacetest;

public interface InterfaceB {
    default String getName(){
        return "InterfaceB";
    }
}
