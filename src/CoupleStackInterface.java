/*
EECS 2500 Project 1
Written by Christopher Pucko

This is a stack interface for a stack that holds Couple objects.
 */


public interface CoupleStackInterface {
    void pop();

    Couples top();

    void push(Couples pair);

    boolean IsFull();

    boolean IsEmpty();
}
