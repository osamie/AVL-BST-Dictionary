package dANDs.dic;

//public class BSTDictionary<String, SortableString> {
public class BSTDictionary<E, K extends SortableString> implements Dictionary<E,K> {
 
	BSTNode<E,K> root;
	

	public int depth() {
		
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public E search(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(K key, E element) {
		root = insertItem(root,element,key);
		// TODO Auto-generated method stub
		
	}

		
	public BSTNode<E,K> insertItem(BSTNode<E,K> node,E element, K key){
	
		BSTNode<E,K> newSubtree;
		
		if(node == null){
			node = new BSTNode<E,K>(key, element,null,null);
			return node;
		}
	    
		//E nodeElement = node.getElement();
		//BSTNode<E,K> newNode = new BSTNode<E,K>(key,element,null,null);
		
		if(key.compareTo(node.getKey()) < 0 ){
			newSubtree = insertItem(node.getLeft(),element,key);
			node.setLeft(newSubtree);
			return node;
		}
		
		else { // search the right subtree
		      newSubtree = insertItem(node.getRight(),element,key);
		      node.setRight(newSubtree);
		      return node;
		}  // end if
		
		
	}
	
	@Override
	public void delete(K key) {
		root = deleteItem(root,key);
		// TODO Auto-generated method stub
		
	}
	
	public BSTNode<E,K> deleteItem(BSTNode<E,K> node ,K key){
		return new BSTNode<E,K>(null,null,null,null);
	}
	
	public BSTNode<E,K> deleteNode(BSTNode<E,K> node ,K key){
		return new BSTNode<E,K>(null,null,null,null);
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
	
	public BSTNode<E,K> findLeftmost(BSTNode<E,K> node){
		if(node.getLeft() == null){
			return node;
		}
		else{
			return findLeftmost(node.getLeft());
		}
		
	}
	
	
	
	
	



	
}


