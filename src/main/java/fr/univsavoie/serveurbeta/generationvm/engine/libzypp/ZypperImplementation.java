package fr.univsavoie.serveurbeta.generationvm.engine.libzypp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by patrick-edouard on 2/19/14.
 */
public class ZypperImplementation extends PackageManager{

    private static PackageManager instance;

    private ZypperImplementation(){

    }

    public static PackageManager getInstance(){
        if(instance == null){
            instance = new ZypperImplementation();
        }
        return instance;
    }

    @Override
    public ArrayList<Package> searchPackages(String packageName) {
        ArrayList<Package> packages = new ArrayList<Package>();

        try{
            Scanner sc = callZypper(packageName);
            while(sc.hasNext()){
                String line = sc.nextLine();
                if(line.startsWith("  ")||line.startsWith("i ")){
                    packages.add(this.parseLineToPackage(line));
                }
            }
        }catch(RuntimeException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return packages;
    }

    private Package parseLineToPackage(String line){
        String[] lines = line.split("\\|");
        System.out.println(lines[1]);
        boolean isInstalled= false;
        if(line.startsWith("i "))isInstalled=true;
        return new Package(lines[1],lines[2],isInstalled);
    }

    private Scanner callZypper(String packageName) throws IOException {
        Process zypper = Runtime.getRuntime().exec("zypper se -t package " + packageName);
        //Process zypper = Runtime.getRuntime().exec("zypper se "+packageName+" -t package -r "+repoName);
        InputStream is = zypper.getInputStream();
        return new Scanner (is);
    }
}
