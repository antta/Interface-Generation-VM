package fr.univsavoie.serveurbeta.generationvm.engine;

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
		
		if(root.getChild("description").getChild("author").equals(testAuthor)){
			assert true;
		}
		else {
			assert false;
		}
		
		if(root.getChild("description").getChild("author").equals("BadAuthor")){
			assert false;
		}
		else {
			assert true;
		}
		
	}
	
	@Test
	public void testSetAuthorMail(){
		
		String testAuthorMail = "cyril.laignel@etu.univ-savoie.fr";
		
		model.setAuthorMail(testAuthorMail);
		
		if(root.getChild("description").getChild("contact").equals(testAuthorMail)){
			assert true;
		}
		else {
			assert false;
		}
		
		if(root.getChild("description").getChild("contact").equals("BadAuthorMail")){
			assert false;
		}
		else {
			assert true;
		}
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

}
