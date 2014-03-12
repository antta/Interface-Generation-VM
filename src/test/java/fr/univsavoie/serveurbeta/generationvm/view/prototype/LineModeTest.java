package fr.univsavoie.serveurbeta.generationvm.view.prototype;

import static org.junit.Assert.assertEquals;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.junit.Test;

public class LineModeTest {
	
	public LineModeTest(){
		
	}
	/*
	@Test
	public void testTreatCommandAddRepository() {
		
		String repoURL = "http://repositoryDeTest.com/repo";
		String repoType = "rpm-md";
		
		String[] commandeTest = {"--addrepository",repoURL,repoType};
		
		LineMode lineMode = new LineMode(commandeTest);
		
		Element root = lineMode.getParser().getXmlModel().fileRepresentationRoot();
		
		boolean match = false;
		
		for(Element elt : root.getChildren("repository")){
			for(Attribute a : elt.getAttributes()){
				if(a.getValue().equals(repoType)){
					for(Element e : elt.getChildren("source")){
						if(e.getAttribute("path").getValue().equals(repoURL)){
							match = true;
						}
					}
				}
			}
		}
		assertEquals(match, true);
	}
	/*
	@Test
	public void testTreatCommandAddSinglePackage() {
		//assert false;
		String testPackageName = "jenkins";
		String defaultPackageType = "image";
		
		String[] commandeTest = {"--addpackage",testPackageName};
		
		LineMode lineMode = new LineMode(commandeTest);
		Element root = lineMode.getParser().getXmlModel().fileRepresentationRoot();
		
		
		boolean match = false;
		
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
	*/
}
