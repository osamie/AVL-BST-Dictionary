package dANDs.dic;

//public class BSTDictionary<String, SortableString> {
public class BSTDictionary<E, K extends SortableString> implements Dictionary<E,K> {
 
	BSTNode<E,K> root = null;
	

	public int depth() {
		
		// TODO Auto-generated method stub
		return depth(root);
	}
	
	//this function will return the depth/levels of nodes in the tree
	public int depth(BSTNode<E,K> av){
		if(av == null) return 0;
		else
		{
			//recursively gather the depth of the left and right trees
			return Math.max(depth(av.left),depth(av.right)) + 1;  //return the deepest of the left or right tree
		}
	}
	
	
	
	public void printTree() {
		//System.out.print(root.getElement() + " and depth is:" + depth() + "\n");
		
		//in-order traversal of BST
		
		
		printTree(root); 
		//System.out.println(); 
		
		
		
	}
	

	private void printTree(BSTNode node) { 
		 /**if (node == null) {
			 //return;
			 System.out.println(" Cannot print tree ");
		 }**/

		if(node == null){
			return;
			
		}
		
		 // left, node itself, right 
		printTree(node.getLeft());
		System.out.println(node.getElement());
		printTree(node.getRight());
		
		/**
		if ((node.getLeft() == null) && node.getRight()==null ){
			//System.out.println(node.getElement());
			System.out.println("leaf node: " + node.getElement());
		}
		else{
			if(node.getLeft()==null){
		
				System.out.println(node.getElement() +  " ->right: " + node.getRight().getElement()  );
			}
			
			else if(node.getRight()==null){
				System.out.println(node.getElement() +  "-> left: " + node.getLeft().getElement()  );
			}
			else{
				System.out.println(node.getElement() + "-> left: " + node.getLeft().getElement() + " right: " + node.getRight().getElement()  );
			}
		}
		
		
		printTree(node.getRight());
		 
		**/
		} 
	
	
	
	
	protected void visitNode(BSTNode<E,K> node){
		//findLeftmost(root)
		//System.out.println("starting to print");
		
		if(node == null) 
			System.out.println("Empty node HERE!");
		
		//if the visited node is a leaf (i.e has no right/left children)
		else if((node.getLeft() == null) && (node.getRight() == null))
		{
			System.out.println(node.getElement() ); //then simply print the element
		}
		
		else{
			if(node.getLeft() == null) //if the node has only a left subtree
			{
				System.out.println(node.getElement());
				//System.out.println(" " + node.getElement().toString());
				//System.out.println("   \\");
				visitNode(node.getRight());
			}
			
			else if (node.getRight() == null) //if the node has only a left subtree
			{
				System.out.println(node.getElement());
				//System.out.println("/");
				visitNode(node.getLeft()); //now visit the left sub tree
			}
			
			else //if the node has both right and left children 
			{
				visitNode(node.getLeft()); //now visit the left subtree
				visitNode(node.getRight()); //then visit the right subtree
				
				//System.out.println("error here, left element: " + node.getLeft().getElement());
			}
		}
		
		//return node.getElement()
	}
	
	@Override
	public E search(K key) 
	{
		return searchElement(root, key); //start searching for the element from the root node of the tree. 
		
	}
	
	public E searchElement(BSTNode<E,K> node, K searchKey ){
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
	public void insert(K key, E element) 
	{
		/**if(root == null)
		{
			root = new BSTNode<E,K>(key, element,null,null);
			System.out.println(" just initialized root here: " + element);
			//System.out.println(" node here is : " + root.getElement());
			//return node;
			
		}**/
		 root = insertItem(root,element,key);
		// TODO Auto-generated method stub
		
	}

		
	public BSTNode<E,K> insertItem(BSTNode<E,K> node,E element, K key){
	
		//BSTNode<E,K> newSubtree;
		
		if(node == null)
		{
			node = new BSTNode<E,K>(key, element,null,null);
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
		root = deleteItem(root,key); //making a reference to the subtree that will be altered
		
		
	}
	
	
	/**
	 * deleteItem
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public BSTNode<E,K> deleteItem(BSTNode<E,K> rtnode ,K key)
	{
		if(rtnode == null){
			//throw new RuntimeException("item not found in: " + rtnode.getElement().toString());
			//System.out.println("trying to delete a null node here!");
			return null;
		}
		else{
			if(rtnode.getKey().compareTo(key) == 0) //if the keys are the same
			{
				return deleteNode(rtnode);
				
			}
			
			else if(key.compareTo(rtnode.getKey()) < 0) //rtnode.key > key
			{
				rtnode.setLeft(deleteItem(rtnode.getLeft(),key) );
				return rtnode;
				
			}
			
			else{
				rtnode.setRight(deleteItem(rtnode.getRight(),key) );
				return rtnode;
			}
		
		}
		//return rtnode;
		
	}
	
	/**
	 * deleteNode
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public BSTNode<E,K> deleteNode(BSTNode<E,K> node){
		
		System.out.println("deleting node: " + node.getElement());
		
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
		
		//return new BSTNode<E,K>(null,null,null,null);
	}
	
	public BSTNode<E,K> deleteLeftmost(BSTNode<E,K> node){
		if(node.getLeft() ==  null){
			return node.getRight();
		}
		else{
			node.setLeft(deleteLeftmost(node.getLeft()));
			return node;
		}	
	}
	
	public E findLeftmost(BSTNode<E,K> node){
		if(node.getLeft() == null){
			return node.getElement();
		}
		else{
			return findLeftmost(node.getLeft());
		}
		
	}
	
	
	
	
	



	
}


