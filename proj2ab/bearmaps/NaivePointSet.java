package bearmaps;

import java.util.List;

public class NaivePointSet implements PointSet {

    private List<Point> points;

    @Override
    public Point nearest(double x, double y) {
        Point goal = new Point(x, y);
        double min = Double.POSITIVE_INFINITY;
        Point nearest = null;
        for (Point p : points) {
            double distance = Point.distance(goal, p);
            if(distance < min) {
                min = distance;
                nearest = p;
            };
        }
        return nearest;
    }

    public NaivePointSet(List<Point> points) {
        this.points = points;
    }
}
