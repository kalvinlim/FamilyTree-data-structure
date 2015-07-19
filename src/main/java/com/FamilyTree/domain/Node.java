package com.FamilyTree.domain;

import java.util.List;

public interface Node {
	public Node getRoot();
	public List<Node> getChildren();
	public void setChild(Node child);
	public void setChildren(List<Node> children);
	public Node getParent();
	public Node getGrandParent();
	public String getName();
}
