package fr.univsavoie.serveurbeta.generationvm.view.prototype;

import fr.univsavoie.serveurbeta.generationvm.engine.XMLParser;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: patrick-edouard
 * Date: 12/18/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 *
 * This class is design to give an line code user interface.
 * The goal is to use the api via an ssh connection to a distant server.
 * Or to be use by jenkins in a line command 'java -jar LineMode [options][args]'
 */
public class LineMode {

	private XMLParser parser;

	private Scanner input;

	public LineMode(){
		this.input = new Scanner(System.in);
		this.parser = XMLParser.createEmptyConfig();
		this.interact();
	}

	public LineMode(String [] args){
		this.parser = XMLParser.createEmptyConfig();
		this.treatArgs(args);
	}

	private void interact(){
		while(true){
			this.getCommand();
		}
	}

	public void displatOption(){
		System.out.print("Usage :" +
				"\n-h                                  		: Display this help" +
				"\n-b   --build                        		: Build the appliance, launching ./createAppliance" +
				"\n ==      template managing        == " +
				"\n-t   --template   jeos | gnome       	: Create a new configuration with predefined package. (jeos | gnome | (maybe others) )" +
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

	public final void getCommand() {
		String command = this.input.nextLine();
		treatCommand(command);
	}

	private void addPackages(String command){
		String[] listPackages = (command.substring("--addpackages ".length())).split(",");
		for (String packages : listPackages){
			this.addPackage("--addpackage "+packages);
		}
	}

	private void addPackage(String command){
		String packageName = command.substring("--addpackage ".length());
		if(packageName.split(" ").length>1){
			this.parser.getXmlModel().addPackage(packageName.split(" ")[0],packageName.split(" ")[1]);
		}else{
			this.parser.getXmlModel().addPackage(command.substring("--addpackage ".length()));
		}
	}
	
	private void addRepository(String command){
		String repositoryArgs = command.substring("--addrepository ".length());
		
		this.parser.getXmlModel().addRepository(repositoryArgs.split(" ")[0], repositoryArgs.split(" ")[1]);
		
	}

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
			this.displatOption();
		}
	}

	public void treatArgs(String [] args){
		//--template jeos --addpackage test --addpackage test2 --addpackage test3 bootstrap --setAuthor moi
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
	 * @return
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
