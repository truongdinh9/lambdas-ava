package com.test.lambdas;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    //1 create runable :
    static Runnable runnable = ()->  System.out.println(1234);
    //2 Create and do function from function interface:
    public interface FuntionInterface {

        void abstractFun(int x);

        // A non-abstract (or default) function
        default void normalFun() {
            System.out.println("Hello");
        }


    }
    //3 for eEach :
   static List<String> stringList= new ArrayList<>();
    static {stringList.add("123"); stringList.add("456"); stringList.add("678");}

    public static void main(String[] args) {
        //1 Create
        Thread thread = new Thread(runnable);
        thread.start();
        //2.0 Use normal (not use lambda):
        FuntionInterface funtionInterface= new FuntionInterface() {
            @Override
            public void abstractFun(int x) {
                System.out.println(x);
            }
        };
        //2.1 use with Lambda
        FuntionInterface funtionInterface2 =(int x) -> System.out.println(x);
        //bonus
        FuntionInterface funtionInterface3 = System.out::println;
        funtionInterface.abstractFun(12);
        funtionInterface2.abstractFun(20);
        funtionInterface3.abstractFun(25);
        funtionInterface3.normalFun();
        //3 For eacH:
        stringList.forEach((x)-> System.out.println(x));
        //4 : Stream:
        List<String> stringList1 = stringList.stream().filter(x-> Long.parseLong(x) <555).collect(Collectors.toList());
        List<Long> stringList2 = stringList.stream().map(x->Long.valueOf(x)).collect(Collectors.toList());
        System.out.println(stringList.size() +" "+ stringList1.size()+" "+ stringList2.size() );

    }



}

