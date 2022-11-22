package profiler;

import javassist.ClassPool;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class PerfMonXformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        byte[] transformed = null;
        System.out.println("Transforming " + className);
        ClassPool pool = ClassPool.getDefault();
    }
}
