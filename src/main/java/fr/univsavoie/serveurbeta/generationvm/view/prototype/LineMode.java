package main.java.fr.univsavoie.serveurbeta.generationvm.view.prototype;

import main.java.fr.univsavoie.serveurbeta.generationvm.engine.XMLParser;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: patrick-edouard
 * Date: 12/18/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 *
 * This class is design to give an line code user interface.
 * The goal is to use the api via an ssh connexion to a distant server.
 */
public class LineMode {

    private XMLParser parser;
    private Scanner input;

    public LineMode(){
        this.input = new Scanner(System.in);
        this.parser = XMLParser.createEmptyConfig();
        this.interact();
    }

    private void interact(){
        while(true){
            this.treatCommand();
        }
    }

    public void displatOption(){
        System.out.println("Usage :" +
                "\n-h                                   : Display this help" +
                "\n-b   --build                         : Build the appliance, launching ./createAppliance" +
                "\n ==      package  managing        ==" +
                "\naddpackage packageName [packageType] : Add the package to the configuration. You could specify the type of package. No checks are performed on the pertinence of your package name (may cause kiwi crash if bad name)." +
                "\naddrepository repositoryName         : Add the package to the configuration. No checks are performed on the pertinence of your package name (may cause kiwi crash if bad name)." +
                "\n ==        vm    managing         ==" +
                "\nsetAuthor author                     : Set the author name" +
                "\nsetContact contact                   : Set your e-mail address" +
                "\nsetSpecification description         : Describe your distribution" +
                "");
    }

    public void treatCommand(){
        String command = this.input.nextLine();
        if(command.startsWith("exit")){
            System.exit(0);
        }else if(command.startsWith("addpackage")){
            String packageName = command.substring("addpackage ".length());
            if(packageName.split(" ").length>1){
                this.parser.xmlModel.addPackage(packageName.split(" ")[0],packageName.split(" ")[1]);
            }else{
                this.parser.xmlModel.addPackage(command.substring("addpackage ".length()));
            }
        }else if(command.startsWith("addrepository")){
            System.out.println("Not implemented yet");
        }else if(command.startsWith("setAuthor")){
            this.parser.xmlModel.setAuthor(command.substring("setAuthor ".length()));
        }else if(command.startsWith("setContact")){
            this.parser.xmlModel.setAuthorMail(command.substring("setContact ".length()));
        }else if(command.startsWith("setSpecification")){
            this.parser.xmlModel.setSpecification(command.substring("setSpecification ".length()));
        }

        else{
            this.displatOption();
        }
    }

    public static void main (String[] args){
        new LineMode();
    }
}
