package ru.practicum.dinner;

import java.util.*;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.dishesList(dishType, dishName);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        Random random = new Random();
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = "0";
        int combo = 1;

        ArrayList<String> setTypes = new ArrayList<>();
        nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (!dc.dishesTypes.containsKey(nextItem)) {
                System.out.println("Типа " + nextItem + " нет в списке типов!");
            } else {
                setTypes.add(nextItem);
            }
            nextItem = scanner.nextLine();// сгенерируйте комбинации блюд и выведите на экран
        }
        for (int i = 1; numberOfCombos >= i; i++) {
            ArrayList <String> setDishes = new ArrayList<>();
            for (String type : setTypes) {
                ArrayList<String> dishes = dc.dishesTypes.get(type);
                String randomDishName = dishes.get(random.nextInt(dishes.size()));
                setDishes.add(randomDishName);
            }
            System.out.println("Комбо " + combo);
            System.out.println(setDishes);
            combo += 1;
        }
    }
}
