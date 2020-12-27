package Chapter3;

/**
 * ClassName: VarUseInLambda
 * Description:
 * lambda表达式允许使用自由变量，即局部变量，但局部变量必须声明为final类型或者事实上是final类型
 * @author zxw
 * @date 2020/12/12 1:28 下午
 * @since JDK 1.8
 */
public class VarUseInLambda {

    public static void main(String[] args) {

        int a = 1;
        Runnable run = ()->{
            System.out.println(a);
        };
        new Thread(run).start();
    }
}
