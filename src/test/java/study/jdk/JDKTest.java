package study.jdk;

import org.junit.Test;
import study.jdk.record.StudyRecord;

public class JDKTest {
    @Test
    public void testRecord(){
        var p =new StudyRecord();
        p.u().setCreatorName("set");
        System.out.println(p.u().getCreatorName());
    }
}
