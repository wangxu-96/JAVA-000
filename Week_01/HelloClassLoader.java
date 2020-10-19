package week_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> hello = new HelloClassLoader().findClass("Hello");

        Object o = hello.newInstance();

        Method method = hello.getMethod("hello");

        method.invoke(o);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File f = new File("/Users/ouakira/Documents/GitHub/JAVA-000/src/main/java/week_01/Hello.xlass");
        int length = (int)f.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(f).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
