package org.example.Ex2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStream {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 2, 5, 6, 78, 7, 97, 87, 56, 3, 13, 26);

        List<String> stringList = Arrays.asList("apple", "cat", "banana", "orange", "open", "optical", "grape", "pear",
                "banana", "oasis", "A",
                "apple", "Asia");

        List<User> userList = Arrays.asList(new User("Вася", 18),
                new User("Олег", 25),
                new User("Вика", 26),
                new User("Валера", 19),
                new User("Вита", 44),
                new User("Женя", 33));

        System.out.println(filterNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(removingDuplicates(stringList));
        System.out.println("--------------------------------------");
        System.out.println(sortedNumber(integerList));
        System.out.println("--------------------------------------");
        System.out.println(filterStringByLetter(stringList, 'A'));
        System.out.println("--------------------------------------");
        System.out.println(skippingElements(integerList));
        System.out.println("--------------------------------------");
        System.out.println(filteringAndSquareOfNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(filterByLetterAndRevers(stringList));
        System.out.println("--------------------------------------");
        System.out.println(filterByNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(averageOfNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(concatenationIntoString(stringList));
        System.out.println("--------------------------------------");
        System.out.println(squareOfNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(listOfLetters(stringList));
        System.out.println("--------------------------------------");
        System.out.println(gettingString(stringList));
        System.out.println("--------------------------------------");
        System.out.println(skippingElementsAndUnique(stringList));
        System.out.println("--------------------------------------");
        System.out.println(filterUsers(userList));
    }


    // Задача 1: Фильтрация четных чисел и умножение на 2.
    private static List<Integer> filterNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .toList();
    }

    // Задача 2: Удаление дубликатов из списка строк.
    private static List<String> removingDuplicates(List<String> stringList) {
        return stringList.stream()
                .distinct()
                .toList();
    }

    // Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов.
    private static List<Integer> sortedNumber(List<Integer> integerList) {
        return integerList.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .toList();
    }

    // Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр.
    private static List<String> filterStringByLetter(List<String> stringList3, char ch) {
        return stringList3.stream()
                .filter(s -> s.charAt(0) == ch)
                .map(String::toUpperCase)
                .toList();
    }

    // Задача 5: Пропуск первых двух элементов и вывод оставшихся.
    private static List<Integer> skippingElements(List<Integer> integerList) {
        return integerList.stream()
                .skip(2)
                .toList();
    }

    // Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
    private static List<Integer> filteringAndSquareOfNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(x -> x > 50)
                .map(x -> x * x)
                .toList();
    }

    // Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
    private static List<String> filterByLetterAndRevers(List<String> stringList3) {
        return stringList3.stream()
                .filter(s -> s.contains("o"))
                .sorted(Collections.reverseOrder())
                .toList();
    }

    // Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.
    private static List<Integer> filterByNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(x -> x % 2 != 0)
                .sorted()
                .toList();
    }

    // Задача 9: Получить среднее значение чисел в списке.
    private static double averageOfNumbers(List<Integer> integerList) {
        return integerList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    // Задача 10: Получить строку, объединяющую элементы списка через запятую.
    private static String concatenationIntoString(List<String> stringList3) {
        return stringList3.stream()
                .collect(Collectors.joining(", "));
    }

    // Задача 11: Получить список квадратов чисел из другого списка.
    private static List<Integer> squareOfNumbers(List<Integer> integerList) {
        return integerList.stream()
                .map(x -> x * x)
                .toList();
    }

    // Задача 12: Получить список букв из списка слов и вывести их в алфавитном порядке.
    private static List<Character> listOfLetters(List<String> stringList3) {
        return stringList3.stream()
                .flatMap(word -> word.chars().mapToObj(ch -> (char) ch))
                .distinct()
                .sorted()
                .toList();
    }

    // Задача 13: Получить первые 3 строки из списка и вывести их в обратном порядке.
    private static List<String> gettingString(List<String> stringList3) {
        return stringList3.stream()
                .limit(3)
                .map(word -> new StringBuilder(word).reverse().toString())
                .toList();
    }

    // Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
    private static List<String> skippingElementsAndUnique(List<String> stringList3) {
        return stringList3.stream()
                .skip(2)
                .distinct()
                .toList();
    }

    // Задача 15: Фильтрация и сортировка пользователей по возрасту.
    private static List<User> filterUsers(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getAge() > 20)
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();
    }

}
