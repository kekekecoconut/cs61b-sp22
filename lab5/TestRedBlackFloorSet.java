import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
       // TODO: YOUR CODE HERE
        AListFloorSet aListFloorSet = new AListFloorSet();
        RedBlackFloorSet redBlackFloorSet = new RedBlackFloorSet();
        for (int i = 0; i < 1000000; i++) {
            double ran  = StdRandom.uniform(-5000.0, 5001.0);

            aListFloorSet.add(ran);
            redBlackFloorSet.add(ran);
        }



        for (int i = 0; i < 100000; i++) {
            double ra  = StdRandom.uniform(-5000.0, 5001.0);
            aListFloorSet.floor(ra);
            assertEquals(aListFloorSet.floor(ra), redBlackFloorSet.floor(ra), 0.000001);
        }
    }
}
