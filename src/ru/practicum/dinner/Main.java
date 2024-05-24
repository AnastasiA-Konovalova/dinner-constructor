package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
                default:
                    System.out.println("Неизвестная команда, попробуйте еще раз");
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

        // добавьте новое блюдо
        ArrayList<String> dishes = dc.types.get(dishType);
        if (dishes == null) {
            dc.types.put(dishType, new ArrayList<>(Arrays.asList(dishName)));
        } else {
            dishes.add(dishName);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> dishTypes = new ArrayList<>();
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            ArrayList<String> dishes = dc.types.get(nextItem);
            boolean isExistType = dishes != null;

            if (!isExistType) {
                System.out.println("Не удалось найти тип блюда: " + nextItem);
            } else {
                dishTypes.add(nextItem);
            }

            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        System.out.println();

        ArrayList<ArrayList<String>> combos = dc.generateCombo(numberOfCombos, dishTypes);
        for (int index = 0; index < combos.size(); index++) {
            System.out.print("Комбо " + (index + 1) + " ");
            System.out.print("[");
            ArrayList<String> dishes = combos.get(index);
            for (int dishIndex = 0; dishIndex < dishes.size(); dishIndex++) {
                String item = dishes.get(dishIndex);
                System.out.print(item + (dishIndex + 1 < dishes.size() ? ", " : ""));
            }
            System.out.println("]");
        }
    }
}
