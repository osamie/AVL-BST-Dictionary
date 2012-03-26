package dANDs.dic;

public class AVLDictionary<E, K extends Sortable> implements Dictionary<E,K>{
	
	AVLNode<E,K> root = null;
	
	//constructor: create a new AVL tree
	public AVLDictionary(AVLNode<E,K> rt)//the root of the new tree will be passed to the constructor
	{
		root = rt; 		
	}

	//empty tree with depth of zero
	public AVLDictionary() {
		// TODO Auto-generated constructor stub
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
	public E search(K key) 
	{
		return searchElement(root, key); //start searching for the element from the root node of the tree. 
		
	}
	
	public E searchElement(AVLNode<E,K> node, K searchKey ){
		//E treeElement; 
		if(node == null) return null;
		
		else{
			if (searchKey.compareTo(node.getKey()) == 0) //if the keys are equal
			{
				return node.getElement(); //return the Element in that node
			}
			
			else if(searchKey.compareTo(node.getKey()) < 0) //if the search key is less than the node's key 
			{
				return searchElement(node.getLeft(),searchKey);//search the left subtree
			}
			else{
				return searchElement(node.getRight(),searchKey);//search the left subtree
			}
		}
			
	}

	@Override
	public void insert(K key, E element) {
		
		root = insertItem(root,element,key);
		
		
		// TODO Auto-generated method stub
		
	}
	
	public AVLNode<E,K> insertItem(AVLNode<E,K> node,E element, K key)
	{
		if(node == null)
		{
			node = new AVLNode<E,K>(key, element,null,null,0);
			System.out.println("inserting: " + element);
			//System.out.println(" node here is : " + root.getElement());
			return node;
			
		}
	    
		//E nodeElement = node.getElement();
		//BSTNode<E,K> newNode = new BSTNode<E,K>(key,element,null,null);
		
		else if(key.compareTo(node.getKey()) < 0 ){
			//newSubtree = insertItem(node.getLeft(),element,key);
			node.setLeft(insertItem(node.getLeft(),element,key));
			//System.out.print(" Inserted " + element);
			//System.out.print(" to the LEFT of: " + node.getElement() + " key: "+ key + "\n");
			return node;
		}
		
		else { // search the right subtree
		      //newSubtree = insertItem(node.getRight(),element,key);
		      node.setRight(insertItem(node.getRight(),element,key));
		      //System.out.print(" Inserted " + element);
			//	System.out.print(" to the RIGHT of: " + node.getElement() + " key: "+ key + "\n");
		      return node;
		}  // end if
	}

	@Override
	public void delete(K key) {
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
	
	
	/*
	 * rotates left only when the balance factor 
	 */
	public AVLNode<E,K> rotateLeft(AVLNode<E,K> n)
	{
		//only if there is are right and left children
		try{
			AVLNode<E,K> pivot = n.getRight();
			AVLNode<E,K> rootLeft = n.getLeft();
			AVLNode<E,K> pivotLeft = pivot.getLeft();
			AVLNode<E,K> pivotRight = pivot.getRight();
			
			n = new AVLNode(n.getKey(),n.element,rootLeft,pivotLeft, n.getBalance());
			pivot = new AVLNode(pivot.getKey(),pivot.getElement(),n,pivotLeft,pivot.getBalance());
			
			return pivot;
		
		}
		catch(NullPointerException e){
			System.out.println("null pointer Exception here:" + e.getMessage());
			
		}
		return null;
			
		//AVLNode q =root;
		//AVLNode p = q.right;
		//AVLNode c = q.left;
		//AVLNode a = p.left;
		//AVLNode b = p.right;
		//q = new AVLNode(q.key,c,a,q.getBalance());
		//p = new AVLNode(p.data,q,b);
	//return p;
	}
	
	public AVLNode<E,K> rotateRight(AVLNode<E,K> n){
		
		try{
			AVLNode<E,K> pivot = n.getLeft();
			AVLNode<E,K> rootRight = n.getRight();
			AVLNode<E,K> pivotLeft = pivot.getLeft();
			AVLNode<E,K> pivotRight = pivot.getRight();
			
			n = new AVLNode(n.getKey(),n.getElement(),pivotRight,rootRight, n.getBalance());
			pivot = new AVLNode(pivot.getKey(),pivot.getElement(),pivotLeft,n,pivot.getBalance());
			
			return pivot;
		
		}
		catch(NullPointerException e){
			System.out.println("null pointer Exception here: " + e.getMessage());
			
		}
		return null;
		
	}
	

}
