package bearmaps;


import org.junit.Test;

import java.util.ArrayList;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ{

    private ArrayList<Node> contents;

    private int size;


    public ArrayHeapMinPQ(ArrayList<Node> contents) {
        this.contents = contents;
    }

    public ArrayHeapMinPQ() {
        contents = new ArrayList<>(16);
   //     contents.add(0, null);
        size = 0;
    }

    public ArrayList<Node> getContents() {
        return contents;
    }

    public Node getNode(int index) {
        return contents.get(index);
    }

    public void swap(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);

        contents.set(index1, node2);
        contents.set(index2, node1);
    }

    public void swim(int k) {
        if (validateBound(k))
            return;

        if (contents.get(getParentIndex(k)).getMyPriority() > contents.get(k).getMyPriority()) {
            swap(k, getParentIndex(k));
            swim(getParentIndex(k));
        }
    }

    public int findMin(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        if (contents.get(left).getMyPriority() < contents.get(right).getMyPriority())
            return left;

        return right;
    }

    public boolean LToRoot(int index){
        int left = getLeftChildIndex(index);
        if (contents.get(left).getMyPriority() < contents.get(index).getMyPriority())
            return true;
        return false;
    }

    public boolean RToRoot(int index){
        int right = getRightChildIndex(index);
        if (contents.get(right).getMyPriority() < contents.get(index).getMyPriority())
            return true;

        return false;
    }

    public boolean validateBound(int index) {
        if (getLeftChildIndex(index) >= contents.size()-1)
            return true;

        return false;
    }

    public void dive(int index) {
        if (validateBound(index))
            return;
        //contents.get(index).getMyPriority();
        if (LToRoot(index) || RToRoot(index)) {
            int temp = findMin(index);
            swap(index, temp);
            dive(temp);
        }
    }
//[3 , 8 , 3 , 6 , 5 , 6 , 5 , 7 , 7 ]
    public int getParentIndex(int k) {
        return (k - 1) / 2;
    }

    public int getLeftChildIndex(int k) {
        return k*2 + 1;
    }

    public int getRightChildIndex(int k) {
        return k*2 + 2;
    }

    @Override
    public void add(Object item, double priority) {

        Node node = new Node<>(item, priority);
        contents.add(node);
        swim(contents.size() - 1);

    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < contents.size(); i++) {
            if (contents.get(i).getItem() == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getSmallest() {
        return contents.get(0);
    }

    @Override
    public Object removeSmallest() {
        Node first = contents.get(0);
        Node fin = contents.get(contents.size() - 1);
        contents.set(0, fin);
        contents.remove(contents.size() - 1);
        dive(0);

        return first;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void changePriority(Object item, double priority) {
        for (int i = 0; i < contents.size() - 1; i++) {
            if (contents.get(i).getItem().equals(item)) {
                if (priority > contents.get(i).getMyPriority()) {
                    contents.get(i).setMyPriority(priority);
                    dive(i);
                } else if (priority < contents.get(i).getMyPriority()) {
                    contents.get(i).setMyPriority(priority);
                    swim(i);
                }
            }
        }
    }



    @Test
    public void test1(){

    }

    public static void main(String[] args) {

        ArrayList<Node> arrayList = new ArrayList<>();
        arrayList.add(new Node<Integer>(1,1));
        arrayList.add(new Node<Integer>(5,5));
        arrayList.add(new Node<Integer>(1,1));
        arrayList.add(new Node<Integer>(6,6));
        arrayList.add(new Node<Integer>(5,5));
        arrayList.add(new Node<Integer>(6,6));
        arrayList.add(new Node<Integer>(3,3));
        arrayList.add(new Node<Integer>(7,7));
        arrayList.add(new Node<Integer>(7,7));
        arrayList.add(new Node<Integer>(8,8));
     //   arrayList.add(new Node<Integer>(3,3));


        ArrayHeapMinPQ<Node> arrayHeapMinPQ = new ArrayHeapMinPQ<Node>(arrayList);
        System.out.println(arrayList);
        arrayHeapMinPQ.add(3, 3);
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);

        arrayHeapMinPQ.removeSmallest();
        System.out.println(arrayList);



    }




}
