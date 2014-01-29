package fr.univsavoie.serveurbeta.generationvm.engine;

import static org.junit.Assert.assertEquals;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.junit.Test;

public class XMLModelTest {
	XMLModel model;
	Element root;
		
	public XMLModelTest(){
		model = XMLParser.createEmptyConfig().xmlModel;
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
		
		if(root.getChild("description").getChild("specification").equals(testSpecification)){
			assert true;
		}
		else {
			assert false;
		}
		
		if(root.getChild("description").getChild("specification").equals("BadSpecification")){
			assert true;
		}
		else {
			assert false;
		}
		
	}
	
	@Test
	public void testAddPackage(){
		String testPackageName = "jenkins";
		String testPackageType = "image";
		
		model.addPackage(testPackageName);
		
		assertEquals(testPackageType, root.getChild("packages").getAttribute("type").getValue());
		for(Element elt : root.getChildren()){
			for(Attribute a : elt.getAttributes()){
				if(a.getName().equals("type")){
					assertEquals(testPackageType, a.getValue());
				}
			}
			
			root.getChild("packages").getChild("package").getValue();
		}
		assertEquals(testPackageName, root.getChild("packages").getChild("package").getValue());
	}
}
