package fr.univsavoie.serveurbeta.generationvm.engine.libzypp;

import junit.framework.TestCase;
import fr.univsavoie.serveurbeta.generationvm.engine.libzypp.*;
import java.util.ArrayList;

/**
 * Created by patrick-edouard on 2/19/14.
 */
public class PackageManagerInsterfaceTest extends TestCase {
    public void testGetProposedPackagesName() throws Exception {
        String packageName = "kiwi";

        PackageManagerInterface pm = new PackageManagerInterface();
        ArrayList<String> packagesName = pm.getProposedPackagesName(packageName);
        assertEquals("kiwi",packagesName.get(0));
        assertEquals("kiwi-config-openSUSE",packagesName.get(1));
        assertEquals("kiwi-desc-isoboot",packagesName.get(2));
        assertEquals("kiwi-desc-isoboot-requires",packagesName.get(3));

    }
}