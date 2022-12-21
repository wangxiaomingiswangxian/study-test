package study.jdk.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionOperation {
    private static List<String> demo = new ArrayList<>();
    static {
        demo.add("111");
        demo.add("222");
    }

    @Test
    public void test(){
        demo.removeIf(d-> d.equals("111"));
        System.out.println(demo);
    }

}
