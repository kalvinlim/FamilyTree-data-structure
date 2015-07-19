package com.FamilyTree.domain;

import java.util.List;

public interface Tree {
	public Node getRoot();
	public Node getNodeByName(String name);
	public List<Node> getNodesWithNoSiblings();
	public List<Node> getNodesWithNoChildren();
	public Node getNodeWithMostGrandChildren();
}
