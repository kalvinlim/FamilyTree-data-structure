package com.FamilyTree.domain

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

public class PersonNodeTest {
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
		robert = new PersonNode("Patrick")
		mary = new PersonNode("Mary")
	
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
	}
	@Test
	public void testGetNodesWithNoSiblings(){
		tree.getNodesWithNoSiblings()
	}
	@Test
	public void testGetNodesWithNoChildren(){
		tree.getNodesWithNoChildren()
	}
	@Test
	public void testGetNodeWithMostGrandChildren(){
		tree.getNodeWithMostGrandChildren()
	}
	@Test
	public void testDrawFamilyTree(){
		
	}
}
