public class Main {

public static void main ( String [] args ) {
// Create two lists
ShoppingList list1 = new ShoppingList (" List1 ");
ShoppingList list2 = new ShoppingList (" List2 ");

// Print list information
list1 . printList ();
list2 . printList ();

// Add items
list1 . addItem ( " Apple " );
list1 . addItem ( " Bread " );
list1 . addItem ( " Corn " );

// Add items
list2 . addItem ( " Carrot " );
list2 . addItem ( " Bread " );

// Print list information
list1 . printList ();
list2 . printList ();

// Combine two lists (no modification )
ShoppingList list3 = list1 . combine ( list2 );
list3 . printList ();

// Add items from another list
list2 . addItem ( list1 );
list2 . printList ();

// Clear list
list2 . clear ();
list2 . printList ();
}

}