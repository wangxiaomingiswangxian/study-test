package study.spring.bean.circulardependencies.bean;

/**
 * @author 王贤
 */
public class TestC {

	private TestA testA;

	public void c(){
		testA.a();
	}

	public TestA getTestA() {
		return testA;
	}

	public void setTestA(TestA testA) {
		this.testA = testA;
	}
}
