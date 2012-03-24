package dANDs.dic;
// The "DictionaryTest" class.
// This class tests two implementations of the Dictionary 
// interface by inserting 676 different entries, removing 
// half of them, and inserting 156 more entries. It also
// prints the initial dictionaries (i.e., the ones after
// inserting the first 676 entries) and searches for 6 
// randomly chosen entries in both dictionaries. Obviously,
// the search result should be the same for both dictionaries.
public class DictionaryTest {
	protected static String[] entries = new String[6 * 6];
	
	private static int array_size = 6;

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
		BSTDictionary<String, SortableString> dict1 = new BSTDictionary<String, SortableString>();
		AVLDictionary<String, SortableString> dict2 = new AVLDictionary<String, SortableString>();

		System.out.println("STARTING TO insert: ");
		
		// Insert lots of entries
		fill();
		System.out.print("{");
		for (int i = 0; i < array_size * array_size; i++) {
			int e;
			do {
				e = (int) (Math.random() * (array_size * array_size));
			} while (entries[e] == null);
			
			/**System.out.print("\"");
			System.out.print(entries[e]);
			System.out.print("\"");
			System.out.print(",");**/
			System.out.println("attempting to insert: " + entries[e]);
			dict1.insert(new SortableString(entries[e]), entries[e]);
			
			//dict2.insert(new SortableString(entries[e]), entries[e]);
			entries[e] = null;
		}
		System.out.print("};"); 
		//entries = {"AY","AC","AH","AQ","AZ","BA","AG","AR","AA","AM","AV","AJ","BI","AL","AP","BC","BD","AT","AK","AF","AE","AB","AU","BJ","BF","AX","BE","BG","AO","BB","AN","AW","AD","AI","BH","AS"};
		//String[]k = {"a","b","f","g"};
		//String[]e1 = {"h","b","d","y"};
		//dict1.insert(new SortableString(k),e1[1]);
		//dict1.insert(new SortableString("bla2"), "child");
		//dict1.insert(new SortableString("bla3"), "child3");
		// print the two dictionaries
		dict1.printTree();
		//dict2.printTree();
		
		// print the depth
		
		System.out.println("The initial BST tree has a maximum depth of "
				+ dict1.depth());
		//System.out.println("The initial AVL tree has a maximum depth of "
	//			+ dict2.depth());

		// Delete half the entries
		fill();
		for (int i = 0; i < (array_size/2) * array_size; i++) {
			int e;
			do {
				e = (int) (Math.random() * (array_size * array_size));
			} while (entries[e] == null);

			dict1.delete(new SortableString(entries[e]));
			//dict2.delete(new SortableString(entries[e]));
		}

		System.out.println("After deletes, the BST tree has a maximum depth of "
						+ dict1.depth());
		System.out.println("After deletes, the AVL tree has a maximum depth of "
						+ dict2.depth());

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
				.println("After insertions, the BST tree has a maximum depth of "
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
	} // main method
} /* DictionaryTest class */
