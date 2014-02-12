package fr.univsavoie.serveurbeta.generationvm.engine;

import static org.junit.Assert.assertEquals;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.junit.Test;

public class XMLModelTest {
	XMLModel model;
	Element root;
		
	public XMLModelTest(){
		model = XMLParser.createEmptyConfig().getXmlModel();
		root = model.fileRepresentationRoot();
	}
	
	@Test
	public void testSetAuthor() {
		
		String testAuthor = "Cyril";
		
		model.setAuthor(testAuthor);
		
		assertEquals(testAuthor, root.getChild("description").getChild("author").getText());
		
		assertEquals(false, root.getChild("description").getChild("author").equals("BadAuthor"));
	
	}
	
	@Test
	public void testSetAuthorMail(){
		
		String testAuthorMail = "cyril.laignel@etu.univ-savoie.fr";
		
		model.setAuthorMail(testAuthorMail);
		
		assertEquals(testAuthorMail, root.getChild("description").getChild("contact").getText());
		
		assertEquals(false, root.getChild("description").getChild("contact").equals("BadAuthorMail"));
		
	}
	
	@Test
	public void testSetSpecification(){
		String testSpecification = "Tiny with kiwi,Jenkins";
		
		model.setSpecification(testSpecification);
		
		assertEquals(testSpecification, root.getChild("description").getChild("specification").getText());
		
		assertEquals(false, root.getChild("description").getChild("specification").equals("BadSpecification"));
				
	}
	
	@Test
	public void testAddPackage(){
		String testPackageName = "jenkins";
		String defaultPackageType = "image";
		boolean match = false;
		
		model.addPackage(testPackageName);
		
		for(Element elt : root.getChildren("packages")){
			for(Attribute a : elt.getAttributes()){
				if(a.getValue().equals(defaultPackageType)){
					for(Element e : elt.getChildren("package")){
						if(e.getAttribute("name").getValue().equals(testPackageName)){
							match = true;
						}
					}
				}
			}
		}
		assertEquals(match, true);
	}
/*
	public void testAddUser(){
		String testPackageName = "jenkins";
		String testGroupType = "perso";
		Collection<Attribute> testUserAttributes = new Collection<Attribute>();
		
		model.addUser(testPackageName, testGroupType, testUserAttributes);
	}
*/
}
