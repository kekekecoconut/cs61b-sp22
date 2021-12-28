import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator off = new OffByN(5);

    @Test
    public void test1(){
        assertEquals(true, off.equalChars('f','a'));
        assertEquals(false, off.equalChars('e','a'));
    }
}
