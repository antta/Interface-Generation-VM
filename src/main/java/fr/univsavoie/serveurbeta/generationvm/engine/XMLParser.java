package  fr.univsavoie.serveurbeta.generationvm.engine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



/**
 * Design to be use with XMLModel, using it as a factory
 *
 */
public final class XMLParser {

	private static String xmlPath = "config.xml";
	private XMLModel xmlModel;
	private Element root;
	private static Logger logger = Logger.getLogger(XMLParser.class);

	/**
	 * Private constructor used by the factories to create new XMLParser
	 */
	private XMLParser() {
		this.xmlModel = new XMLModel();
	}
	
	/**
	 * Create an XML model using a template
	 * 
	 * @param template
	 */
	private XMLParser(int template) {
		this.xmlModel = new XMLModel(template);
	}

	/**
	 * @return the xmlModel
	 */
	public XMLModel getXmlModel() {
		return xmlModel;
	}

	/**
	 * @param xmlModel the xmlModel to set
	 */
	public void setXmlModel(XMLModel xmlModel) {
		this.xmlModel = xmlModel;
	}

	/**
	 * @return the root
	 */
	public Element getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Element root) {
		this.root = root;
	}

	/**
	 * A factory that create a new empty XML configuration.
	 *
	 * @return A new instance of XMLParser
	 */
	public static XMLParser createEmptyConfig(){
		return new XMLParser();
	}

	/**
	 * Create a configuration following the given template
	 * 
	 * @param template <ul>
	 * 					<li><b>1</b> JustEnough</li> 
	 * 					<li><b>2</b> Gnome</li>
	 * 				   </ul>
	 * @return A new instance of XMLParser corresponding to the template
	 */
	public static XMLParser createConfig(int template){
		return new XMLParser(template);
	}

    /**
     * Create a configuration following the given template
     *
     * @param file path to an xml config
     * @return A new instance of XMLParser corresponding to the template
     */
    public static XMLParser createConfig(String file){

        XMLParser instance = new XMLParser();

        XMLParser.xmlPath=file;

        instance.open();

        return instance;
    }

	/**
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
		catch (IOException e){
			logger.error("IOException" + e.toString());
		}
	}

	/**
	 * Open the config.xml file that contain the kiwi configuration you want to edit
	 */
	public void open(){
		SAXBuilder sxb = new SAXBuilder();
		try {
			this.root = sxb.build(new File(XMLParser.xmlPath)).getRootElement();
		} catch (JDOMException e) {
			logger.error("JDOMException " + e.toString());
		} catch (IOException e) {
			logger.error("IOException " + e.toString());
		}
	}

	public static void main(String[] args){
		XMLParser parser = XMLParser.createEmptyConfig();
		parser.save();
	}
}
