package study.rmi.app;

import study.rmi.client.HelloRMIService;

public class HelloRMIServiceImpl implements HelloRMIService {

    @Override
    public int getAdd(int a, int b) {
        return a+b;
    }
}
