## 通过行为参数化传递参数

### 什么是行为参数化？

行为参数化：让方法接受多种行为（或战略）作为参数，并在内部使用，完成不同的行为

举例：

**业务场景**：超市卖苹果，需要根据苹果的颜色和价位等行为筛选出指定的苹果，以此放在不同的摊位

**设计**：筛选条件层出不穷，故代码设计应能够轻易扩展不同的行为，并且不影响已经存在的业务。那我们就将筛选条件设计为接口，不同的筛选条件实现具体筛选内容，筛选业务时将筛选条件作为参数传递。

![](https://ftp.bmp.ovh/imgs/2020/12/b2e288753b058f4d.png)

![](https://ftp.bmp.ovh/imgs/2020/12/9ecc0350752e7e04.png)

实体类Apple:

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    private String color;
    private Integer price;
}
```

封装行为接口:

```java
public interface ApplePredicate {
    Boolean test(Apple apple);
}
```

具体行为实现:

```java
public class AppleGreenColorPredicate implements ApplePredicate {
    public Boolean test(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }
}
```

```java
public class AppleHighPricePredicate implements ApplePredicate {
    public Boolean test(Apple apple) {
        return apple.getPrice() > 15;
    }
}
```

行为参数化:

```java
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
```

具体应用：

```java
  public class demo{
      public static void main(String[] args) {
    
          Apple apple1 = new Apple("green",11);
          Apple apple2 = new Apple("yellow",16);
          Apple apple3 = new Apple("blue",17);
          Apple apple4 = new Apple("black",13);
          Apple apple5 = new Apple("white",14);
          List<Apple> list = Arrays.asList(apple1,apple2,apple3,apple4,apple5);
          //传入具体实现过滤条件的类AppleGreenColorPredicate作为行为参数
          List<Apple> filterApples =  new AppleFilter(list).filter(new 		   AppleGreenColorPredicate());
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
```



**行为接口实现弊端**：每一个行为使用场景以及次数不会很多，却要创建一个类来封装，显得代码有点冗余，繁杂

**使用匿名类替代**：代码很笨重，占据诸多空间，看着不优雅

**使用lambda表达式替代**：代码简洁优雅

### 总结

- 行为参数化意思为**让行为或者策略作为方法的参数**，使其在内部运行，完成不同的行为
- 行为参数化可适应多种使用场景，适应未来的可变行，减轻工作负担。
- 行为参数可为接口实现类、匿名类、lambda表达式，推荐使用**lambda表达式**,使得代码优雅。



## lambda表达式

lambda表达式可简单地表示**可传递的匿名函数的一种方式**，没有名称，但有**参数列表**、**函数主体**、**返回值**

**函数式接口**：只定义了一个抽象方法的接口

@FunctionInterface注解定义接口并不是必须的，就像是@Override注解类似，做一个提示作用



