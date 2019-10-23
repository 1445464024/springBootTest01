package com.qf.demo;

/**
 * @author YinZhi
 */
public class test {

    public static void main(String[] args) {
        String a = "aaa";
        System.out.println("a--->"+a);
        a = "bbb";
        System.out.println("a--->"+a);
        String c = "ccc";
        a = c;
        System.out.println("a--->"+a);
        String d = new String("ddd");
        a = d;
        System.out.println("a--->"+a);
        a = new String("eee");
        System.out.println("a--->"+a);
        //heiheihei
    }
}
