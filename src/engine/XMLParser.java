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
 * V0.0.0.2 pre alpha
 *
 * Just a prototype to modify an existing xml file
 * addPackage will be remove or reimplemented, indeed most of function are likely hard coded
 *
 *
 * @author Patrick-Edouard Roux
 */
public class XMLParser {

    private static String xmlPath = "config.xml";
    public XMLModel xmlModel;
    private Element root;

    /**
     * XMLParser
     *
     * Private constructor used by the factories to create new XMLParser
     */
	private XMLParser() {
        //this.open();
        this.xmlModel = new XMLModel();
	}

    /**
     * createEmptyConfig
     *
     * A factory that create a new empty XML configuration.
     *
     *
     * @return A new instance of XMLParser
     */
    public static XMLParser createEmptyConfig(){
        return new XMLParser();
    }

    /**
     * save
     *
     * Save the current configuration into the concrete xml file.
     */
    public void save(){
        try
        {
        	File file = new File(XMLParser.xmlPath);
        	if(!file.exists()){
        		file.createNewFile();
        	}
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(this.xmlModel.fileRepresentationRoot(), new FileOutputStream(XMLParser.xmlPath));
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void createNew(){
        this.xmlModel = new XMLModel();
    }

    /**
     * addPackage
     *
     * Add the given package
     */
    @Deprecated
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

    public static void main(String[] args){
        XMLParser parser = XMLParser.createEmptyConfig();
        parser.xmlModel.addPackage("Patrick-Edouard");
        parser.save();
    }
}
