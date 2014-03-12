package fr.univsavoie.serveurbeta.generationvm.engine.libzypp;

import java.util.ArrayList;

/**
 * Class PackageManager
 *
 * The header for package manager classes such as Zypper or Libzypp implementation
 *
 * Created by patrick-edouard on 2/19/14.
 */
public abstract class PackageManager {
    /**
     *
     * @param packageName
     * @return Packages
     */
    public abstract ArrayList<Package> searchPackages(String packageName, String rootDirectory);
    public abstract String searchPackageCSV(String packageName, String rootDirectory);
}
