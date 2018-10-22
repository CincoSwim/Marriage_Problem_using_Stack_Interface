/*
EECS 2500 Project 1
Written by Christopher Pucko

This class creates a Person object, with each Person having a name, a boolean indicating if they are paired (isTaken),
an index number of who they are assigned to (if they are assigned) and a String array of the Person's interests.

Aside from common getters and setters, this Object also has a getPreferenceIndex() and getIndexPreference() method.
getPreferenceIndex returns the index of a specific rank for a preference- for example, you can look for the 1st ranked
partner, and it will return the index of whomever that is.

getIndexPreference returns the preference of a specified index as an integer for arithmetic comparisons.

 */
public class Person {
    String name;
    int index, assignedTo;
    String[] preferences;
    boolean isTaken;

    public Person(String name, String[] preferences) {
        this.name = name;
        this.assignedTo = -1;
        this.isTaken = false;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getPreferences(int index) {
        return preferences[index];
    }

    public int getPreferenceIndex(int rank){
        //this returns the index of a persons specific ranking.
        //it returns i when the preference at that index is equal to the rank requested.
        int prefInt;
        for (int i = 0; i<=3; i++){
            prefInt = Integer.parseInt(preferences[i]);
            if (prefInt == rank)
                return i;
        }
        return -1;
    }

    public int getIndexPreference(int index){
        //this returns the preference value for an index as an integer for comparisons.
        int preferenceVal;
        preferenceVal = Integer.parseInt(this.getPreferences(index));
        return preferenceVal;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
