package study.spring.aop.lib;

public class TestAOPBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
    public void test(){
        System.out.println("test");
    }
}
