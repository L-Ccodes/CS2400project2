import static org.junit.Assert.*;

import org.junit.Test;

/** Tests the methods inside LinkedStackTest
 * 
 * @author Christian Williams
 *
 */
public class convertToPostfixTest {

	@Test
	/** Tests the convertToPostfix method.
	 * 
	 */
	public void test() {
		// Is a string that will be used to check the method.
		String output = LinkedStackTest.convertToPostfix("a+b-c");
		
		//checks to see if the output equals what is expected.
		assertEquals("ab+c-", output);	
					
	}
	
	@Test
	/** Tests the checkPrecedence method.
	 * 
	 */
	public void test2() {
		
		//Two chars that will be compared.
		char entry1 = '+';
		char entry2 = '-';

		//boolean that returns true or false depending on the conditions
		boolean output = LinkedStackTest.checkPrecednce(entry1, entry2);
		
		//checks to see if the output equals what is expected.
		assertEquals(true, output);
		
	}

}
