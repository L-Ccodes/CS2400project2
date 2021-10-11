import java.util.EmptyStackException;

/** Class created to create a stack
 *
 * @param <T> is a generic data type. The user can choose the data type that
 * will be used.
 */
public final class LinkedStack<T> implements StackInterface<T>
{
	//private data fields
	private Node topNode; // References the first node in the chain
	private boolean integrityOk = false;
	
	/** Constructor for a creates stack.
	 * 
	 */
   public LinkedStack()
   {
      topNode = null;
      integrityOk = true;
   } // end default constructor
  
   /** Checks the security of the stack that has been passed by the user.
    * 
    */
   private void checkIntegrity() {
	  
	   //Checks to see if integrityOk is false.
	   if(!integrityOk) {
		   throw new SecurityException("Object is corrupt");
	   }//end if statement
   }// end checkIntegrity
   
    /** Pushes a new entry into the stack
     *  @param newEntry is the entry that will be pushed into the stack.
     */
	public void push(T newEntry) {
	
		checkIntegrity();
		if(newEntry == null) {
			throw new NullPointerException("Object is null");
		}
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		
	}// end push

	/** Pops (or takes out) the top entry of the stack.
	 * @return top returns what entry is popped out.
	 */
	public T pop() {
		
		checkIntegrity();
		T top = peek();
		topNode = topNode.getNextNode();
		
		return top;
	}//end pop

	/** A method designed to see what is at the top of the stack.
	 * @return what is at the top of the stack.
	 */
	public T peek() {
		
		checkIntegrity();
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return topNode.getData();
	}// end peek
	
	/** Checks to see if the stack is empty.
	 * @return null.
	 */
	public boolean isEmpty() {
		
		checkIntegrity();
		return topNode == null;
	}//end isEmpty

	/** Clears out the entire stack.
	 * @return null.
	 */
	public void clear() {
		
		checkIntegrity();
		topNode = null;
		
	}//end clear
	

	/** Class used to create and deal with nodes.
	 * 
	 */
	private class Node
	{
	  //private data fields
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      /** Constructor for a new node with a data argument.
       * @param dataPortion contains data for the node.
       */
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      /** Constructor for a new node that has data, and a link to another node.
       * 
       * @param dataPortion contains data for the node.
       * @param linkPortion contains a link to the node.
       */
      private Node(T dataPortion, Node linkPortion)
      {
    
         data = dataPortion;
         next = linkPortion;
      } // end constructor
      
      /** Gets the data inside of a node.
       * @return the data in the node.
       */
      private T getData()
      {
         return data;
      } // end getData
      
      /** Puts new data in a node.
       * @param newData is the new data that will go inside of the node.
       */
      private void setData(T newData) {
    
         data = newData;
      } // end setData
      
      /** A method that will get what node is next.
       * 
       * @return the next node.
       */
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      /** Will create the next node.
       * 
       * @param nextNode is the node that will be next.
       */
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node

} // end LinkedStack
