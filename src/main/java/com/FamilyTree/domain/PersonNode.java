package com.FamilyTree.domain;

import java.util.List;

public class PersonNode implements Node {
	private final String name;
	public PersonNode(String name){
		this.name = name;
	}
	@Override
	public List<Node> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "PersonNode [name=" + name + "]";
	}


}
