
public class LinkedStackTest{ //LinkedStackTest class

	/** This is the main method
	 * @param args is the argument for the main method
	 */
	public static void main(String[] args) {
		
		//String that holds the infix expression
		String infix = "a*b/(c-a)+d*e";
		
		//Prints out the postfix expression
		System.out.println(convertToPostfix(infix));

	}// end main method.
	
/** This converts the infix string to a postfix expression string.
 * @param infix is the initial string of the expression.
 * @return postfix, returns the new expression in postfix form
 */
public static String convertToPostfix(String infix) {
		
	    // A new stack created to hold the operators 
		StackInterface<Character> operatorStack = new LinkedStack<>();
		
		//String for the postfix expression.
		String postfix = "";
		int counter = infix.length(); //is a counter that controls the following while loop.
		int n = 0;// Is an integer that will deal with the charAt method.
		
		//While loop to turn infix expression to postfix expression.
		while(counter > 0) {
			
			char nextCharacter = 0;
			
			//Checks to see if the next character is blank.
			if(infix.charAt(n) != ' ') {
				nextCharacter = infix.charAt(n);
			}
		
			//Switch statement that will check each character of the expression.
			switch(nextCharacter) {

			
			case '^':
			    operatorStack.push(nextCharacter);
				n++;
				counter--;
				break;
			case '+' : case '-': case '*': case '/':
				
				//checks to see if the stack isn't empty and will check the precedence of the 2 operators.
				while(!operatorStack.isEmpty() && (checkPrecednce(nextCharacter, operatorStack.peek()))) {
					postfix += operatorStack.peek();
					operatorStack.pop();
				}//end while loop.
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
				} //end while loop
				n++;
				counter--;
				break;
			default: //if the character is a variable.
				postfix = postfix + nextCharacter;
				counter--;
				n++;
				break;
		}//end switch statement 
		
	}//end while loop.
		while(!operatorStack.isEmpty()) {
			char topOperator = operatorStack.pop();
			postfix = postfix + topOperator;
		}//end while loop.
		return postfix; //returns a new string in postfix form
	}// end convertToPostfix

/** This method checks the precedence of two operators.
 * @param entry1 would be the first character being compared.
 * @param entry2 would be the second character being compared.
 * @return returns a boolean that displays which operator has 
 * higher precedence.
 */
public static boolean checkPrecednce(char entry1, char entry2) {
	
	boolean higher = false;
	
	//checks whether entry 1 has a lower precedence than entry 2.
	if(((entry1 == '+') || (entry1 == '-')) && ((entry2 == '*') || (entry2 == '/'))){
		higher = true;
	} //end if statement
	
	//checks to see if entry 1 and entry 2 have equal precedence. 
	else if(((entry1 == '+') && (entry2 == '-')) || ((entry1 == '*') && (entry2 == '/'))) {
		higher = true;
	}// end else if statement  
	
	//checks to see if entry 2 and entry 1 have equal precedence.
	else if(((entry2 == '+') && (entry1 == '-')) || ((entry2 == '*') && (entry1 == '/'))){
		higher = true;
	}// end else if statement.
	
	//all other cases.
	else {
		higher = false;
	}// end else.
	
	
	return higher;
}// end checkPrecedencef

}// end LinkedStackTest
