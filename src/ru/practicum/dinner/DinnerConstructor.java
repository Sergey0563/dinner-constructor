package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;



public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesTypes;

    DinnerConstructor() {
        dishesTypes = new HashMap<>();
    }

    void dishesList(String dishType, String dishName) {
        if (dishesTypes.containsKey(dishType)) {
            ArrayList<String> dishes = dishesTypes.get(dishType);
            if (dishes.contains(dishName)) {
                System.out.println("Такое блюдо уже есть в типе " + dishType);
            } else {
                dishes.add(dishName);
                System.out.println("Блюдо " + dishName + " с типом " + dishType + " добавлено!");
            }
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesTypes.put(dishType, dishes);
            System.out.println("Блюдо " + dishName + " с типом " + dishType + " добавлено!");
        }
    }

}