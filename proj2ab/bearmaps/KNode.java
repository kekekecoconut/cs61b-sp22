package bearmaps;

public class KNode {

    private int depth;

    private KNode left;

    private KNode right;

    private Point point;

    public KNode(int depth, Point point) {
        this.depth = depth;
        this.point = point;
    }

    public double distance(Point p) {
        return Point.distance(point, p);
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public KNode getLeft() {
        return left;
    }

    public void setLeft(KNode left) {
        this.left = left;
    }

    public KNode getRight() {
        return right;
    }

    public void setRight(KNode right) {
        this.right = right;
    }
}
