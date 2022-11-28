package study.jdk.interfacetest;

public interface InterfaceA {
   default String getName(){
    return "InterfaceA";
   }
}
