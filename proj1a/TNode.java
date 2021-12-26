public class IntNode {

    public int item;
    public IntNode next;
    public IntNode before;

    public IntNode(int item, IntNode next, IntNode before) {
        this.item = item;
        this.next = next;
        this.before = before;
    }
}
