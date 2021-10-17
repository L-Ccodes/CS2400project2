import java.util.Scanner;
import java.util.Stack;


public class ArrayStackTest {
	
	/** This is the main method
	 * @param args is the argument for the main method
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String postfix;
		//System.out.println("Enter postfix expression: ");
		//postfix = scan.nextLine();
		
		postfix = "23*42-/56*+";
		System.out.println("Postfix Expression: 23*42-/56*+");
		System.out.println("Result: " + evaluatePostfix(postfix));
		scan.close();
	}
	
	/** This converts the postfix string to the evaluation.
	 * @param postfix is the initial string of the expression.
	 * @return result, returns the value of the postfix expression.
	 */
	public static double evaluatePostfix(String postfix) {
		Stack<Integer> valueStack = new Stack<>();
		int result = 0;
		char nextCharacter;
		int i = 0;
		//while loop to go through expression
		while(i < postfix.length()) {
			nextCharacter = postfix.charAt(i++); 
			
			//checks if next character is a digit
			if(Character.isDigit(nextCharacter)) {
				valueStack.push(Character.getNumericValue(nextCharacter));
			}
			//checks if next character is a space
			else if(nextCharacter != ' '){
				int operandTwo = valueStack.pop();
				int operandOne = valueStack.pop();
				
				//switch statement that checks what the operation is
				switch(nextCharacter) {
				case '+':
					result = operandOne + operandTwo;      
					break;
				case '-':
					result = operandOne - operandTwo;      
					break;
				case '*':
					result = operandOne * operandTwo;     
					break;
				case '/':
					result = operandOne / operandTwo;      
					break;
				case '^':
					result = (int) Math.pow(operandOne, operandTwo);      
					break;
				default:
					break;

				}//end switch 
				valueStack.push(result); 
			}//end if
			else {
				continue;
			}
		}//end while loop
		return valueStack.peek();       
	}
}