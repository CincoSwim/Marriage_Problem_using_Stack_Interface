/*
EECS 2500 Project 1
Written by Christopher Pucko

This class creates an object called Couples, which acts as a pair of 2 index intergers. These pairs can then be pushed
to the stack. From the stack, you can recall the index numbers, which can then be used to reference Person objects in
their respective arrays.
 */

public class Couples {
    int partner1, partner2;

    public Couples(int partner1, int partner2) {
        this.partner1 = partner1;
        this.partner2 = partner2;
    }

    public int getPartner1() {
        return partner1;
    }

    public void setPartner1(int partner1) {
        this.partner1 = partner1;
    }

    public int getPartner2() {
        return partner2;
    }

    public void setPartner2(int partner2) {
        this.partner2 = partner2;
    }
}
