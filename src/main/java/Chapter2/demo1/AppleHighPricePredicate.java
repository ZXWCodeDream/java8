package Chapter2.demo1;

import Bean.Apple;

/**
 * ClassName: AppleHighPricePredicate
 * Description:
 * 价格大于15的苹果
 * @author zxw
 * @date 2020/12/10 11:25 上午
 * @since JDK 1.8
 */
public class AppleHighPricePredicate implements ApplePredicate {
    public Boolean test(Apple apple) {
        return apple.getPrice() > 15;
    }
}
