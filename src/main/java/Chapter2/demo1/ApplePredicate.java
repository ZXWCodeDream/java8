package Chapter2.demo1;

import Bean.Apple;

/**
 * ClassName: ApplePredicate
 * Description:
 *
 * @author zxw
 * @date 2020/12/10 11:22 上午
 * @since JDK 1.8
 */
public interface ApplePredicate {

    Boolean test(Apple apple);
}
