package org.example.Ex3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {
    public static void main(String[] args) {
        List<String> listString = Arrays.asList("Java", "JavaScript", "Python", "Ruby");
        List<Integer> listNumbers = Arrays.asList(10, 15, 20, 25, 30);
        List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Jane", 25),
                new Person("Jack", 30),
                new Person("James", 35),
                new Person("Jill", 40)
        );
        List<String> lines = Arrays.asList(
                "Java is a programming language.",
                "Java is widely used in enterprise applications.",
                "Python is gaining popularity as a data science tool.",
                "Python is a versatile programming language."
        );
        String ss = "KikJhYggfTgf";


        System.out.println(task1(listString));
        System.out.println(task2(listNumbers, 3));
        System.out.println(task3(people, 'J'));
        System.out.println(task4(lines));
        task5(ss);
        task6();
        System.out.println();
    }


    /* Task1 - Дан список строк. Необходимо найти количество строк, которые содержат заданную подстроку. */
    private static int task1(List<String> list) {
        return (int) list.stream()
                .filter(string -> string.contains("Java"))
                .count();
    }

    /* Task2 - Дан список целых чисел. Необходимо найти максимальный элемент списка, который делится на заданное число
    без остатка. */
    private static int task2(List<Integer> listNumbers, int i) {
        return listNumbers.stream()
                .filter(n -> n % i == 0)
                .max(Integer::compareTo)
                .get();
    }

    /* Task3 - Дана коллекция объектов класса Person. Класс Person содержит поля name и age.
      Необходимо найти средний возраст людей, чьи имена начинаются на заданную букву. */
    private static double task3(List<Person> people, char ch) {
        return people.stream()
                .filter(p -> p.getName().charAt(0) == ch)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
    }

    /* Task4 - Дана коллекция строк. Необходимо найти все уникальные слова, которые содержатся в этой коллекции строк,
    и вернуть их в виде списка. */
    private static List<String> task4(List<String> lines) {
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .toList();
    }

    /* Task5 - Подсчитать буквы в нижнем и верхнем регистре */
    private static void task5(String ss) {
        int upperCase = (int) ss.chars()
                .filter(Character::isUpperCase)
                .count();

        int lowerCase = (int) ss.chars()
                .filter(Character::isLowerCase)
                .count();
        System.out.println("UpperCase: " + upperCase + "; " + "LowerCase: " + lowerCase);
    }

    /* Task6 - Определите все символьные строки максимальной длины в заданном конечном
        потоке символьных строк. через Optional */
    private static void task6() {
        Stream<String> stream = Stream.of("we", "wee", "qwer", "oooo");
        Optional<Map.Entry<Integer, List<String>>> max = stream
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey());

        max.ifPresentOrElse(entry -> {
                    System.out.println("Max length: " + entry.getKey());
                    System.out.println("Strings: " + entry.getValue());
                },
                () -> System.out.println("No strings in the stream.")
        );
    }
    /* Task7 - Дан список сотрудников, у каждого из которых есть поле "salary". Необходимо найти среднюю зарплату
    сотрудников, работающих на должности "developer" в компаниях, которые находятся в городах, начинающихся на букву "M".*/


    /* Task8 - У нас есть список списков numbers, и мы хотим получить все четные числа из этих списков. Мы используем
     flatMap, чтобы преобразовать каждый внутренний список в поток чисел, а затем фильтруем только четные числа.
      Результат: Even numbers: [2, 4, 6].
    List<List<Integer>> numbers = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
    ); */

    /* Task9 - Есть два списка list1 и list2, и мы хотим получить все возможные комбинации сумм чисел из обоих списков.
     Мы используем flatMap, чтобы преобразовать каждый элемент из list1 в поток, затем применяем map, чтобы создать
     поток сумм чисел из list1 и list2, и наконец, собираем все значения в combinedList.
      Результат: Combined list: [5, 6, 7, 6, 7, 8, 7, 8, 9].
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5, 6); */

}
