package chapter15;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by songdexv on 2017/12/11.
 */
public class JavaCallScalaTest {
    public static void main(String[] args) {
        ScalaTest test = new ScalaTest();
        System.out.println(test.sum(1, 2, 3));

        try {
            String content = test.getFileContent("ScalaTest.scala");
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ArrayList<Integer> arrayList3=new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        try {
            arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
            for (int i=0;i<arrayList3.size();i++) {
                System.out.println(arrayList3.get(i));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
