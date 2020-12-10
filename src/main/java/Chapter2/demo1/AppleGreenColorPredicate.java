package Chapter2.demo1;

import Bean.Apple;

/**
 * ClassName: AppleGreenColorPredicate
 * Description:
 *  鉴别绿色苹果
 * @author zxw
 * @date 2020/12/10 11:24 上午
 * @since JDK 1.8
 */

public class AppleGreenColorPredicate implements ApplePredicate {

    public Boolean test(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }
}
