package engine;

import org.jdom2.Content;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: patrick-edouard
 * Date: 12/2/13
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 *
 * This class is made to be the representation of the config.xml file.
 *
 * For instance, the following sample was made to generate de vm with
 * Jenkins pre-installed.
 *
 *    <image name="SuseAxway" displayname="SuseAxway" schemaversion="5.2">
 *    <description type="system">
 *    <author>M1-STIC-Beta</author>
 *    <contact>m1-isc-projet-beta@univ-savoie.fr</contact>
 *    <specification>
 *    Virtual machine with Jenkins and dependencies pre-installed
 *    </specification>
 *    </description>
 *    <preferences>
 *    <type checkprebuilt="true" boot="vmxboot/suse-12.3" fsnocheck="true" filesystem="ext3" bootloader="grub2" primary="true" format="vmdk" kernelcmdline="quiet" image="vmx">
 *    <machine memory="1024" arch="x86_64" guestOS="suse-64">
 *    <vmdisk controller="scsi" id="0"/>
 *    <vmdvd controller="ide" id="0"/>
 *    <vmnic driver="e1000" interface="0" mode="bridged"/>
 *    </machine>
 *    <size unit="M" additive="false">16384</size>
 *    </type>
 *    <version>1.0.0</version>
 *    <packagemanager>zypper</packagemanager>
 *    <rpm-check-signatures>false</rpm-check-signatures>
 *    <rpm-force>false</rpm-force>
 *    <boot-theme>studio</boot-theme>
 *    <timezone>UTC</timezone>
 *    <hwclock>localtime</hwclock>
 *    </preferences>
 *    <users group="root">
 *    <user name="root" pwd="$1$O18RH8FB$Hg7xawIuJlQzLfawBKb/H1" home="/root" shell="/bin/bash"/>
 *    </users>
 *    <packages type="image" patternType="onlyRequired">
 *    <package name="kiwi-desc-vmxboot"/>
 *    <package name="kiwi-desc-netboot-requires"/>
 *    <package name="kiwi-image-livecd-kde-snapshot"/>
 *    <package name="kiwi-image-livecd-x11-snapshot"/>
 *    <package name="kiwi-image-livecd-gnome-snapshot"/>
 *    <package name="kiwi-desc-vmxboot-requires"/>
 *    <package name="kiwi-desc-oemboot-requires"/>
 *    <package name="kiwi-instsource-plugins-openSUSE-12-1"/>
 *    <package name="kiwi-desc-isoboot-requires"/>
 *    <package name="kiwi-media-requires"/>
 *    <package name="kiwi-templates"/>
 *    <package name="kiwi-instsource"/>
 *    <package name="kiwi-doc"/>
 *    <package name="kiwi-tools"/>
 *    <package name="kiwi-desc-oemboot"/>
 *    <package name="kiwi-config-openSUSE"/>
 *    <package name="kiwi-desc-netboot"/>
 *    <package name="kiwi-pxeboot"/>
 *    <package name="kiwi-desc-isoboot"/>
 *    <package name="kiwi"/>
 *    <package name="xorg-x11-fonts"/>
 *    <package name="jenkins"/>
 *    <package name="grub"/>
 *    <package name="tar"/>
 *    <package name="kvm"/>
 *    <package name="aaa_base"/>
 *    <package name="branding-openSUSE"/>
 *    <package name="grub2"/>
 *    <package name="hwinfo"/>
 *    <package name="iputils"/>
 *    <package name="kernel-default"/>
 *    <package name="netcfg"/>
 *    <package name="openSUSE-build-key"/>
 *    <package name="openssh"/>
 *    <package name="plymouth"/>
 *    <package name="polkit-default-privs"/>
 *    <package name="rpcbind"/>
 *    <package name="syslog-ng"/>
 *    <package name="vim"/>
 *    <package name="zypper"/>
 *    <package name="open-vm-tools"/>
 *    </packages>
 *    <packages type="bootstrap">
 *    <package name="filesystem"/>
 *    <package name="glibc-locale"/>
 *    <package name="module-init-tools"/>
 *    </packages>
 *    <repository type="yast2">
 *    <source path="http://download.opensuse.org/distribution/12.3/repo/oss/"/>
 *    </repository>
 *    <repository type="rpm-md">
 *    <source path="http://download.opensuse.org/update/12.3/"/>
 *    </repository>
 *    <repository type="rpm-md">
 *    <source path="http://pkg.jenkins-ci.org/opensuse/"/>
 *    </repository>
 *    </image>
 *
 *  @see 'http://doc.opensuse.org/projects/kiwi/schema-doc/'
 *  @see 'http://doc.opensuse.org/projects/kiwi/doc/#sec.description.config.xml'
 */

public class XMLModel {
    Element image;
        Element description;
        Element preferences;
        Element users;
        Collection<Content> myPackages;
            Element packages1;
                Element firstPackage;
                Element secondPackage;
           Element packages;
        Collection<Content> myRepository;
            Element repository1;
            Element repository;





    private String balise_packages = "packages";

    private void createTree(){
        //Sample of a collection to create multiple instance of 'packages'

        //Create a list of 'content' (Element extends content)
        myPackages = new ArrayList<Content>();

        //Create the sub tree and modify it as you wish : adding children, name, attributes
        packages1 = new Element(balise_packages);
        packages1.setAttribute("attributeName","attributeContent");
        myPackages.add(packages1);
        myPackages.add(packages);
        packages.addContent(myPackages);

    }

    public Element fileRepresentationRoot(){
        return this.image;
    }
}
