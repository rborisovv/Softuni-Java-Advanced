package OppinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split("\\s++");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            if (age > 30) {
                personList.add(person);
            }
        }
        personList.sort(Comparator.comparing(Person::getName));
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
