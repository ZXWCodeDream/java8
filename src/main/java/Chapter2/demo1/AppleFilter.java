package Chapter2.demo1;

import Bean.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AppleFilter
 * Description:
 *
 * @author zxw
 * @date 2020/12/10 11:27 上午
 * @since JDK 1.8
 */
public class AppleFilter {

    private List<Apple> apples;

    public AppleFilter(List<Apple> apples) {
        this.apples = apples;
    }
    /**
     * 行为参数化：让方法接受多种行为（或战略）作为参数，并在内部使用，完成不同的行为
     * @param p
     * @return
     */
    public List<Apple> filter(ApplePredicate p){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples){
            if (p.test(apple)){ // 谓词对象封装了测试苹果的条件
                result.add(apple);
            }
        }
        return result;
    }
}
