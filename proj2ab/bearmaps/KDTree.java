package bearmaps;

import java.util.List;

public class KDTree {

    private KNode root;

    public KDTree(List<Point> points){

        for (Point p :
                points) {
            put(p);
        }

    }



    public Point nearest(double x, double y) {
        return nearest(root, new Point(x, y), root).getPoint();
    }



    private KNode nearest(KNode kNode, Point goal, KNode best) {
        if (kNode == null) {
            return best;
        }
        if (kNode.distance(goal) < best.distance(goal)) {
            best = kNode;
        }
        KNode good, bad;
        double cmp = compare(kNode.getPoint(), goal, kNode.getDepth());
        if (cmp < 0) {
            good = kNode.getLeft();
            bad = kNode.getRight();
        } else {
            good = kNode.getRight();
            bad = kNode.getLeft();
        }

        double temp;
        if (kNode.getDepth() % 2 == 0) {
            temp = Math.pow(goal.getX() - kNode.getX(), 2);
        } else {
            temp = Math.pow(goal.getY() - kNode.getY(), 2);
        }


        best = nearest(good, goal, best);
        if (temp < best.distance(goal)) {
            best = nearest(bad, goal, best);
        }
        return best;
    }


    public void put(Point point) {

        root = put(root, point, 0);

    }

    private KNode put(KNode kNode, Point point, int curDepth) {

        if (kNode == null)
            return new KNode(curDepth, point);
        if (kNode.getPoint().equals(point))
            return kNode;

        double cmp = compare(point, kNode.getPoint(), curDepth);
        if (cmp < 0) {
            kNode.setLeft(put(kNode, point, curDepth + 1));
        } else {
            kNode.setRight(put(kNode, point, curDepth + 1));
        }

        return kNode;
    }

    public double compare(Point a, Point b, int depth) {
        if (depth % 2 == 0) {
            return a.getX() - b.getX();
        } else {
            return a.getY() - b.getY();
        }
    }


}
