package com.FamilyTree.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.FamilyTree.init.ApplicationTest;

@RunWith(Suite.class)
@SuiteClasses({ FamilyTreeTest.class, PersonNodeTest.class, ApplicationTest.class })
public class AllTests {

}
