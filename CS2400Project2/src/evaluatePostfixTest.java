import static org.junit.Assert.*;
import org.junit.Test;

/** Tests the methods inside ArrayStackTest
 * 
 * @author Luis Navarrete
 *
 */
public class evaluatePostfixTest {

	@Test
	/** Tests the evaluatePostfix method.
	 * 
	 */
	public void test() {
		
		double output = ArrayStackTest.evaluatePostfix("23*42-/56*+");
		assertEquals(33.0, output, 0.0);
	}

}
