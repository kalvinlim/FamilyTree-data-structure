package com.FamilyTree.init;

import java.util.List;
import java.util.Scanner;

import com.FamilyTree.domain.FamilyTree;
import com.FamilyTree.domain.Node;

public class Application {

	public static void main(String[] args) {
		boolean running = true;
		FamilyTree tree = FamilyTree.generateDefaultTree();
		Scanner in = new Scanner(System.in);
		while(running){
			String choice;
			
			System.out.println("Family Tree Console \n");
			
			System.out.println("Please select a command #: ");
			System.out.println("(1) Input grand child and return grand parent");
			System.out.println("(2) Print names with no siblings");
			System.out.println("(3) Print names with no children");
			System.out.println("(4) Print the name of the person with the largest # of grand children");
			System.out.println("(5) Draw Family Tree"); 
			System.out.println("(0) Exit \n");
			
			
			choice = in.nextLine();
			if(choice == "0"){
				running = false;
			}
			
			switch(choice){
				case "0": 
						running = false;
						break;
				case "1":
						System.out.print("Please enter the name of the grand child: ");
						String grandChild = in.nextLine();
						Node result = tree.getGrandParentNodeByGrandChildName(grandChild);
						System.out.println(result == null ? "Result does not exist in tree \n" 
								:  "The grandparent of " + grandChild  + " is " + result.getName() + "\n");
						break;
				case "2":
						System.out.print("The following people have no siblings: ");
						List<Node> noSib = tree.getNodesWithNoSiblings();
						for(Node person : noSib){
							System.out.print(person.getName() + ", ");
						}
						System.out.println("\n");
						break;
				case "3":
						System.out.print("The following people have no children: ");
						List<Node> noChildren = tree.getNodesWithNoChildren();
						String noChildrenResult = "";
						for(Node person : noChildren){
							System.out.print(person.getName() + ", ");
						}												
						System.out.println(noChildrenResult + "\n");
						break;
				case "4":
						System.out.print("The following person has the greatest # of grand children: ");
						Node mostGrandChildren = tree.getNodeWithMostGrandChildren();
						System.out.println(mostGrandChildren == null ? "Not found" :  mostGrandChildren.getName()+"\n");
						break;
				case "5":
						break;
				default:
						break;
			}

		        
		}
		System.out.println("Program terminated");  
		in.close();
		
	}



}