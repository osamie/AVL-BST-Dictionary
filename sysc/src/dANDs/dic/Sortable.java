package dANDs.dic;

// The "Sortable" interface.
// This interface is used by classes to compare two
// objects so that they can be sorted.
public abstract interface Sortable {
	// Compare two objects. If the object being compared is less than
	// 'other', then compareTo returns -1, if the objects are equivalent,
	// then it returns 0, otherwise it returns 1. This is similar to the
	// compareTo method of the String class. Most methods will throw
	// an exception if you attempt to compare two dissimilar objects,
	// even if they both implement the Sortable interface.
	public abstract int compareTo(Sortable other);
} /* Sortable interface */
