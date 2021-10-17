import java.util.Arrays;
import java.util.EmptyStackException;

/** Class created to create a stack
*
* @param <T> is a generic data type. The user can choose the data type that
* will be used.
*/
public final class ResizeableArrayStack<T> implements StackInterface<T>{
	//private fields
	private T[] stack;
	private int topIndex;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	/** Constructor for a creates stack.
	 * 
	 */
	public ResizeableArrayStack(){
		this(DEFAULT_CAPACITY);
	}// end default constructor

	public ResizeableArrayStack(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;

	}
	/* Checks the capacity of the stack
	 * 
	 */
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose " +"capacity exeeds allowed " +"maximum of " + MAX_CAPACITY);
	}
	
	/** Pushes a new entry into the stack
     *  @param newEntry is the entry that will be pushed into the stack.
     */
	public void push(T newEntry){
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;

	}
	private void ensureCapacity(){
		if (topIndex == stack.length - 1){
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}
	
	/** A method designed to see what is at the top of the stack.
	 * @return what is at the top of the stack.
	 */
	public T peek(){
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}
	
	/** Pops (or takes out) the top entry of the stack.
	 * @return top returns what entry is popped out.
	 */
	public T pop(){

		if (isEmpty())
			throw new EmptyStackException();
		else{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} 
	}
	
	/** Checks to see if the stack is empty.
	 * @return null.
	 */
	public boolean isEmpty(){
		return topIndex < 0;
	}

	/** Checks the security of the stack that has been passed by the user.
	    * 
	    */
	private void checkIntegrity() {
		//Checks to see if integrityOk is false.
		if(!integrityOK) {
			throw new SecurityException("Object is corrupt");
		}//end if statement
	}// end checkIntegrity

	/** Clears out the entire stack.
	 * @return null.
	 */
	public void clear() {
		checkIntegrity();
		while (topIndex > -1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

}