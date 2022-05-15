package bearmaps;

public class Node<T> {
    private T item;
    private double myPriority;

    public Node(T item, double myPriority) {
        this.item = item;
        this.myPriority = myPriority;
    }

    public T getItem() {
        return item;
    }

    public void setMyTtem(T item) {
        this.item = item;
    }

    public double getMyPriority() {
        return myPriority;
    }

    public void setMyPriority(double myPriority) {
        this.myPriority = myPriority;
    }

    @Override
    public String toString() {
        return item + " ";
    }
}
