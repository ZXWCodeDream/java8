package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName: Apple
 * Description:
 *
 * @author zxw
 * @date 2020/12/10 11:20 上午
 * @since JDK 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Apple {
    private String color;
    private Integer price;

    public Apple(String color) {
        this.color = color;
    }

//    private String type;
//    private Integer weight;
}
