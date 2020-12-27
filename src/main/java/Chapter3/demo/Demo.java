package Chapter3.demo;

import Bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: Demo
 * Description:
 *
 * @author zxw
 * @date 2020/12/27 11:45 上午
 * @since JDK 1.8
 */
public class Demo {

    //对AppleList的Apple进行排序
    public static List<Apple> appleList = Arrays.asList(
            new Apple("green1",1),
            new Apple("green2",5),
            new Apple("green3",4),
            new Apple("green4",3),
            new Apple("green5",2),
            new Apple("green6",2));


    /**
     * 使用方法引用
     * @param args
     */
    public static void main(String[] args) {
        appleList.sort(Comparator.comparingInt(Apple::getPrice));
        appleList.forEach(System.out::println);
    }


    /**
     * Comparator提供了静态方法comparingInt接受函数式接口参数去提取comparable键值并返回comparator对象
     * @param args
     */
    public static void main05(String[] args) {
        appleList.sort(Comparator.comparingInt((Apple a) -> a.getPrice()));
        appleList.forEach(System.out::println);

    }

    /**
     * java编译器可以根据上下文推断lambda表达式参数的类型
     * @param args
     */
    public static void main04(String[] args) {
        appleList.sort((o1,o2) -> o1.getPrice()-o2.getPrice());
        appleList.forEach(System.out::println);
    }

    /**
     * 使用正常lambda表达式
     * @param args
     */
    public static void main03(String[] args) {
        appleList.sort((Apple o1,Apple o2) -> o1.getPrice()-o2.getPrice());
        appleList.forEach(System.out::println);

    }

    /**
     * 使用匿名类
     * @param args
     */
    public static void main02(String[] args) {
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getPrice()-o2.getPrice();
            }
        });
        appleList.forEach(System.out::println);
    }


    /**
     * 第一种实现方法： 实现比较函数Comparator
     */
    public static void main01(String[] args) {

        appleList.sort(new AppleCompared());
        appleList.forEach(System.out::println);
    }

    public static class AppleCompared implements Comparator<Apple>{

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getPrice()-o2.getPrice();
        }
    }
}
