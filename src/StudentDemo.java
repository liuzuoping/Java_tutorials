import java.util.ArrayList;
import java.util.Collection;

public class StudentDemo{


    public static void main(String[] args) {
        Collection c = new ArrayList();
        Student s1 = new Student("林黛玉", 18);
        Student s2 = new Student("秦可卿", 20);
        Student s3 = new Student("王熙凤", 22);
        c.add(s1);
        c.add(s2);
        c.add(s3);
        Object[] objs = c.toArray();

        for(int x = 0; x < objs.length; ++x) {
            Student s = (Student)objs[x];
            System.out.println(s.getName() + "---" + s.getAge());
        }

    }
}
