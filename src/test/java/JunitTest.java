import cn.com.Htest.FTest;
import org.junit.Test;

/**
 * Unit test class
 */
public class JunitTest {
    @Test
    public void convertToLetters(){
        //defines the alphanumeric set
        new FTest().initDigitsMap();
        //numeral conversion letter
        new FTest().digitsToLetters();
    }
}
