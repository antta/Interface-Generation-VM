package fr.univsavoie.serveurbeta.generationvm.view.prototype;

import fr.univsavoie.serveurbeta.generationvm.engine.XMLParser;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: patrick-edouard<br/>
 * Date: 12/18/13<br/>
 * Time: 10:59 AM<br/>
 * This class is designed to give an line code user interface.<br/>
 * The goal is to use the api via an ssh connection to a distant server.<br/>
 * Or to be use by jenkins in a line command 'java -jar LineMode [options][args]'<br/>
 */
public class LineMode {

	private XMLParser parser;

	private Scanner input;

    /**
     * Launch the interactive mode
     */
	public LineMode(){
		this.input = new Scanner(System.in);
		this.parser = XMLParser.createEmptyConfig();
		this.interact();
	}

    /**
     * Use command line mode
     * @param args args of the args of the <i>public static void main (String args[])</i> function
     */
	public LineMode(String [] args){
		this.parser = XMLParser.createEmptyConfig();
		this.treatArgs(args);
	}

    /**
     * interactive version
     */
	private void interact(){
		while(true){
			this.getCommand();
		}
	}

	public void displayOption(){
		System.out.print("Usage :" +
                "\n-h                                  		: Display this help" +
                "\n-b   --build                        		: Build the appliance, launching ./createAppliance" +
                "\n ==      template managing        == " +
                "\n-t   --template   jeos | gnome       	: Create a new configuration with predefined package. (jeos | gnome | (maybe others) ). Or a .xml file containing the default configuration" +
                "\n ==      package  managing        ==" +
                "\n--addpackage packageName [packageType] 	: Add the package to the configuration. You could specify the type of package. No checks are performed on the pertinence of your package name (may cause kiwi crash if bad name)." +
                "\n--addpackages listPackages       		: Add all the packages to the configuration. You could specify the type of package. No checks are performed on the pertinence of your package name (may cause kiwi crash if bad name)." +
                "\n--addrepository repoURL repoType 		: Add the package to the configuration. No checks are performed on the pertinence of your package name (may cause kiwi crash if bad name)." +
                "\n ==        vm    managing         ==" +
                "\n--setAuthor author                    	: Set the author name" +
                "\n--setContact contact                   	: Set your e-mail address" +
                "\n--setSpecification description         	: Describe your distribution" +
                "\n");
	}

    /**
     * Get the command line from the user
     */
	public final void getCommand() {
		String command = this.input.nextLine();
		treatCommand(command);
	}

    /**
     * Add packages to the config.xml file
     * @param command <i>--addpackages package1name,package2name,package3name,...</i>
     */
	private void addPackages(String command){
		String[] listPackages = (command.substring("--addpackages ".length())).split(",");
		for (String packages : listPackages){
			this.addPackage("--addpackage "+packages);
		}
	}

    /**
     * Add a package to the config.xml file
     * @param command <i>--addpackage packagename</i>
     */
	private void addPackage(String command){
		String packageName = command.substring("--addpackage ".length());
		if(packageName.split(" ").length>1){
			this.parser.getXmlModel().addPackage(packageName.split(" ")[0],packageName.split(" ")[1]);
		}else{
			this.parser.getXmlModel().addPackage(command.substring("--addpackage ".length()));
		}
	}

    /**
     * Add a repository to the config.xml file
     * @param command <i>--addrepository alias url</i>
     */
	private void addRepository(String command){
		String repositoryArgs = command.substring("--addrepository ".length());
		if(repositoryArgs.split(" ").length >= 2)
		    this.parser.getXmlModel().addRepository(repositoryArgs.split(" ")[0], repositoryArgs.split(" ")[1]);
		else {
            displayOption();
            System.exit(1);
        }
	}

    /**
     * Treat the given command line
     * @param command a command line like --command parameter
     */
	public final void treatCommand(String command){
		if(command.startsWith("exit")){
			this.parser.save();
			System.exit(0);
		}else if(command.startsWith("--addpackages")){
			this.addPackages(command);
		}else if(command.startsWith("--addpackage")){
			this.addPackage(command);
		}else if(command.startsWith("--addrepository")){
			this.addRepository(command);
		}else if(command.startsWith("--setAuthor")){
			this.parser.getXmlModel().setAuthor(command.substring("--setAuthor ".length()));
		}else if(command.startsWith("--setContact")){
			this.parser.getXmlModel().setAuthorMail(command.substring("--setContact ".length()));
		}else if(command.startsWith("--setSpecification")){
			this.parser.getXmlModel().setSpecification(command.substring("--setSpecification ".length()));
		}
		else if(command.startsWith("-t") || command.startsWith(("--template"))){
            String extension = ".xml";
            if(command.substring(command.length()-extension.length()).equals(extension)){
                String file = command.split(" ")[1];
                this.parser = XMLParser.createConfig(file);
                return;
            }
			String tempName = command.split(" ")[1];
			int template = 0;
			if(tempName.equals("jeos")){
				template = 1;
			}
			else if (tempName.equals("gnome")){
				template = 2;
			}
			this.parser = XMLParser.createConfig(template);
		}
		else{
			this.displayOption();
            System.exit(1);
		}
	}

    /**
     * Take each argument send each command (--addPackageForExample) to the function that treat it
     * @param args args of the <i>public static void main (String args[])</i> function
     */
	public void treatArgs(String [] args){
		//--template jeos --addpackages test,test2,test3 bootstrap --setAuthor someone
		String command = "";
		for (int i = 0; i < args.length; i++) {
			if(args[i].startsWith("--")){
				command = args[i];
				while(++i<args.length && !(args[i].startsWith("--") || args[i].startsWith("-"))){
					command += " " + args[i];
				}
				i--;
				treatCommand(command);
			}
		}
		treatCommand("exit");	
	}
	
	/**
	 * Get the parser of parser of this view, using it for testing
     *
	 * @return the XML parser
	 */
	public XMLParser getParser() {
		return parser;
	}

	public static void main (String[] args){
		if (args.length > 0){
			new LineMode(args);
		}
		else{
			new LineMode();
		}
	}
}
