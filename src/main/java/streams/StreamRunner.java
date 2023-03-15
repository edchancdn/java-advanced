package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
//import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamRunner {

    public static void main(String[] args) {

        List<Dish> dishes = new ArrayList<>();
        buildList(dishes);

        dishes.forEach(n -> System.out.println(n));

        System.out.println("--- nonVeggies: nonveg, pork, descending prep time ---");
        List<Dish> nonVeggies = nonVeggiesStream(dishes);
        nonVeggies.forEach(n -> System.out.println(n));

        List<String> uniqueIngredients = getIngredients(dishes);
        System.out.println(uniqueIngredients);

        List<String> ingredients = dishes.stream()
                .flatMap(d -> d.getIngredients().stream())
                .distinct()
                .collect(toList());
        System.out.println(ingredients);

        // toSet
        Set<String> ingredientsSet = dishes.stream()
                .flatMap(d -> d.getIngredients().stream())
                .collect(toSet());
        System.out.println(ingredientsSet);

        Set<String> in = dishes.stream()
                .flatMap(d -> d.getIngredients().stream())
                .collect(toSet());

    }

    public static List<String> addStar(List<String> strings) {
        return strings.stream().map(s -> s + "*").collect(toList());
    }

    // flatNap
    public static List<String> getIngredients(List<Dish> dishes) {
        Stream<String> dList = dishes.stream()
                .flatMap(d -> d.getIngredients().stream());
        List<String> sList = dList.distinct().collect(toList());
        return sList;
    }

    public static List<Dish> nonVeggiesStream(List<Dish> dishes) {
        List<Dish> dList = dishes.stream()
                // include only NONVEG and having an ingredient of pork
                .filter(d -> (d.getType() == DishType.NONVEG) && (d.getIngredients().contains("pork")))
                // sort by price and preparationTime, in descending order
                .sorted(Comparator.comparing(Dish::getPrice)
                        .thenComparing(Dish::getPreparationTime).reversed())
                .collect(toList());
        return dList;
    }

    public static List<Dish> VeggiesStream(List<Dish> dishes) {
        List<Dish> veggies = dishes.stream().filter(d -> d.getType() == DishType.VEG).collect(toList());
        return veggies;
    }

    public static List<Dish> nonVeggiesLoop(List<Dish> dishes) {
        List<Dish> dList = new ArrayList<>();
        for (Dish d :dishes) {
            if (d.getType() == DishType.NONVEG && d.getIngredients().contains("pork")) {
                dList.add(d);
            }
        }
        dList.sort(Comparator.comparing(Dish::getPrice)
                .thenComparing(Dish::getPreparationTime).reversed());
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
                .preparationTime(25)
                .type(DishType.NONVEG)
                .name("Grilled Pork")
                .ingredients(List.of("pork", "bbq sauce", "spices"))
                .build());

        dishes.add(Dish.builder()
                .dishId(4)
                .price(3.00)
                .preparationTime(30)
                .type(DishType.NONVEG)
                .name("Pork Dumpling")
                .ingredients(List.of("pork", "spices"))
                .build());


    }
}
