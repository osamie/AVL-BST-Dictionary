package dANDs.dic;
// The "AVLNode" class.
public class AVLNode<E, K extends Sortable> {
	// Public constants.
	public static final int MORE_LEFT = 1;

	public static final int EVEN = 2;

	public static final int MORE_RIGHT = 3;

	// Instance variables.
	protected K key;

	protected E element;

	protected AVLNode<E, K> left, right;

	protected int balance; // One of MORE_LEFT, EVEN, or MORE_RIGHT.

	public AVLNode(K key, E element, AVLNode<E, K> left, AVLNode<E, K> right,
			int balance) {
		this.key = key;
		this.element = element;
		this.left = left;
		this.right = right;
		this.balance = balance;
	} // AVLNode constructor

	public K getKey() {
		return key;
	} // getKey method

	public E getElement() {
		return element;
	} // getElement method

	public AVLNode<E, K> getLeft() {
		return left;
	} // getLeft method

	public AVLNode<E, K> getRight() {
		return right;
	} // getRight method

	public int getBalance() {
		return balance;
	} // getBalance method

	public void setKey(K key) {
		this.key = key;
	} // setKey method

	public void setElement(E element) {
		this.element = element;
	} // setElement method

	public void setLeft(AVLNode<E, K> node) {
		left = node;
	} // setLeft method

	public void setRight(AVLNode<E, K> node) {
		right = node;
	} // setRight method

	public void setBalance(int balance) {
		this.balance = balance;
	} // setBalance method
} /* AVLNode class */