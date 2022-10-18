package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamRunner {

    public static void main(String[] args) {

        List<Dish> dishes = new ArrayList<>();
        buildList(dishes);

        dishes.forEach(n -> System.out.println(n));

        System.out.println("--- nonVeggies: nonveg, pork, descending prep time ---");
        List<Dish> nonVeggies = nonVeggies(dishes);
        nonVeggies.forEach(n -> System.out.println(n));
    }

    public static List<Dish> nonVeggies(List<Dish> dishes) {
        List<Dish> dList = dishes.stream()
                // include only NONVEG and having an ingredient of pork
                .filter(d -> (d.getType() == DishType.NONVEG) && (d.getIngredients().contains("pork")))
                // sort by price and preparationTime, in descending order
                .sorted(Comparator.comparing(Dish::getPrice)
                        .thenComparing(Dish::getPreparationTime).reversed())
                .collect(Collectors.toList());
        return dList;
    }

    public static void buildList(List<Dish> dishes) {
       dishes.add(Dish.builder()
                .dishId(1)
                .price(1.00)
                .preparationTime(20)
                .type(DishType.VEG)
                .name("Samosa")
                .ingredients(List.of("potato", "tomato", "spices"))
                .build());

        dishes.add(Dish.builder()
                .dishId(2)
                .price(1.50)
                .preparationTime(20)
                .type(DishType.NONVEG)
                .name("Chicken Dumpling")
                .ingredients(List.of("chicken", "spices"))
                .build());

        dishes.add(Dish.builder()
                .dishId(3)
                .price(3.00)
                .preparationTime(30)
                .type(DishType.NONVEG)
                .name("Grilled Pork")
                .ingredients(List.of("pork", "bbq sauce", "spices"))
                .build());

        dishes.add(Dish.builder()
                .dishId(4)
                .price(3.00)
                .preparationTime(20)
                .type(DishType.NONVEG)
                .name("Pork Dumpling")
                .ingredients(List.of("pork", "spices"))
                .build());


    }
}
