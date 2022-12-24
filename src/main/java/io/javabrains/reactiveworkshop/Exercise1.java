package io.javabrains.reactiveworkshop;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        List<Integer> numbers = StreamSources.intNumbersStream().toList();
        List<User> users = StreamSources.userStream().toList();

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream");
        numbers.stream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        numbers.stream().filter(n -> n < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        numbers.stream().filter(n -> n > 5).skip(1).limit(2).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5.\n" +
                "If nothing is found, print -1");
        numbers.stream().filter(n -> n > 5).findFirst().ifPresentOrElse((f) -> {
            System.out.println(f);
        }, () -> {
            System.out.println(-1);
        });

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        users.stream().map(user -> user.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        users.stream().filter(user -> numbers.contains(user.getId())).map(user -> user.getFirstName()).forEach(System.out::println);
    }

}
