package com.FamilyTree.domain;

import java.util.List;

public interface Node {
	public Node getRoot();
	public void setRoot(Node root);
	public List<Node> getChildren();
	public void addChild(Node child);
	public void addChildren(List<Node> children);
	public Node getParent();
	public void setParent(Node parent);
	public Node getGrandParent();
	public String getName();
}
