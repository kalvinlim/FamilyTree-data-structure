package com.FamilyTree.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonNode implements Node {
	private final String name;
	private Node root;
	private List<Node> children = new ArrayList<>();
	private Node parent;	
	
	public PersonNode(String name){
		this.name = name; 
	}

	@Override
	public Node getRoot() {
		return root;
	}

	@Override
	public void setRoot(Node root) {
		this.root = root;
	}

	@Override
	public List<Node> getChildren() {
		return children;
	}

	@Override
	public void addChild(Node child) {
		this.children.add(child);
		child.setParent(this);
	}

	@Override
	public void addChildren(List<Node> children) {
		this.children.addAll(children);
		for(Node child : children){
			child.setParent(this);
		}
	}

	@Override
	public Node getParent() {
		return parent;
	}
	@Override
	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public Node getGrandParent() {
		return parent != null ? parent.getParent() : null;
	}

	@Override
	public String getName() {
		return name;
	}

}
