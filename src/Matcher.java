import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Matcher {
    public static void main(String args[]) {

        Person[] group1, group2;
        int numOfPeople, k, rmvAssign;
        boolean partnerFound;

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

                for (int i = 0; i <= numOfPeople - 1; i++) {

                    if (group1[i].isTaken) {
                        //skip

                    } else {

                        partnerFound = false;
                        while (partnerFound == false) {
                            k = group1[i].getPreferenceIndex(rank);

                            if (group2[k].isTaken == false) {

                                group1[i].setAssignedTo(k);
                                group1[i].isTaken = true;
                                group2[k].setAssignedTo(i);
                                group2[k].isTaken = true;

                                stack.push(new Couples(i, k));

                                partnerFound = true;
                            } else if (group2[k].isTaken == true) {


                                if (group2[k].getIndexPreference(i) < group2[k].getIndexPreference(group2[k].assignedTo)) {
                                    //backtrackToRemove(group2[k].assignedTo);
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
                                    rank++;
                                    partnerFound = false;
                                }


                            }
                        }
                    }
                }


            }
            for (int j = 0; j <= numOfPeople - 1; j++) {
                System.out.print("Team " + (j+1) + ": ");
                System.out.println(group1[stack.top().partner1].name + " and " + group2[stack.top().partner2].name);
                stack.pop();
            }


        } catch (IOException e) {
            System.out.println("File IO Exception. Please try again");
        }





        /*
        System.out.println(group1[0].getName());
        System.out.println(group2[0].getName());
        System.out.println(group2[3].getPreferences(2));
        System.out.println(group1[0].getPreferenceIndex(0));
        System.out.println(group2[1].getIndexPreference(1));
        */

    }


}

