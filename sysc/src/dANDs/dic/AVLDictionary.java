package dANDs.dic;

public class AVLDictionary<E, K extends Sortable> implements Dictionary<E,K>{
	
	AVLNode<E,K> root;
	
	//constructor: create a new AVL tree
	public AVLDictionary(AVLNode<E,K> rt)//the root of the new tree will be passed to the constructor
	{
		root = rt; 		
	}

	//empty tree with depth of zero
	public AVLDictionary() {
		// TODO Auto-generated constructor stub
	}

	public void delete(SortableString sortableString) {
		// TODO Auto-generated method stub
		
	}

	public void insert(SortableString sortableString, String string) {
		// TODO Auto-generated method stub
		
	}

	public void printTree() {
		// TODO Auto-generated method stub
		
	}

	public int depth() {
		
		// TODO Auto-generated method stub
		return 0;
	}
	
	//this function will return the depth/levels of nodes in the tree
	public int depth(AVLNode<E,K> av){
		if(av == null) return 0;
		
		else
		{
			//recursively gather the depth of the left and right trees
			return Math.max(depth(av.left),depth(av.right)) + 1;  //return the deepest of the left or right tree
		}
	}

	@Override
	public Object search(Sortable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Sortable key, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sortable key) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/**
	 * check whether the tree is balanced or not
	 */
	public int checkAVLBalance(){
		return checkAVLBalance(root);
	}
	
	/**
	checks whether the node is balanced or not after an insertion or deletion. 
	If the depth of the right sub-tree minus the depth of the left subtree is greater than or equal to 2 then
	it returns 1 to rotate the node leftwards. Similarly if the depth of the left
	subtree minus the depth of the right subtree is greater than or equal to 2
	then it returns -1 to rotate the node rightwards. Otherwise it returns 0 and
	it means that no rotation is needed in that situation**/
	
	public int checkAVLBalance(AVLNode<E,K> node){
		if(depth(node.right)-depth(node.left) >= 2)
		{
			return 1;
		}
		else if(depth(node.left)-depth(node.right) >= 2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

}
