package dANDs.dic;

public class AVLDictionary<E, K extends Sortable> implements Dictionary<E,K>{
	
	AVLNode<E,K> root = null;
	
	//constructor: create a new AVL tree
	public AVLDictionary(AVLNode<E,K> rt)//the root of the new tree will be passed to the constructor
	{
		root = rt; 		//initializes the root node of the AVLDictionary
	}

	//empty tree with depth of zero
	public AVLDictionary() {
		
	}

	
	public void printTree() {
		printTree(root);  //printTree overload; starts traversing from the root node of the dictionary
		
	}

	
	private void printTree(AVLNode<E,K> node) { 
		if(node == null){
			return;		
		}
		
		//Now do an inorder traversal of the tree
		// left, node itself, right 
		printTree(node.getLeft());   //left subtree 
		System.out.println(node.getElement());  //print the node
		printTree(node.getRight()); //right subtree
	}
	
	//this function returns the depth of the entire dictionary
	public int depth() 
	{
		return depth(root); //pass the rootnode of the dictionary to a helper function
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
		
		//use a helper function which takes in what root to begin the insertion from 
		root = insertItem(root,element,key); //make an assignment to root i.e a method of passing root as a reference	
	}
	
	public AVLNode<E,K> insertItem(AVLNode<E,K> node,E element, K key)
	{
		if(node == null) //if the subtree where the new node should be inserted is empty/null 
		{
			node = new AVLNode<E,K>(key, element,null,null,0);  //
			//System.out.println("(AVL Tree)inserting: " + element);
			//System.out.println(" node here is : " + root.getElement());
			return node;
			
		}
		else if(key.compareTo(node.getKey()) < 0 ) //LeftInsert : key is less than node.key
		{
			//newSubtree = insertItem(node.getLeft(),element,key);
			node.setLeft(insertItem(node.getLeft(),element,key));
					
		}
		
		else { // search the right subtree
		      //newSubtree = insertItem(node.getRight(),element,key);
		      node.setRight(insertItem(node.getRight(),element,key));   
		}  
		
		
		if (checkAVLBalance(node)==0) //if the node has a balance factor less than -1
		{
			//System.out.println("Balanced tree after insertion");
			return node;
			
		}
		else if(checkAVLBalance(node)==-1) //subtree is more right
		{
			AVLNode<E,K> R = node.getRight();
			AVLNode<E,K> L = node.getLeft();
			if((depth(R.getLeft()) - depth(R.getRight()))==-1 ){
				node = rotateLeft(node);// rotate leftwards
			}
			
			else if((depth(R.getLeft()) - depth(R.getRight()))==1 ){
				node.setRight(rotateRight(R)); //right rotation, R as the root
				node = rotateLeft(node);// rotate leftwards
			}
			
			//System.out.println("rotated left!");
			return node;
		}
		
		else if(checkAVLBalance(node)==1) //subtree is more right
		{
			AVLNode<E,K> R = node.getRight();
			AVLNode<E,K> L = node.getLeft();
			if((depth(L.getLeft()) - depth(L.getRight()))==1 ){
				node = rotateRight(node);// rotate leftwards
			}
			
			else if((depth(L.getLeft()) - depth(L.getRight()))==-1 ){
				node.setLeft(rotateLeft(L)); //right rotation, R as the root
				node = rotateRight(node); // rotate leftwards
			}
			
			//System.out.println("rotated left!");
			return node;
		}
		
		//else{
			//node = rotateRight(node);  //rotate rightwards
			//System.out.println("rotated right!");
			//return node;
		//}
		
		return node;
		
	}

	@Override
	public void delete(K key) {
		root = deleteItem(root,key); //making a reference to the subtree that will be altered
		
	}
	
	public AVLNode<E,K> deleteItem(AVLNode<E,K> rtnode ,K key)
	{
		if(rtnode == null){
			//throw new RuntimeException("item not found in: " + rtnode.getElement().toString());
			//System.out.println("trying to delete a null node here!");
			return null;
		}
		//else{
			if(rtnode.getKey().compareTo(key) == 0) //if the keys are the same
			{
				return deleteNode(rtnode);
				
			}
			
			else if(key.compareTo(rtnode.getKey()) < 0) //rtnode.key > key
			{
				rtnode.setLeft(deleteItem(rtnode.getLeft(),key) );
				return rtnode;
				
			}
			
			//else{
				rtnode.setRight(deleteItem(rtnode.getRight(),key) );
				
			//}
		
		//}
				
				
				if (checkAVLBalance(rtnode)==0) //if the node has a balance factor less than -1
				{
					//System.out.println("Balanced tree after insertion");
					return rtnode;
					
				}
				else if(checkAVLBalance(rtnode)==-1) //subtree is more right
				{
					AVLNode<E,K> R = rtnode.getRight();
					AVLNode<E,K> L = rtnode.getLeft();
					if((depth(R.getLeft()) - depth(R.getRight()))==-1 ){
						rtnode = rotateLeft(rtnode);// rotate leftwards
					}
					
					else if((depth(R.getLeft()) - depth(R.getRight()))==1 ){
						rtnode.setRight(rotateRight(R)); //right rotation, R as the root
						rtnode = rotateLeft(rtnode);// rotate leftwards
					}
					
					//System.out.println("rotated left!");
					return rtnode;
				}
				
				else if(checkAVLBalance(rtnode)==1) //subtree is more right
				{
					AVLNode<E,K> R = rtnode.getRight();
					AVLNode<E,K> L = rtnode.getLeft();
					if((depth(L.getLeft()) - depth(L.getRight()))==1 ){
						rtnode = rotateRight(rtnode);// rotate leftwards
					}
					
					else if((depth(L.getLeft()) - depth(L.getRight()))==-1 ){
						rtnode.setLeft(rotateLeft(L)); //right rotation, R as the root
						rtnode = rotateRight(rtnode); // rotate leftwards
					}
					
					//System.out.println("rotated left!");
					return rtnode;
				}
				
		/**
		if (checkAVLBalance(rtnode)==0) //if the node has a balance factor less than -1
		{
			System.out.println("Balanced tree after deletion");
			//return rtnode;
			
		}
		else if(checkAVLBalance(rtnode)==1) //else if the node has a balance factor > 1
		{
			rtnode = rotateLeft(rtnode);// rotate leftwards
			System.out.println("rotated left!");
			//return rtnode;
		}
		else{
			rtnode = rotateRight(rtnode);
			System.out.println("rotated right!");
			//return rtnode;
		}
		**/
		return rtnode;
		
	}
	
	public AVLNode<E,K> deleteNode(AVLNode<E,K> node){
		System.out.println("Deleting AVL node: " + node.getElement());
		
		//if the node is a leaf
		if((node.getLeft() == null) && (node.getRight() == null))
		{
			return null;
			
		}
		
		//if node has no left child
		else if (node.getLeft() == null){
			return node.getRight();
		}
		
		//if node has no right child
		else if (node.getRight() == null){
			return node.getLeft();
		}
		
		//if the tree has 2 children
		else{
			node.setElement(findLeftmost(node.getRight()));
			node.setRight(deleteLeftmost(node.getRight()));
			return node;
			
		}
	}
	
	
	
	public AVLNode<E,K> deleteLeftmost(AVLNode<E,K> node){
		if(node.getLeft() ==  null)
		{
			return node.getRight();
		}
		else{
			node.setLeft(deleteLeftmost(node.getLeft()));
			return node;
		}	
	}
	
	
	//returns the leftmost element in the subtree
	public E findLeftmost(AVLNode<E,K> node)
	{
		if(node.getLeft() == null)//if the left subtree is empty
		{
			return node.getElement(); //then return the node's element
		}
		else{
			return findLeftmost(node.getLeft()); //recursively the leftmost element of the left subtree 
		}
		
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
	it returns 1 to rotate the node rightwards. **/
	
	public int checkAVLBalance(AVLNode<E,K> node){
		
		//return depth(node.left)-depth(node.right);
		
		if(depth(node.left)-depth(node.right) >= 2)//if subtree is moreLeft 
		{
			return 1;
		}
		
		else if((depth(node.right)-depth(node.left) >= 2 )) //if subtree is more right
		{
			return -1;
		}
		else{
			return 0;
		}
		
		
		
		/**
		if(depth(node.right)-depth(node.left) >= 2)//if subtree is more 
		{
			return 1;
		}
		else if(depth(node.left)-depth(node.right) > 2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
		**/
		
	}
	
	
	/*
	 * rotates left only when the balance factor 
	 */
	public AVLNode<E,K> rotateLeft(AVLNode<E,K> n)
	{				
		//Try rotating left...if the required subtrees are present
		try{
			AVLNode<E,K> pivot = n.getRight(); //the right subtree of the node
			AVLNode<E,K> rootLeft = n.getLeft();  //the left subtree of the node
			AVLNode<E,K> pivotLeft = pivot.getLeft(); //the left subtree of the right subtree of the node
			AVLNode<E,K> pivotRight = pivot.getRight(); //the right subtree of the right subtree of the node
			
			
			//the left child of the node remains unchanged as node.left
			//the left child of the right subtree of the node becomes the node's right    
			n = new AVLNode<E,K>(n.getKey(),n.element,rootLeft,pivotLeft, n.getBalance()); 
			
			 
			pivot = new AVLNode<E,K>(
					pivot.getKey(),   
					pivot.getElement(),
					n,    //left child of pivot
					pivotRight, //right child of pivot
					pivot.getBalance());
			
			return pivot;
		
		}
		catch(NullPointerException e){
			//System.out.println("null pointer Exception here: unable to rotate " + n.getElement() + " left");
			
		}
		return n; //we need to return the origin node unchanged, since the rotate did not happen
			
	}
	
	public AVLNode<E,K> rotateRight(AVLNode<E,K> n){
		
		//Try rotating right...if the required nodes are present
		try{
			AVLNode<E,K> pivot = n.getLeft();
			AVLNode<E,K> rootRight = n.getRight();
			AVLNode<E,K> pivotLeft = pivot.getLeft();
			AVLNode<E,K> pivotRight = pivot.getRight();
			
			n = new AVLNode<E,K>(n.getKey(),n.getElement(),pivotRight,rootRight, n.getBalance());
			pivot = new AVLNode<E, K>(pivot.getKey(),pivot.getElement(),pivotLeft,n,pivot.getBalance());
			
			return pivot;
		
		}
		catch(NullPointerException e){
			//System.out.println("null pointer Exception here: unable to rotate " + n.getElement() + " right");
			
		}
		return n;
		
	}
	

}
