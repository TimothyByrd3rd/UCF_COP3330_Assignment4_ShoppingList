/*
COP3330 Fall 2025
Programming Assignment 4
Student Name: Timothy Byrd
File Name: ShoppingList.java
NOTE: I hereby certify that this submission is my original work.
It was completed independently by me without unauthorized assistance.
I affirm that all sources consulted have been properly acknowledged.
No part of this work was copied or plagiarized from any other source/s.
*/

/* File Introduction:
This file creates a shopping list class. It can manipulate items in the list as well as add other items from a different list, and combine the lists.
*/

import java.util.ArrayList;

public class ShoppingList {
//private fields
    private String name; //representing name of ShoppingList object
    
    private ArrayList<String> shoppingList; //An arbitrary list of distinct items. Each item is represented by a String in lowercase

//public methods
    public ShoppingList(String name){ //creates empty shopping list with specified name
        this.name = name.stripLeading().stripTrailing();
        this.shoppingList  = new ArrayList<>();
    }
    public void addItem(String item){ //Adds a single item to the shopping list only if it is not already present. The item name is automatically converted to lowercase before being stored.
        item = item.toLowerCase(); // converts item to lowercase
        if(hasItem(item) == false){
            this.shoppingList.add(item);
        }
    }    
    public void addItem(ShoppingList otherList){//Adds all items from otherList to the current shopping list. Only items that are not already in the list are added. The items are added in the same order as they appear in otherList.
        for (String item : otherList.shoppingList){
            if (!this.shoppingList.contains(item)) {
                this.shoppingList.add(item);
            }
        }
    }
    public void removeItem(String item){ //Removes the specified item from the shopping list, if it exists.
        if(this.shoppingList.contains(item)){
            this.shoppingList.remove(item);
        }
    }
    public boolean hasItem(String item){ //Returns true if the specified item is in the shopping list, and false otherwise.
        return this.shoppingList.contains(item);
    }
    public int getItemCount(){//Returns the total number of items currently in the shopping list.
        return shoppingList.size();
    }
    public void printList(){//The output starts with the name of the list, followed by a single space and the number of items enclosed in parentheses. Each item is then printed on a separate line in the order they were added.
        System.out.printf( "%s (%d)\n", this.getName(), this.getItemCount());
            //prints this message if empty
            if(this.shoppingList.isEmpty()){
                System.out.println("*");
            }
            //prints items if shoppingList has items
            else{
                for(String item : this.shoppingList){
                    System.out.println(item.stripLeading().stripTrailing());
                }
            }
    }
    public void clear(){
        this.shoppingList.clear(); //Removes all items from the shopping list.
    }
    public String getName(){ //Returns the name of the shopping list.
        return this.name;
    }
    public ShoppingList combine(ShoppingList otherList){ //Returns a new ShoppingList that contains the combined items from the current list and otherList.
        /* Method Information extended: 
        This method does not modify the current list. The resulting list contains items from the current
        list first, followed by items from otherList that are not duplicates. The name of the new list
        is formed by combining the names of the two lists, separated by an underscore. For example,
        combining List1 with List2 produces a new list named List1_List2.*/
        String combinedName = this.getName().trim()+"_"+otherList.getName().trim(); //combines names of 2 list
        ShoppingList combinedList = new ShoppingList(combinedName); //creates new empty list
        
        for(String item : this.shoppingList){ //add item from first list to combined list
            combinedList.addItem(item);
        }

        for(String item : otherList.shoppingList){ //add item from second list to combined list
            if(!combinedList.hasItem(item)){
                combinedList.addItem(item);
            }
        }
        return combinedList;
    }
    
}
