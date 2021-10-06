
public class LinkedStackTest {

	public static void main(String[] args) {
		
	}
	
public String ConvertToPostfix(String infix) {
		
		StackInterface<String> operatorStack = new LinkedStack<String>();
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
			case '+' : case '-': case '*': case '/':
				
				while(!)
		
		
	
		}
		
	}
		return postfix;
	}
}
