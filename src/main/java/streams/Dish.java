package streams;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Dish {
    int dishId;
    List<String> ingredients;
    double   price;
    int preparationTime;
    DishType type;
    String name;
}
