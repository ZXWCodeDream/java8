package Chapter3;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: MethodReferenceDemo
 * Description:
 *
 * 方法引用
 *
 * @author zxw
 * @date 2020/12/26 9:05 下午
 * @since JDK 1.8
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {

        List<String> listA = Arrays.asList("a","b","A","B");
        List<String> listB = Arrays.asList("a","b","A","B");
        //正常lambda表达式
        listA.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
        listA.forEach(System.out::println);

        //使用方法引用:指向任意类型实例方法
        listB.sort(String::compareToIgnoreCase);
        listB.forEach(System.out::println);
    }
}
