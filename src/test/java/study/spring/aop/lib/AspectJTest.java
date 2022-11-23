package study.spring.aop.lib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test(..))")
    public void test(){

    }
    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }
}
