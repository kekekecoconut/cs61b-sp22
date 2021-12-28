import java.util.Arrays;

public class LinkedListDeque<T> implements Deque<T> {

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

    public String dequeToWord(LinkedListDeque<Character> linkedListDeque){
        TNode p = sentFront;

        char[] w = new char[size];
        String word=null;
        int i=0;

        TNode t = sentFront.next;
        while (t != sentBack){
        //    System.out.println(t.item);
            w[i]= (char) t.item;
            t = t.next;
            i++;
        }

    //    System.out.println("w:"+String.valueOf(w));
        return String.valueOf(w);
    }

    public void reverse(){
        TNode temp = null;
        TNode p = sentFront;

        while (p!=null){
            temp = p.pre;
            p.pre = p.next;
            p.next = temp;
            p = p.pre;
        }

        if (temp!=null){
            sentBack = sentFront;
            sentFront = temp.pre;
        }
    }



    @Override
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

    @Override
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




    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        if (size()==0){
            System.out.println("empty!");
            return;
        }
        TNode t = sentFront.next;
        while (t != sentBack){
            System.out.println(t.item);
            t = t.next;
        }
    }

    @Override
    public T removeFirst(){
        if(size()==0)
            return null;

        T temp = (T) sentFront.next.item;
        sentFront.next.next.pre = sentFront;
        sentFront.next = sentFront.next.next;

        size = size-1;
        return temp;

    }


    @Override
    public T removeLast(){
        if(size()==0)
            return null;

        T temp = (T) sentBack.pre.item;
        sentBack.pre.pre.next = sentBack;
        sentBack.pre = sentBack.pre.pre;

        size=size-1;
        return temp;
    }

    @Override
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
