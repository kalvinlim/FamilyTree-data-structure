package com.FamilyTree.domain

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

public class FamilyTreeTest {
	Tree tree
	PersonNode nancy, adam, jill, carl, kevin, catherine, joseph, samuel, george, james, aaron, patrick, robert, mary
		
	def generateTree(){		
		nancy = new PersonNode("Nancy")
		adam = new PersonNode("Adam")
		jill = new PersonNode("Jill")
		carl = new PersonNode("Carl")
		kevin = new PersonNode("Kevin")
		catherine = new PersonNode("Catherine")
		joseph = new PersonNode("Joseph")
		samuel = new PersonNode("Samuel")
		george = new PersonNode("George")
		james = new PersonNode("James")
		aaron = new PersonNode("Aaron")
		patrick = new PersonNode("Patrick")
		robert = new PersonNode("Robert")
		mary = new PersonNode("Mary")
		
		nancy.addChildren([adam, jill, carl])
		jill.addChildren([kevin])
		carl.addChildren([catherine, joseph])
		
		kevin.addChildren([samuel, george, james, aaron])
		george.addChildren([patrick, robert])
		james.addChild(mary)
								
		tree = new FamilyTree(nancy)
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		generateTree()		
	}

	@Test
	public void testGetNodeByName(){
		assert tree.getNodeByName("Not in tree") == null
		assert tree.getNodeByName("Nancy") == nancy
		assert tree.getNodeByName("Adam") == adam
		assert tree.getNodeByName("Jill") == jill
		assert tree.getNodeByName("Carl") == carl			
		assert tree.getNodeByName("Kevin") == kevin
		assert tree.getNodeByName("Catherine") == catherine
		assert tree.getNodeByName("Joseph") == joseph
		assert tree.getNodeByName("Samuel") == samuel
		assert tree.getNodeByName("George") == george
		assert tree.getNodeByName("James") == james
		assert tree.getNodeByName("Aaron") == aaron
		assert tree.getNodeByName("Patrick") == patrick
		assert tree.getNodeByName("Robert") == robert
		assert tree.getNodeByName("Mary") == mary		
	}

	@Test
	public void testGetNodesWithNoSiblings(){
		def nodesWithNoSiblings = tree.getNodesWithNoSiblings()
		assert nodesWithNoSiblings.size() == 3
		assert nodesWithNoSiblings.containsAll([nancy, kevin, mary])		
	}
	@Test
	public void testGetNodesWithNoChildren(){
		def nodesWithNoChildren = tree.getNodesWithNoChildren()
		assert nodesWithNoChildren.size == 8
		assert nodesWithNoChildren.containsAll(patrick, robert, mary, samuel, aaron, adam, catherine, joseph);
	}
	@Test
	public void testGetNodeWithMostGrandChildren(){
		assert tree.getNodeWithMostGrandChildren() == jill
	}
		
	@Test
	public void testGetRoot(){
		assert tree.getRoot() == nancy
	}
	
	@Test
	public void testDrawFamilyTree(){
		
	}
}
