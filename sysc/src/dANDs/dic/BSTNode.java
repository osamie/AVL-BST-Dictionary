package dANDs.dic;
// The "BSTNode" class.
public class BSTNode<E, K extends Sortable> {
	protected K key;

	protected E element;

	protected BSTNode<E, K> left, right;

	public BSTNode(K key, E element, BSTNode<E, K> left, BSTNode<E, K> right) {
		this.key = key;
		this.element = element;
		this.left = left;
		this.right = right;
	} // BSTNode constructor

	public K getKey() {
		return key;
	} // getKey method

	public E getElement() {
		return element;
	} // getElement method

	public BSTNode<E, K> getLeft() {
		return left;
	} // getLeft method

	public BSTNode<E, K> getRight() {
		return right;
	} // getRight method

	public void setElement(E element) {
		this.element = element;
	} // setElement method

	public void setLeft(BSTNode<E, K> node) {
		left = node;
	} // setLeft method

	public void setRight(BSTNode<E, K> node) {
		right = node;
	} // setRight method
} /* BSTNode class */