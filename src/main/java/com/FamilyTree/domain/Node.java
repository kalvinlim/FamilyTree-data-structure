package com.FamilyTree.domain;

import java.util.List;

public interface Node {
	public List<Node> getChildren();
	public Node getRoot();
	public Node getParent();
	public String getName();
}
