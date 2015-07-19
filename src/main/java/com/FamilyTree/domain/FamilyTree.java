package com.FamilyTree.domain;

import java.util.List;

public class FamilyTree implements Tree {
	private final Node root;
	
	public FamilyTree(Node root){
		this.root = root;
	}
	@Override
	public Node getRoot() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Node getNodeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> getNodesWithNoSiblings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> getNodesWithNoChildren() {
		// TODO Auto-generated method stub
		return null;
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
