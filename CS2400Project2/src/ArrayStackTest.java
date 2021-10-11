import java.util.Scanner;

public class ArrayStackTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String postfix;
		System.out.println("Enter postfix expression: ");
		postfix = scan.nextLine();

		System.out.println(ResizeableArrayStack.evaluatePostfix(postfix));
		scan.close();
	}
}
