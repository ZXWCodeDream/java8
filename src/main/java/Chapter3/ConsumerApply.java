package Chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * ClassName: ConsumeApply
 * Description:
 *
 * @author zxw
 * @date 2020/12/11 2:38 下午
 * @since JDK 1.8
 */
public class ConsumerApply {

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t : list){
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        forEach(
                Arrays.asList(1,2,3,4,5,6),
                (Integer i)-> System.out.println(i)
                //lambda表达式实则为函数式接口Consumer的抽象方法void accept(T t)的具体实现
        );
    }
}
