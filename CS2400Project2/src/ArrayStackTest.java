import java.util.Scanner;
import java.util.Stack;

public class ArrayStackTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String postfix;
		System.out.println("Enter postfix expression: ");
		postfix = scan.nextLine();

		System.out.println(evaluatePostfix(postfix));
		scan.close();
	}
	
	public static double evaluatePostfix(String postfix) {
		Stack<Integer> valueStack = new Stack<>();
		int result = 0;
		char nextCharacter;
		int i = 0;
		while(i < postfix.length()) {
			nextCharacter = postfix.charAt(i++); 
			if(Character.isDigit(nextCharacter)) {
				valueStack.push(Character.getNumericValue(nextCharacter));
			}
			else if(nextCharacter != ' '){
				int operandTwo = valueStack.pop();
				int operandOne = valueStack.pop();

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

				}
				valueStack.push(result); 
			}
			else {
				continue;
			}
		}
		return valueStack.peek();       
	}
}
