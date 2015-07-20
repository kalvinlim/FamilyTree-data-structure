package com.FamilyTree.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Models a family tree containing collection of {@link PersonNode}
 * and acts as entry point for any tree search operations
 * @author Kalvin
 *
 */
public class FamilyTree implements Tree {
	private final Node root;
	
	public FamilyTree(Node root){
		this.root = root;
	}
	@Override
	public Node getRoot() {
		return root; 
	}
	@Override
	public Node getNodeByName(String name) {		
		return searchByName(root, name, new ArrayList<>());		
	}
	private Node searchByName(Node currentNode, String nodeName, List<Node> result){
		if(currentNode.getName().equals(nodeName)){		
			result.add(currentNode);			
		}		
		for(Node child : currentNode.getChildren()){	 
			searchByName(child, nodeName, result);					
		}				
		return !result.isEmpty() ? result.get(0)  : null;
	}
	
	@Override
	public Node getGrandParentNodeByGrandChildName(String name) {
		Node result = searchByName(root, name, new ArrayList<>());
		return result == null ? null : result.getGrandParent();
	}
	@Override
	public List<Node> getNodesWithNoSiblings() {
		return searchNodesWithNoSiblings(root, new ArrayList<Node>());
	}
	private List<Node> searchNodesWithNoSiblings(Node currentNode, List<Node> result){		
		if(currentNode == currentNode.getRoot()){
			result.add(currentNode);
		}
		Node parent = currentNode.getParent();
		if(parent != null && parent.getChildren().size() == 1){
			result.add(currentNode);
		}
		for(Node child : currentNode.getChildren()){	
			searchNodesWithNoSiblings(child, result);
		}
		return result;
	}

	@Override
	public List<Node> getNodesWithNoChildren() {
		List<Node> result = new ArrayList<>();
		
		return searchNodesWithNoChildren(root, result);
	}
	private List<Node> searchNodesWithNoChildren(Node currentNode, List<Node> result){
		if(currentNode.getChildren().isEmpty()){
			result.add(currentNode);
		}
		for(Node child : currentNode.getChildren()){	
			searchNodesWithNoChildren(child, result);
		}
		return result;
	}

	@Override
	public Node getNodeWithMostGrandChildren() {		
		SortedMap<Integer, Node> result = new TreeMap<>();
		return searchNodeWithMostGrandChildren(root, result);
	}
	
	private Node searchNodeWithMostGrandChildren(Node currentNode, SortedMap<Integer, Node> result){

		//System.out.println(currentNode);
		
		if(!currentNode.getChildren().isEmpty()){
			int counter = 0;
			for(Node child : currentNode.getChildren()){				
				counter += child.getChildren().size();
			}
		
			//System.out.println(currentNode + " has " + counter);
			if(counter > 0){
				result.put(counter, currentNode);
			}
		}
		
		for(Node child : currentNode.getChildren()){	
			searchNodeWithMostGrandChildren(child, result);
		}
		//System.out.println(result.get(result.lastKey()));
		return result.get(result.lastKey());		
	}
	
	
	@Override
	public String toString() {
		return "FamilyTree [root=" + root + "]";
	}

	/**
	 * Generate default tree
	 * @return "pre-built" family tree for immediate use
	 */
	public static FamilyTree generateDefaultTree(){
		PersonNode nancy, adam, jill, carl, kevin, catherine, joseph, samuel, george, james, aaron, patrick, robert, mary;
		
		nancy = new PersonNode("Nancy");
		adam = new PersonNode("Adam");
		jill = new PersonNode("Jill");
		carl = new PersonNode("Carl");
		kevin = new PersonNode("Kevin");
		catherine = new PersonNode("Catherine");
		joseph = new PersonNode("Joseph");
		samuel = new PersonNode("Samuel");
		george = new PersonNode("George");
		james = new PersonNode("James");
		aaron = new PersonNode("Aaron");
		patrick = new PersonNode("Patrick");
		robert = new PersonNode("Robert");
		mary = new PersonNode("Mary");

		nancy.addChildren(Arrays.asList(adam, jill, carl));
		jill.addChildren(Arrays.asList(kevin));
		carl.addChildren(Arrays.asList(catherine, joseph));
		
		kevin.addChildren(Arrays.asList(samuel, george, james, aaron));
		george.addChildren(Arrays.asList(patrick, robert));
		james.addChild(mary);
		
		List<Node> allNodes = Arrays.asList(nancy, adam, jill, carl, kevin, catherine, joseph, samuel, george, james, aaron, patrick, robert, mary);

		for(Node node : allNodes){
			node.setRoot(nancy);
		}		
		
		return new FamilyTree(nancy);
	}

}
