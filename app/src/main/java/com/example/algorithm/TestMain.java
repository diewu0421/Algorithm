package com.example.algorithm;

import android.security.keystore.UserNotAuthenticatedException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.transform.Source;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 3/31/21 11:26 AM
 */

final class A {
    public A() {
        System.out.println("A constructor");
    }
    String selfIntroduction() {
        return "I'm com.example.algorithm.A";
    }
}

class B {
    String selfIntroduction() {
        return "I'm com.example.algorithm.B";
    }
}

class Test {
    public final A a = new A();
}

public class TestMain {

    public static void main(String[] args) throws Throwable {
        Test test = new Test();
        B b = new B();

//        test.getClass().getDeclaredField("a").set(test, b);

        System.out.println("替换前：");
        String toString = test.a.toString();
        String selfIntroduction = test.a.selfIntroduction();
        System.out.println("test.a = " + toString);
        System.out.println("test.a.selfIntroduction() = " + selfIntroduction);

        replaceObject(test, "a", b);

        System.out.println("替换后：");
        toString = test.a.toString();
        selfIntroduction = test.a.selfIntroduction();
        System.out.println("test.a = " + toString);
        System.out.println("test.a.selfIntroduction() = " + selfIntroduction);
//        System.out.println(((B) test.a).selfIntroduction());
        Object unsafe = getUnsafe();
        Object aObj = unsafe.getClass().getDeclaredMethods()[1].invoke(unsafe, A.class);
        System.out.println(aObj);

        for (int i = 0; i < 10; i++) {
            if (true) {
                i += 3;
                
            }
        }
    }
    public void test(String str) {
        str = "niasdf";
    }

    private static boolean replaceObject(Object target, String fieldName, Object newObject) {
        try {
            Object unsafe = getUnsafe();
            long offset = objectFieldOffset(unsafe, target, fieldName);
            putObject(unsafe, target, offset, newObject);
            return true;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return false;
    }

    private static Object getUnsafe() throws Throwable {
        Class unsafeClass = Class.forName("sun.misc.Unsafe");
        Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        return unsafeField.get(null);
    }

    private static long objectFieldOffset(Object unsafe, Object target, String fieldName) throws Throwable {
        Method objectFieldOffsetMethod = unsafe.getClass().getDeclaredMethod("objectFieldOffset", Field.class);
        objectFieldOffsetMethod.setAccessible(true);
        return (long) objectFieldOffsetMethod.invoke(unsafe, target.getClass().getDeclaredField(fieldName));
    }

    private static void putObject(Object unsafe, Object target, long fieldOffset, Object newObject) throws Throwable {
        Method putObjectMethod = unsafe.getClass().getDeclaredMethod("putObject", Object.class, long.class, Object.class);
        putObjectMethod.setAccessible(true);
        putObjectMethod.invoke(unsafe, target, fieldOffset, newObject);
    }
}
