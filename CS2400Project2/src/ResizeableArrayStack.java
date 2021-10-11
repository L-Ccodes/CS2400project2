import java.util.Stack;

public class ResizeableArrayStack {
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