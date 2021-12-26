public class ArrayDeque<T> {

    private T[] items;

    private int capacity = 8;

    private int size;

    private int nextFirst;

    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item){
        if(size == capacity) {
            resizeL((int) (capacity * 1.5));
            nextFirst=(int) (capacity * 1.5 - 1 - (capacity - (nextFirst + 1)));
            capacity=(int) (capacity * 1.5);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + capacity) % capacity;

        size++;
    }

    public boolean isFull() {
        if (size == capacity)
            return true;

        return false;
    }

    public void addLast(T item){
        if(size == capacity) {
            resizeL((int) (capacity * 1.5));
            nextFirst=(int) (capacity * 1.5 - 1 -(capacity - (nextFirst + 1)));
            capacity=(int) (capacity * 1.5);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1 + capacity) % capacity;

        size++;
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;

        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < capacity; i++) {
            System.out.print("item."+i+":"+items[i]+"  ");
        }
    }

    public T removeFirst(){

        nextFirst = (nextFirst == capacity - 1) ? 0 : nextFirst + 1;

        T temp = items[nextFirst];
        items[nextFirst] = null;
        size--;


        if (ifShorten()){

            int cap=(int) (capacity * 0.5);
            nextFirst = (int) (capacity * 0.5 - 1 - (capacity - (nextFirst + 1)));
            capacity = (int) (capacity * 0.5);
            resizeS(cap);
        }


        return temp;
    }

    public T removeLast(){

        nextLast = (nextLast==0)?capacity-1:nextLast-1;
        T temp = items[nextLast];
        items[nextLast] = null;

        size--;

        if (ifShorten()){
            int cap = (int) (capacity * 0.5);
            resizeS(cap);
            capacity = (int) (capacity * 0.5);
        }


        return temp;
    }

    public T get(int index){
        if (size == 0)
            return null;
        return items[(nextFirst + index + 1) % capacity];
    }

    public boolean ifShorten(){

        double rate=(double) size/capacity;
        if ((rate<0.25) && (capacity>16))
            return true;
        return false;
    }

    public void resizeL(int cap){

        T[] newArray = (T[]) new Object[cap];
        for (int i = 0; i < nextLast; i++) {
            newArray[i] = items[i];
        }
        for (int i = capacity-1,j=cap-1; i >= nextFirst ; i--,j--) {
            newArray[j] = items[i];
        }
        items=newArray;

    }

    public void resizeS(int cap){

        T[] newArray = (T[]) new Object[cap];
        for (int i = 0; i < nextLast; i++) {
            newArray[i] = items[i];
        }
        for (int i = capacity-1,j=cap-1; i >= nextFirst ; i--,j--) {
            newArray[j] = items[i];
        }
        nextFirst = (int) (capacity*0.5-1-(capacity-(nextFirst+1)));

        items=newArray;

    }



}
