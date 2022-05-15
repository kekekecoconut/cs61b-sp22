package bearmaps;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayHeapMinPQTest {

    @Test
    public void testDive() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        for (int i = 0; i < 7; i++) {
            pq.getContents().add(new Node("i" + (i + 1), i + 1));
        }
        System.out.println(pq.getContents());

        pq.getContents().get(0).setMyPriority(10);
        System.out.println("before:");
        System.out.println(pq.getContents());


        pq.dive(0);
        System.out.println("after:");
        System.out.println(pq.getContents());
        assertEquals("i2", pq.getContents().get(0).getItem());
        assertEquals("i4", pq.getContents().get(1).getItem());
        assertEquals("i3", pq.getContents().get(2).getItem());
        assertEquals("i1", pq.getContents().get(3).getItem());
        assertEquals("i5", pq.getContents().get(4).getItem());
        assertEquals("i6", pq.getContents().get(5).getItem());
        assertEquals("i7", pq.getContents().get(6).getItem());
    }

    @Test
    public void test1() {
        ArrayHeapMinPQ<Integer> pq = new ArrayHeapMinPQ<>();

        pq.getContents().add(new Node<Integer>(1,1));
        pq.getContents().add(new Node<Integer>(5,5));
        pq.getContents().add(new Node<Integer>(1,1));
        pq.getContents().add(new Node<Integer>(6,6));
        pq.getContents().add(new Node<Integer>(5,5));
        pq.getContents().add(new Node<Integer>(6,6));
        pq.getContents().add(new Node<Integer>(3,3));
        pq.getContents().add(new Node<Integer>(7,7));
        pq.getContents().add(new Node<Integer>(7,7));
        pq.getContents().add(new Node<Integer>(8,8));

        pq.add(3, 3);

        pq.removeSmallest();

        pq.removeSmallest();

        pq.removeSmallest();

        pq.removeSmallest();

        pq.removeSmallest();

        pq.removeSmallest();

        pq.removeSmallest();

        pq.removeSmallest();

        assertEquals(7, pq.getContents().get(0).getItem());
        assertEquals(7, pq.getContents().get(1).getItem());
        assertEquals(8, pq.getContents().get(2).getItem());
    }
}
