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
		
		nancy.children([adam, jill, carl])
		jill.children([kevin])
		carl.children([catherine, joseph])
		
		kevin.children([samuel, george, james, aaron])
		george.children([patrick, rober])
		james.child(mary)
								
		tree = new FamilyTree(nancy)
	}
	
	@Before
	public void setUp() throws Exception {
		generateTree()
	}


	@Test
	public void testGetRoot(){
		[nancy, adam, jill, carl, kevin, catherine, joseph, samuel, george, james, aaron, patrick, robert, mary]
		.each{ person ->			
			assert person.getRoot() == nancy
		}
	}
	@Test
	public void testGetChildren(){
		assert patrick.getChildren() == null
		assert nancy.getChildren().containsAll(adam, jill, carl)
		assert kevin.getChildren().containsAll(samuel, george, james, aaron)
		assert carl.getChildren().containsAll(catherine, joseph)
		assert george.getChildren().containsAll(patrick, robert)
	}
	@Test
	public void testGetParent(){
		assert nancy.getParent() == null
		assert adam.getParent() == nancy
		assert james.getParent() == kevin
	}
	@Test
	public void testGetGrandParent(){
		assert nancy.getGrandParent() == null
		assert adam.getGrandParent() == null
		assert kevin.getGrandParent() == nancy
		assert george.getGrandParent() == jill
		assert patrick.getGrandParent() == kevin 
	}
	@Test
	public void testGetName(){
		assert nancy.getName() == "Nancy"
		assert mary.getName() == "Mary"
	}
}
