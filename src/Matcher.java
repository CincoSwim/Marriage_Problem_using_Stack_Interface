import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
EECS 2500 Project 1
Written by Christopher Pucko

This program uses a stack interface to compare preferences between people to form comfortable pairs. It first reads
the groups of people and their preferences to arrays of People objects using BufferedReader. Then, it compares the people
in these arrays sequentially, pushing pairs to the stack when pairings are available. If a pairing is not available, it
the preferences of the 2nd person, removing the pair from the stack and recreating it if a better pairing is found. When
4 stable pairs are found, it prints them to the console by name.
 */

public class Matcher {
    public static void main(String args[]) {

        Person[] group1, group2;
        int numOfPeople, k, rmvAssign;
        boolean partnerFound;

        CoupleStack stack;

        try {
            //A BufferedReader that reads test text from the supplied file, and inputs them as Person objects before
            //putting them in arrays.
            FileReader file = new FileReader(new File("namelist.txt"));
            BufferedReader r = new BufferedReader(file);
            numOfPeople = Integer.parseInt(r.readLine());

            stack = new CoupleStack(numOfPeople);

            group1 = new Person[numOfPeople];
            group2 = new Person[numOfPeople];

            for (int i = 0; i <= numOfPeople - 1; i++) {
                group1[i] = new Person(r.readLine(), r.readLine().split("\t"));
            }
            for (int i = 0; i <= numOfPeople - 1; i++) {
                group2[i] = new Person(r.readLine(), r.readLine().split("\t"));

            }

        //This acts as the logic to compare pairings.
            while (!stack.IsFull()) {
                int rank = 0;

                for (int i = 0; i <= numOfPeople - 1; i++) {

                    if (group1[i].isTaken) {
                        //If the Person in group1 is already paired, it is skipped.

                    } else {

                        partnerFound = false;
                        while (partnerFound == false) {
                            k = group1[i].getPreferenceIndex(rank);

                            if (group2[k].isTaken == false) {
                                //if the preference of i is not paired, the pair will automatically be created and pushed.
                                group1[i].setAssignedTo(k);
                                group1[i].isTaken = true;
                                group2[k].setAssignedTo(i);
                                group2[k].isTaken = true;

                                stack.push(new Couples(i, k));

                                partnerFound = true;
                            } else if (group2[k].isTaken == true) {
                                //if i's preference is taken, k's preference is used to decide whether to stay or go.

                                if (group2[k].getIndexPreference(i) < group2[k].getIndexPreference(group2[k].assignedTo)) {
                                    //if k prefers the new partner, it will backtrack through the stack until it finds
                                    //the defunct pair, dissolve it, and recreate the pair with the new partners.
                                    while (stack.top().partner1 != group2[k].assignedTo) {
                                        rmvAssign = stack.top().partner1;
                                        group1[rmvAssign].isTaken = false;
                                        stack.pop();
                                    }
                                    rmvAssign = stack.top().partner1;
                                    group1[rmvAssign].isTaken = false;
                                    stack.pop();
                                    group1[i].setAssignedTo(k);
                                    group1[i].isTaken = true;
                                    group2[k].setAssignedTo(i);
                                    group2[k].isTaken = true;


                                    stack.push(new Couples(i, k));
                                    partnerFound = true;
                                } else if ((group2[k].getIndexPreference(i) > group2[k].getIndexPreference(group2[k].assignedTo))) {
                                    //if k prefers its original partner, i will then loop to check its next preferred ranking.
                                    rank++;
                                    partnerFound = false;
                                }


                            }
                        }
                    }
                }


            }
            //once the stack has stable pairings, it will loop to print all pairings in the stack.
            for (int j = 0; j <= numOfPeople - 1; j++) {
                System.out.print("Team " + (j) + ": ");
                System.out.println(group1[stack.top().partner1].name + " and " + group2[stack.top().partner2].name);
                stack.pop();
            }


        } catch (IOException e) {
            System.out.println("File IO Exception. Please ensure that your file is in the correct directory and has " +
                    "the correct formatting.");
        }






    }


}

