package com.FamilyTree.init

import static org.junit.Assert.*

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

import com.FamilyTree.domain.FamilyTree
import com.FamilyTree.domain.PersonNode

public class ApplicationTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testGetGrandParentFromGrandChild() {	
		Application app = new Application();
		InputStream old = System.in;
		
		try {													
			System.setIn( new ByteArrayInputStream( "1\nFoo\n1\nKevin\n0".getBytes("UTF-8")  ))

			
			Application.main();
						
			assert outContent.toString().contains("Result does not exist in tree")				
			assert outContent.toString().contains("The grandparent of Kevin is Nancy")
			assert outContent.toString().contains("Program terminated")
			
		} finally {
			System.setIn( old );
		}		
	
	}
	
	@Test
	public void testGetNamesWithNoSiblings() {
		Application app = new Application();
		InputStream old = System.in;
	
		try {
			System.setIn( new ByteArrayInputStream( "2\n0".getBytes("UTF-8")  ))

			Application.main();
								
			assert outContent.toString().contains("The following people have no siblings: Nancy, Kevin, Mary")
			assert outContent.toString().contains("Program terminated")
			
		} finally {
			System.setIn( old );
		}
	
	}
	
	@Test
	public void testGetNamesWithNoChildren() {
		Application app = new Application();
		InputStream old = System.in;
	
		try {
			System.setIn( new ByteArrayInputStream( "3\n0".getBytes("UTF-8")  ))

			Application.main();
								
			assert outContent.toString().contains("The following people have no children: Adam, Samuel, Patrick, Robert, Mary, Aaron, Catherine, Joseph")
			assert outContent.toString().contains("Program terminated")
			
		} finally {
			System.setIn( old );
		}
	
	}
	
	//@Test
	public void test3() {
		InputStream old = System.in;
	
		try {
			System.setIn( new ByteArrayInputStream( "\na\n0".getBytes("UTF-8")  ))
			Application.main();
		} finally {
			System.setIn( old );
		}
	
	}
	@Test
	public void testPrintLargestNumberOfGrandChildren() {
		InputStream old = System.in;
	
		try {										
			System.setIn( new ByteArrayInputStream( "4\n0".getBytes("UTF-8")  ))			
			Application.main();

			
			assert outContent.toString().contains("The following person has the greatest # of grand children: Jill")
			assert outContent.toString().contains("Program terminated")
		} finally {
			System.setIn( old );
		}		

	}
	@Test
	public void testPrintLargestNumberOfGrandChildrenNotFound() {
		PersonNode root = new PersonNode("root")
		FamilyTree tree = new FamilyTree(root)
		
		InputStream old = System.in;
	
		try {
			System.setIn( new ByteArrayInputStream( "4\n0".getBytes("UTF-8")  ))
			Application.init(tree);
			
			assert outContent.toString().contains("The following person has the greatest # of grand children: Not found")
			assert outContent.toString().contains("Program terminated")
		} finally {
			System.setIn( old );
		}

	}
	@Test
	public void testDrawFamilyTree() {
		InputStream old = System.in;
	
		try {
			System.setIn( new ByteArrayInputStream( "5\n0".getBytes("UTF-8")  ))
			Application.main();
		} finally {
			System.setIn( old );
		}

	}
}
