/**
 * This class implements a Person object, with each person having a name, an array of their preferences to other people,
 * a boolean to signify whether they are taken, and an index of who they are paired with.
 *
 * @author Christopher Pucko <cgpucko@gmail.com>
 *
 * <p>
 * This class creates a Person object, with each Person having a name, a boolean indicating if they are paired (isTaken),
 * an index number of who they are assigned to (if they are assigned) and a String array of the Person's interests.
 * <p>
 * Aside from common getters and setters, this Object also has a getPreferenceIndex() and getIndexPreference() method.
 * getPreferenceIndex returns the index of a specific rank for a preference- for example, you can look for the 1st ranked
 * partner, and it will return the index of whomever that is.
 * <p>
 * getIndexPreference returns the preference of a specified index as an integer for arithmetic comparisons.
 * </p>
 */
public class Person {
    String name;
    int index, assignedTo;
    String[] preferences;
    boolean isTaken;

    /**
     * This is the constructor for a person object. Since each person is assumed to be new and unpaired, they are not
     * assigned to a proper index of another person, and their "isTaken" variable is set to false
     *
     * @param name        Descriptive string of the person's Name.
     * @param preferences A string array of a person's preferences to be paired with people of the other group.
     */
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

    /**
     * Sets the value assignedTo to the index of this person's Partner before being coupled. This allows them to recall
     * their partner's index for comparison purposes.
     *
     * @param assignedTo integer of their partner's index number.
     */
    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * This returns the string value of a Person's preference at a specified index.
     *
     * @param index index of another Person that this Person holds a preference value for.
     * @return String -the string value of how this person prefers the Person at the index parameterized.
     */
    public String getPreferences(int index) {
        return preferences[index];
    }

    /**
     * This returns the index number of a specific ranked person. For example, if I want to find the index of a Person's
     * first choice, 0 should be the argument, and the index of the preference with value 0 will be returned.
     *
     * @param rank the rank requested to be returned.
     * @return int the index of the Person with that rank, in the queried Person's array.
     */
    public int getPreferenceIndex(int rank) {
        int prefInt;

        for (int i = 0; i <= 3; i++) {
            prefInt = Integer.parseInt(preferences[i]);
            if (prefInt == rank)
                return i;
        }
        return -1;
    }

    /**
     * This returns the integer ranking value for a person at a specific index.
     *
     * @param index index of the person's rank to be checked.
     * @return preferenceVal - the ranking value of the checked person, 0 being the most preferable.
     */
    public int getIndexPreference(int index) {
        int preferenceVal;

        preferenceVal = Integer.parseInt(this.getPreferences(index));
        return preferenceVal;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    /**
     * Checks if the Person referenced is paired or unpaired.
     *
     * @return true if the value of isTaken is true. This is changed during pairing and unpairing.
     */
    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
