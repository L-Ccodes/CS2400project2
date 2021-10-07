import java.util.Scanner;

public class LinkedStackTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		
	}
	
public String ConvertToPostfix(String infix) {
		
		StackInterface<Character> operatorStack = new LinkedStack<>();
		String postfix = null;
		int counter = infix.length();
		int n = 0;
		while(counter > 0) {
			
			char nextCharacter = 0;
			
			if(infix.charAt(n) != ' ') {
				nextCharacter = infix.charAt(n);
			}
		
			
			switch(nextCharacter) {
			
			//case
			
			case '^':
			    operatorStack.push(nextCharacter);
				n++;
				counter--;
				break;
			case '+' : case '-': case '*': case '/':
				
				while(!operatorStack.isEmpty() && (nextCharacter <= operatorStack.peek())) {
					postfix = postfix + operatorStack.peek();
					operatorStack.pop();
				}
				operatorStack.push(nextCharacter);
				n++;
				counter--;
				break;
			case '(':
				operatorStack.push(nextCharacter);
				n++;
				counter--;
				break;
			case ')':
				char topOperator = operatorStack.pop();
				while(topOperator != '(') {
					postfix = postfix + topOperator;
				    topOperator = operatorStack.pop();
				}
				n++;
				counter--;
				break;
			default:
				postfix = postfix + nextCharacter;
				break;
		}
		
	}
		while(!operatorStack.isEmpty()) {
			char topOperator = operatorStack.pop();
			postfix = postfix + topOperator;
		}
		return postfix;
	}
}
