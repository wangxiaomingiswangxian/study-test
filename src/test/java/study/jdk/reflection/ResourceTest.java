package study.jdk.reflection;

import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ResourceTest {
    @Test
    public void main() throws IOException {
        Class<ResourceTest> cl = ResourceTest.class;
        URL aboutURL = cl.getResource("/about.gif");
        var icon = new ImageIcon(aboutURL);

        InputStream stream = cl.getResourceAsStream("/data/about.txt");
        var about = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

        InputStream stream1 = cl.getResourceAsStream("/corejava/title.txt");
        var title = new String(stream1.readAllBytes(), StandardCharsets.UTF_8).strip();

        JOptionPane.showMessageDialog(null, about, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    @Test
    public void testReflection() throws ClassNotFoundException, NoSuchMethodException {
        Class cl = Class.forName("study.jdk.reflection.ReflectionDemo");
        final int modifiers = cl.getModifiers();
        System.out.println(Modifier.toString(modifiers)); //public
        System.out.println(cl.isSealed()); //false
        System.out.println(cl.isEnum());
        System.out.println(cl.isHidden());
        final Constructor[] declaredConstructors = cl.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getModifiers());
            for (Class parameterType : declaredConstructor.getParameterTypes()) {
                System.out.println(parameterType.getName());
            }
        }
        final Method[] methods = cl.getMethods();
        for (Method method : methods) {
            final Class<?> returnType = method.getReturnType();
            final String name = method.getName();
        }
    }
}
