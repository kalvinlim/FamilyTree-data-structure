package com.FamilyTree.domain

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

public class FamilyTreeTest {
	private FamilyTree tree;
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
		
		[nancy, adam, jill, carl, kevin, catherine, joseph, samuel, george, james, aaron, patrick, robert, mary]
		.each{ person ->
			person.setRoot(nancy)
		}
						
		tree = new FamilyTree(nancy)
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		tree = generateTree()
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
	public void testGetGrandParentByGrandChildName(){
		assert tree.getGrandParentNodeByGrandChildName("Not in tree") == null
		assert tree.getGrandParentNodeByGrandChildName("Nancy") == null
		assert tree.getGrandParentNodeByGrandChildName("Adam") == null
		assert tree.getGrandParentNodeByGrandChildName("Jill") == null
		assert tree.getGrandParentNodeByGrandChildName("Carl") == null
		
		assert tree.getGrandParentNodeByGrandChildName("Kevin") == nancy
		assert tree.getGrandParentNodeByGrandChildName("Catherine") == nancy
		assert tree.getGrandParentNodeByGrandChildName("Joseph") == nancy
		
		assert tree.getGrandParentNodeByGrandChildName("Samuel") == jill
		assert tree.getGrandParentNodeByGrandChildName("George") == jill
		assert tree.getGrandParentNodeByGrandChildName("James") == jill
		assert tree.getGrandParentNodeByGrandChildName("Aaron") == jill
		
		assert tree.getGrandParentNodeByGrandChildName("Patrick") == kevin
		assert tree.getGrandParentNodeByGrandChildName("Robert") == kevin
		assert tree.getGrandParentNodeByGrandChildName("Mary") == kevin
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
		tree = new FamilyTree(new PersonNode("root"))
		assert tree.getNodeWithMostGrandChildren() == null 
	}
		
	@Test
	public void testGetRoot(){		
		assert tree.getRoot() == nancy
		assert tree.getNodeByName("Patrick").getRoot() == nancy
	}
	
	@Test
	public void testDrawFamilyTree(){
		
	}
	
	@Test 
	public void testToString(){
		assert tree.toString() == "FamilyTree [root=PersonNode [name=Nancy]]"
	}
	
	@Test
	public void testGenerateDefaultTree(){
		FamilyTree defaultTree = FamilyTree.generateDefaultTree()	
		
		assert defaultTree.root.name == "Nancy"
		assert defaultTree.getNodeByName("Nancy").name == "Nancy"

		assert defaultTree.root.children.size() == 3
		defaultTree.root.children.each{ child ->
			assert child.name in ["Adam", "Jill", "Carl"]
		}
		
		assert defaultTree.getNodeByName("Carl").children.size() == 2
		defaultTree.getNodeByName("Carl").children.each{ child ->
			assert child.name in ["Catherine", "Joseph"]
		}
		
		assert defaultTree.getNodeByName("Jill").children.size() == 1
		defaultTree.getNodeByName("Jill").children.each{ child ->
			assert child.name in ["Kevin"]
		}
		
		assert defaultTree.getNodeByName("Kevin").children.size() == 4
		defaultTree.getNodeByName("Kevin").children.each{ child ->
			assert child.name in ["Samuel", "George", "James", "Aaron"]
		}
		
		assert defaultTree.getNodeByName("Catherine").children.size() == 0			
		assert defaultTree.getNodeByName("Joseph").children.size() == 0
		
		assert defaultTree.getNodeByName("Samuel").children.size() == 0		
		assert defaultTree.getNodeByName("George").children.size() == 2
		defaultTree.getNodeByName("George").children.each{ child ->
			assert child.name in ["Patrick", "Robert"]
		}
		
		assert defaultTree.getNodeByName("George").children.size() == 2
		defaultTree.getNodeByName("George").children.each{ child ->
			assert child.name in ["Patrick", "Robert"]
		}
		
		assert defaultTree.getNodeByName("James").children.size() == 1
		defaultTree.getNodeByName("James").children.each{ child ->
			assert child.name in ["Mary"]
		}
				
		assert defaultTree.getNodeByName("Aaron").children.size() == 0
		
		assert defaultTree.getNodeByName("Patrick").children.size() == 0
		assert defaultTree.getNodeByName("Robert").children.size() == 0
		assert defaultTree.getNodeByName("Mary").children.size() == 0
		
		["Nancy", "Adam", "Jill", "Carl", "Kevin", "Catherine", "Joseph", "Samuel", "George", "James", "Aaron", "Patrick", "Robert", "Mary"]
		.each{ person ->
			assert defaultTree.getNodeByName(person) != null
			assert defaultTree.getNodeByName(person).root.name == "Nancy"
		}
		
	}
}
