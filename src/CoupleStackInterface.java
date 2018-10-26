/**
 * This is a stack interface for a Stack to hold objects known as Couples.
 *
 * @author Christopher Pucko <cgpucko@gmail.com>
 */


public interface CoupleStackInterface {
    void pop();

    Couples top();

    void push(Couples pair);

    boolean IsFull();

    boolean IsEmpty();
}
