package org.example.Ex1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleStream {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 2, 5, 6, 78, 7, 97, 87, 56, 3, 13, 26);

        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "1", "2", "3");

        List<String> stringList2 = Arrays.asList("yes", "no", "cat", "dog", "apple", "c", "n", "COFFEE", "non");

        List<String> stringList3 = Arrays.asList("apple", "cat", "banana", "orange", "grape", "pear", "banana",
                "apple");

        List<Student> studentList = Arrays.asList(new Student("Пепя", "Петров", 27),
                new Student("Вася", "Пупкин", 29),
                new Student("Олег", "Ляхов", 25),
                new Student("Вика", "Смирнова", 26),
                new Student("Женя", "Гришин", 33));

        System.out.println(filterNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(listConversion(stringList));
        System.out.println("--------------------------------------");
        System.out.println(sumNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(maximumValue(integerList));
        System.out.println("--------------------------------------");
        System.out.println(filterString(stringList2, 'c'));
        System.out.println("--------------------------------------");
        System.out.println(uniqueWords(stringList3));
        System.out.println("--------------------------------------");
        System.out.println(objectTransformation(studentList));
        System.out.println("--------------------------------------");
        System.out.println(findingSumNumbers(integerList));
        System.out.println("--------------------------------------");
        System.out.println(uniqueChars(stringList2));

    }


    // Задание 1: Фильтрация списка целых чисел на нечетные числа
    private static List<Integer> filterNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(x -> x % 2 != 0)
                .toList();
    }

    // Задание 2: Преобразование списка строк в список чисел
    private static List<Integer> listConversion(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .toList();
    }

    // Задание 3: Суммирование списка чисел
    private static int sumNumbers(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::sum);
    }

    // Задание 4: Определение максимального значения в списке
    private static Optional<Integer> maximumValue(List<Integer> integerList) {
        return integerList.stream()
                .max(Integer::compareTo);
    }

    // Задание 5: Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в
    // верхний регистр
    private static List<String> filterString(List<String> stringList2, char firstLetter) {
        return stringList2.stream()
                .filter(c -> c.toLowerCase().startsWith(String.valueOf(firstLetter).toLowerCase()))
                .map(String::toUpperCase)
                .toList();
    }

    // Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
    private static List<String> uniqueWords(List<String> stringList) {
        return stringList.stream()
                .filter(word -> word.length() > 4)
                .distinct()
                .toList();
    }

    // Задание 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту ------
    private static List<String> objectTransformation(List<Student> studentList) {
        return studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
                .map(Student::getName)
                .toList();
    }

    // Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -------
    private static int findingSumNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
    private static List<String> uniqueChars(List<String> stringList2) {
        return stringList2.stream()
                .filter(c -> c.chars().distinct().count() == c.length())
                .toList();
    }
}