package Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * ClassName: FunctionApply
 * Description:
 *
 * @author zxw
 * @date 2020/12/11 2:48 下午
 * @since JDK 1.8
 */
public class FunctionApply {

    /**
     * 获取List字符串元素的长度
     */
    public static <T,R> List<R> getStrLenList(List<T> list, Function<T,R> f){

        List<R> result = new ArrayList<>();
        for (T t : list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> reuslt = getStrLenList(
                Arrays.asList("abc", "张三", "lisa"),
                (String s) -> s.length()
                //lambda表达式为函数式接口Function的抽象方法R apply(T t)的具体实现
        );
        System.out.println(reuslt);
    }
}
