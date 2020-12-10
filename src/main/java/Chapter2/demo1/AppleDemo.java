package Chapter2.demo1;

import Bean.Apple;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: AppleDemo
 * Description:
 *
 * @author zxw
 * @date 2020/12/10 11:26 上午
 * @since JDK 1.8
 */
public class AppleDemo {

    public static void main(String[] args) {

        Apple apple1 = new Apple("green",11);
        Apple apple2 = new Apple("yellow",16);
        Apple apple3 = new Apple("blue",17);
        Apple apple4 = new Apple("black",13);
        Apple apple5 = new Apple("white",14);
        List<Apple> list = Arrays.asList(apple1,apple2,apple3,apple4,apple5);
        //传入具体实现过滤条件的类AppleGreenColorPredicate作为行为参数
        List<Apple> filterApples =  new AppleFilter(list).filter(new AppleGreenColorPredicate());
        System.out.println(filterApples);
        // 使用匿名类替换具体实现类
        List<Apple> filterApples2 = new AppleFilter(list).filter(new ApplePredicate() {
            public Boolean test(Apple apple) {
                return 15 < apple.getPrice();
            }
        });
        //使用lambda表达式替换匿名类,代码简洁明了
        List<Apple> filterApples3 = new AppleFilter(list).filter((Apple apple)->"red".equalsIgnoreCase(apple.getColor()));
    }
}
