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




