package Java_Advanced_5;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guest = scanner.nextLine();
        TreeSet<String> guests = new TreeSet<>();
        while (!guest.equals("PARTY")) {
            guests.add(guest);
            guest = scanner.nextLine();
        }
        guest = scanner.nextLine();
        while (!guest.equals("END")) {
            guests.remove(guest);
            guest = scanner.nextLine();
        }
        System.out.println(guests.size());
        for (String person : guests) {
            System.out.println(person);
        }
    }
}