import java.util.Arrays;
import java.util.EmptyStackException;

public final class ResizeableArrayStack<T> implements StackInterface<T>{

	private T[] stack;
	private int topIndex;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;


	public ResizeableArrayStack(){
		this(DEFAULT_CAPACITY);
	}

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
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose " +"capacity exeeds allowed " +"maximum of " + MAX_CAPACITY);
	}

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
	public T peek(){
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}
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
	public boolean isEmpty(){
		return topIndex < 0;
	}

	private void checkIntegrity() {
		//Checks to see if integrityOk is false.
		if(!integrityOK) {
			throw new SecurityException("Object is corrupt");
		}//end if statement
	}// end checkIntegrity

	public void clear() {
		checkIntegrity();
		while (topIndex > -1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

}