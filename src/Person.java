import java.util.ArrayList;

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
        int prefInt;
        for (int i = 0; i<=3; i++){
            prefInt = Integer.parseInt(preferences[i]);
            if (prefInt == rank)
                return i;
        }
        return -1;
    }

    public int getIndexPreference(int index){
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
