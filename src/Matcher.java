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
        int numOfPeople, indexToCheck;
        group1 = new Person[0];
        group2 = new Person[0];
        CoupleStack stack = new CoupleStack(4);

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
            while (!stack.IsFull()) {
                int rank = 0;
                outer:
                for (int i = 0; i <= numOfPeople - 1; i++) {

                    if (group1[i].isTaken) {
                        //skip

                    } else {


                        indexToCheck = group1[i].getPreferenceIndex(rank);

                        if (group2[indexToCheck].isTaken = false) {

                            group1[i].setAssignedTo(indexToCheck);
                            group1[i].isTaken = true;
                            group2[indexToCheck].setAssignedTo(i);
                            group2[indexToCheck].isTaken = true;

                            stack.push(new Couples(i, indexToCheck));
                        }

                        if (group2[indexToCheck].isTaken = true) {


                            if (group2[indexToCheck].getIndexPreference(i) < group2[indexToCheck].getIndexPreference(group2[indexToCheck].assignedTo)) {
                                //backtrackToRemove(group2[indexToCheck].assignedTo);


                            }else if ((group2[indexToCheck].getIndexPreference(i) > group2[indexToCheck].getIndexPreference(group2[indexToCheck].assignedTo))){
                                rank++;
                                continue outer;
                            }


                        }


                    }
                }
            }








        } catch (IOException e) {
            System.out.println("File IO Exception. Please try again");
        }



        System.out.println(group1[0].getName());
        System.out.println(group2[0].getName());
        System.out.println(group2[3].getPreferences(2));
        System.out.println(group1[0].getPreferenceIndex(0));
        System.out.println(group2[1].getIndexPreference(1));


    }





}

