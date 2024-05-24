package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * хранению блюд и генерации комбинаций
 */
// вы не должны использовать объекты класса Scanner внутри DinnerConstructor.
public class DinnerConstructor {
    public static HashMap<String, ArrayList<String>> types = new HashMap<>();
    static Random random = new Random();

    // mock
    // DinnerConstructor() {
    //     types.put("Первое", new ArrayList<>(Arrays.asList("Борщ", "Суп", "Щи")));
    //     types.put("Второе", new ArrayList<>(Arrays.asList("Макароны", "Гречка", "Рис")));
    //     types.put("Напиток", new ArrayList<>(Arrays.asList("Чай", "Компот", "Сок")));
    // }

    ArrayList<ArrayList<String>> generateCombo(int numberOfCombos, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int index = 0; index < numberOfCombos; index++) {
            ArrayList<String> combo = new ArrayList<>();

            for (String dishType : dishTypes) {
                ArrayList<String> dishes = types.get(dishType);
                int randomIndex = random.nextInt(dishes.size());
                String dish = dishes.get(randomIndex);
                combo.add(dish);
            }

            result.add(combo);
        }

        return result;
    }
}
