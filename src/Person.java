import java.util.ArrayList;

public class Person {
    String name;
    int index, assignedTo;
    ArrayList<Integer> preferences = new ArrayList();
    boolean isTaken;

    public Person(String name, int assignedTo, boolean isTaken, ArrayList<Integer> preferences) {
        this.name = name;
        this.assignedTo = assignedTo;
        this.isTaken = isTaken;
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

    public ArrayList<Integer> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Integer> preferences) {
        this.preferences = preferences;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
