package study.spring.aop.lib.jdkproxy;

public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("-------------------add-----------------------");
    }
}
