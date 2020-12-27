package Chapter3;

import Bean.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ClassName: FunctionRefrenceDemo
 * Description:
 * 构造函数引用
 *
 * @author zxw
 * @date 2020/12/27 11:31 上午
 * @since JDK 1.8
 */
public class ConstructRefrenceDemo {

    public static void main(String[] args) {

        //对应构造函数 public Apple(){}
        Supplier<Apple> supplier = Apple::new;
        Apple apple = supplier.get();

        //对应构造函数 public Apple(String color){}
        Function<String,Apple> function = Apple::new;
        Apple apple1 = function.apply("red");

        //对应构造函数 public Apple(String color,Integer weight){}
        BiFunction<String,Integer,Apple> biFunction = Apple::new;
        Apple apple2 = biFunction.apply("red",1);
    }
}
