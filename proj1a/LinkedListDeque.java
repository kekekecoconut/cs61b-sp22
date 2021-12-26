public class LinkedListDeque<T> {

    private class TNode<T> {

        private T item;
        private TNode next;
        private TNode pre;

        public TNode(T item, TNode next, TNode pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }

        public TNode(T item, TNode next) {
            this.item = item;
            this.next = next;
        }

        public TNode(T item) {
            this.item = item;
        }
    }

    private TNode sentFront;

    private TNode sentBack;

    private int size;

    public LinkedListDeque() {
        sentFront = new TNode(2);
        sentBack = new TNode(12);

        size = 0;
    }

    public void addFirst(T item){

        TNode t = new TNode(item);

        if(sentFront.next == null){
            sentFront.next = t;
            t.next = sentBack;
            t.pre = sentFront;
            sentBack.pre = t;
        }else {
            t.next = sentFront.next;
            t.pre = sentFront;
            sentFront.next.pre = t;
            sentFront.next = t;
        }

        size = size + 1;
    }

    public void addLast(T item){
        TNode t = new TNode(item);
        if(sentBack.pre == null){
            t.next = sentBack;
            t.pre = sentFront;
            sentBack.pre = t;
            sentFront.next = t;

        }else {
            t.next = sentBack;
            t.pre = sentBack.pre;
            sentBack.pre.next = t;
            sentBack.pre = t;

        }

        size = size + 1;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if (isEmpty()){
            return;
        }
        TNode t = sentFront.next;
        while (t != sentBack){
            System.out.println(t.item);
            t = t.next;
        }
    }

    public T removeFirst(){
        if(isEmpty())
            return null;

        T temp = (T) sentFront.next.item;
        sentFront.next.next.pre = sentFront;
        sentFront.next = sentFront.next.next;

        size = size-1;
        return temp;

    }

    public T removeLast(){
        if(isEmpty())
            return null;

        T temp = (T) sentBack.pre.item;
        sentBack.pre.pre.next = sentBack;
        sentBack.pre = sentBack.pre.pre;

        size=size-1;
        return temp;
    }

    public T get(int index){
        if(index >= size)
            return null;
        TNode t = sentFront.next;
        int i = 0;
        while (i != index){

            t =  t.next;
            i++;
        }
        return (T) t.item;
    }

    public T getRecursive(int index){
        return null;
    }
}
