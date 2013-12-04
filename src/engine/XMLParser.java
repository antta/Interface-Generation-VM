package engine;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class XMLParser
 *
 * V0.0.0.1 pre alpha
 *
 * Just a prototype to modify an existing xml file
 * addPackage will be remove or reimplemented, indeed most of function are likely hard coded
 *
 * @author Patrick-Edouard Roux
 */
public class XMLParser {

    private static String xmlPath = "config.xml";
    private Element root;

    /**
     * XMLParser
     *
     * Constructor
     */
	public XMLParser() {
        this.open();
	}

    /**
     * save
     *
     * Save the current xml file
     */
    public void save(){
        try
        {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(this.root, new FileOutputStream(XMLParser.xmlPath));
        }
        catch (java.io.IOException e){}
    }

    public void createNew(){

    }

    /**
     * addPackage
     *
     * Add the given package
     */
    public void addPackage(String packageName){
        Attribute newPackage = new Attribute("name", packageName);
        Element packages = this.root.getChild("packages");
        if(packages != null)
        {
            packages.addContent(new Element("package").setAttribute(newPackage));
            this.save();
        }
    }

    /**
     * open
     *
     * Open the config.xml file that contain the kiwi configuration you want to edit
     */
    public void open(){
        SAXBuilder sxb = new SAXBuilder();
        try {
            this.root = sxb.build(new File(XMLParser.xmlPath)).getRootElement();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
