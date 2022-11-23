package com.study.profiler;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class PerfMonAgent {
    static private Instrumentation inst =null;
    public static void premain(String agentArgs,Instrumentation _inst){
        System.out.println("PerfMonAgent.premain was called" );
        inst = _inst;
        ClassFileTransformer transformer = new PerfMonXformer();
        System.out.println("Adding a PerfMonXformer instance to the JVM");
        inst.addTransformer(transformer);
    }
}
