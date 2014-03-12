package fr.univsavoie.serveurbeta.generationvm.engine.libzypp;

import java.util.ArrayList;

/**
 * Classe d'interface pour appeler les fonctions de libzypp (en c++)
 *
 * Created by patrick-edouard on 2/14/14.
 */
public class PackageManagerInterface {

    private PackageManager packageManager;

    public PackageManagerInterface(){
        this.packageManager = ZypperImplementation.getInstance();
    }

    public ArrayList<String> getProposedPackagesName(String packageName){
        ArrayList<String> proposedPackagesName = new ArrayList<String>();
        for(Package p : this.packageManager.searchPackages(packageName,"")){
            proposedPackagesName.add(p.getName());
        }
        return proposedPackagesName;
    }
}
