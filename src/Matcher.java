import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Matcher {
    public static void main(String args[]) {
        String nameRead;
        Integer[] preferences;
        Person[] group1, group2;
        int numOfPeople;
        group1 = new Person[0];
        group2 = new Person[0];

        try {
            FileReader file = new FileReader(new File("namelist.txt"));
            BufferedReader r = new BufferedReader(file);
            numOfPeople = Integer.parseInt(r.readLine());

            group1 = new Person[numOfPeople];
            group2 = new Person[numOfPeople];

            for (int i = 0; i <= numOfPeople - 1; i++) {
                group1[i] = new Person(r.readLine(), r.readLine().split("\t"));
            }
            for (int i = 0; i <= numOfPeople - 1; i++) {
                group2[i] = new Person(r.readLine(), r.readLine().split("\t"));

            }
        } catch (IOException e) {
            System.out.println("File IO Exception. Please try again");
        }



        System.out.println(group1[0].getName());
        System.out.println(group2[0].getName());
        System.out.println(group2[3].getPreferences(2));
        System.out.println(group1[0].getPreferenceIndex(0));


    }

}

