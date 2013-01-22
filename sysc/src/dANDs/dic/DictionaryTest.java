
package dANDs.dic;

import java.util.*;
// The "DictionaryTest" class.
// This class tests two implementations of the Dictionary 
// interface by inserting 676 different entries, removing 
// half of them, and inserting 156 more entries. It also
// prints the initial dictionaries (i.e., the ones after
// inserting the first 676 entries) and searches for 6 
// randomly chosen entries in both dictionaries. Obviously,
// the search result should be the same for both dictionaries.
public class DictionaryTest {
	private static int array_size = 26;
	protected static String[] entries = new String[array_size * array_size];
	
	protected static void fill() {
		// Insert 26 * 26 entries
		for (int i = 0; i < array_size; i++)
			for (int j = 0; j < array_size; j++) {
				StringBuffer s = new StringBuffer();
				s.append((char) ((int) 'A' + i));
				s.append((char) ((int) 'A' + j));
				entries[i * array_size + j] = s.toString();
			}
	} // fill method

	public static void main(String[] args) {
		System.out.println("		------------------------");
		System.out.println("		AVL AND BST DICTIONARY");
		System.out.println("		-----------------------");
		System.out.println();
		
		
		BSTDictionary<String, SortableString> dict1 = new BSTDictionary<String, SortableString>();
		AVLDictionary<String, SortableString> dict2 = new AVLDictionary<String, SortableString>();

		
		
		
		// Insert lots of entries	
		fill();
		//System.out.print("{");
		for (int i = 0; i < array_size * array_size; i++) {
			int e;
			do {
				e = (int) (Math.random() * (array_size * array_size));
			} while (entries[e] == null);
			
			
			
			dict1.insert(new SortableString(entries[e]), entries[e]);
			
			dict2.insert(new SortableString(entries[e]), entries[e]);
			//System.out.println();
			entries[e] = null;
		}
		System.out.println("\n -----------------------------------------------------");
		System.out.println("In-order traversal of BST nodes after insertion: ");
		dict1.printTree();
		System.out.println("----------------end of BST node traversal--------------------------------");
		
		
		System.out.println("\n -----------------------------------------------------");
		System.out.println("In-order traversal of AVL nodes after insertion: ");
		dict2.printTree();
		System.out.println("----------------end of AVL node traversal--------------------------------");
		
		
		// print the depth	
		System.out.println("The initial BST tree has a maximum depth of "
				+ dict1.depth());
		System.out.println("The initial AVL tree has a maximum depth of "
				+ dict2.depth());

		
		
		
		// Delete half the entries
		fill();
		for (int i = 0; i < (array_size/2) * array_size; i++) {
			int e;
			do {
				e = (int) (Math.random() * (array_size * array_size));
			} while (entries[e] == null);

			dict1.delete(new SortableString(entries[e]));
			dict2.delete(new SortableString(entries[e]));
		}

		System.out.println("\nAfter deletes, the BST tree has a maximum depth of "
						+ dict1.depth());
		System.out.println("After deletes, the AVL tree has a maximum depth of "
						+ dict2.depth());

		System.out.println("\n -----------------------------------------------------");
		System.out.println("In-order traversal of BST nodes after deletion: ");
		dict1.printTree();
		System.out.println("----------------end of BST node traversal--------------------------------");
		
		System.out.println("\n -----------------------------------------------------");
		System.out.println("In-order traversal of AVL nodes after deletion: ");
		dict2.printTree();
		System.out.println("----------------end of AVL node traversal--------------------------------");
		
		// Add a quarter the entries
		fill();
		for (int i = 0; i < (array_size/4) * array_size; i++) {
			int e;
			do {
				e = (int) (Math.random() * (array_size * array_size));
			} while (entries[e] == null);

			dict1.insert(new SortableString(entries[e]), entries[e]);
			dict2.insert(new SortableString(entries[e]), entries[e]);
		}

		System.out
				.println("\nAfter insertions, the BST tree has a maximum depth of "
						+ dict1.depth());
		System.out
				.println("After insertions, the AVL tree has a maximum depth of "
						+ dict2.depth());

		// Search for a few random entries
		fill();
		for (int i = 0; i < array_size/4; i++) {
			int e;
			do {
				e = (int) (Math.random() * (array_size * array_size));
			} while (entries[e] == null);

			System.out.print("Searching for " + entries[e] + ": ");
			if (dict1.search(new SortableString(entries[e])) == null) {
				System.out.print("Not found in Dict1, ");
			} else {
				System.out.print("Found in Dict1, ");
			}
			if (dict2.search(new SortableString(entries[e])) == null) {
				System.out.println("not found in Dict2.");
			} else {
				System.out.println("found in Dict2.");
			}
		}
		///boolean Bbal = (dict1.checkAVLBalance(dict1.root)==0)?true:false;
		//boolean Abal = (dict2.checkAVLBalance(dict2.root)==0)?true:false;
		System.out.println();
		//System.out.println("Is BST Dictionary balanced?: " + Bbal );
		//System.out.println("Is AVL Dictionary balanced?: " + Abal );
	} // main method
} /* DictionaryTest class */
