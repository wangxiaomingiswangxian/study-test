package study.jdk.interfacetest;

public class ImplementTest implements InterfaceA,InterfaceB{

    @Override
    public String getName() {
        return InterfaceB.super.getName();
    }
}
