public class UnionFindTest {

    public static void main(String[] args) {
        UnionFind unionFind=new UnionFind(11);
        unionFind.connect(0,1);
        unionFind.connect(2,3);
        unionFind.connect(2,4);
        unionFind.connect(0,2);
        unionFind.connect(5,6);
        unionFind.connect(0,5);
        System.out.println(unionFind.isConnected(0,4));
    //    unionFind.printParent();
    }

}
