package study.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomizeClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
    public CustomizeClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    @Override
    protected void initPropertySources(){
        //添加验证要求
        getEnvironment().setRequiredProperties("VAR");
    }

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        super.setAllowCircularReferences(false);
        super.setAllowBeanDefinitionOverriding(false);
        super.customizeBeanFactory(beanFactory);
    }
}
