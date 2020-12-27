package Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * ClassName: PredicateApply
 * Description:
 *
 * @author zxw
 * @date 2020/12/11 2:12 下午
 * @since JDK 1.8
 */
public class PredicateApply {

    /**
     * 将官方给定的函数式接口Predicate作为方法参数即行为参数化
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p){

        List<T> result = new ArrayList<>();
        for (T t : list){
            if (p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> filter = PredicateApply.filter(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                (Integer i) -> i >= 5  //lambda表达式为函数式接口Predicate默认方法tBoolean test(T t)的具体实现
        );
        System.out.println(filter);
        // 涉及拆箱和装箱会影响内存和性能，故官方提供了接受原始类型的函数式接口
        IntPredicate intPredicate = (int i ) -> i >= 5;
        intPredicate.test(100); // Predicate<T>只接受引用类型参数，intPredicate接受原始类型

    }
}
