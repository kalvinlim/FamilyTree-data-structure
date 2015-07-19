package com.FamilyTree.domain;

import java.util.ArrayList;
import java.util.List;

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
		return result.size() > 0 ? result.get(0)  : null;
	}
	@Override
	public List<Node> getNodesWithNoSiblings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> getNodesWithNoChildren() {
		List<Node> result = new ArrayList<>();
		
		return searchNodesWithNoChildren(root, result);
	}
	private List<Node> searchNodesWithNoChildren(Node currentNode, List<Node> result){
		if(currentNode.getChildren().size() == 0){
			result.add(currentNode);
		}
		for(Node child : currentNode.getChildren()){	
			searchNodesWithNoChildren(child, result);
		}
		return result;
	}

	@Override
	public Node getNodeWithMostGrandChildren() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "FamilyTree [root=" + root + "]";
	}

}
