package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.jdom2.Content;
import org.jdom2.Element;
import org.jdom2.Attribute;

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
	
    private Element image;
        private Element description;
        	private Element author;
        	private Element contact;
        	private Element specification;
        private Element preferences;
        	private Element type;
        		private Element machine;
        			private Element vmdisk;
        			private Element vmdvd;
        			private Element vmnic;
        		private Element size;
    		private Element version;
    		private Element packagemanager;
    		private Element rpmchecksignatures;
    		private Element rpmforce;
    		private Element boottheme;
    		private Element timezone;
    		private Element hwclock;
    	private Element users;
    		private Element user;
    		

    private String tag_image = "image";
    private String tag_description = "description";
    private String tag_author = "author";
    private String tag_contact = "contact";
    private String tag_specification = "specification";
    private String tag_preferences = "preference";
	private String tag_type = "type";
	private String tag_machine = "machine";
	private String tag_vmdisk = "vmdisk";
	private String tag_vmdvd = "vmdvd";
	private String tag_vmnic = "vmnic";
	private String tag_size = "size";
	private String tag_version = "version";
	private String tag_packagemanager = "packagemanager";
	private String tag_rpmchecksignatures = "rpm-check-manager";
	private String tag_rpmforce = "rpm-force";
	private String tag_boottheme = "boot-theme";
	private String tag_timezone = "timezone";
	private String tag_hwclock = "hwclock";
	private String tag_users = "users";
	private String tag_user = "user";
	
	private List<Attribute> attribute_image = new ArrayList<Attribute>();
	private List<Attribute> attribute_description = new ArrayList<Attribute>();
	private List<Attribute> attribute_author = new ArrayList<Attribute>();
	private List<Attribute> attribute_contact = new ArrayList<Attribute>();
	private List<Attribute> attribute_specification = new ArrayList<Attribute>();
	private List<Attribute> attribute_preferences = new ArrayList<Attribute>();
	private List<Attribute> attribute_type = new ArrayList<Attribute>();
	private List<Attribute> attribute_machine = new ArrayList<Attribute>();
	private List<Attribute> attribute_vmdisk = new ArrayList<Attribute>();
	private List<Attribute> attribute_vmdvd = new ArrayList<Attribute>();
	private List<Attribute> attribute_vmnic = new ArrayList<Attribute>();
	private List<Attribute> attribute_size = new ArrayList<Attribute>();
	private List<Attribute> attribute_version = new ArrayList<Attribute>();
	private List<Attribute> attribute_packagemanager = new ArrayList<Attribute>();
	private List<Attribute> attribute_rpmchecksignatures = new ArrayList<Attribute>();
	private List<Attribute> attribute_rpmforce = new ArrayList<Attribute>();
	private List<Attribute> attribute_boottheme = new ArrayList<Attribute>();
	private List<Attribute> attribute_timezone = new ArrayList<Attribute>();
	private List<Attribute> attribute_hwclock = new ArrayList<Attribute>();
	private List<Attribute> attribute_users = new ArrayList<Attribute>();
	private List<Attribute> attribute_user = new ArrayList<Attribute>();
	
	private List<Content> content_image = new ArrayList<Content>();
	private List<Content> content_description = new ArrayList<Content>();
	private List<Content> content_preferences = new ArrayList<Content>();
	private List<Content> content_type = new ArrayList<Content>();
	private List<Content> content_machine = new ArrayList<Content>();
	
	
	public XMLModel(){
		
		createTree();
	}
	

    private void createTree(){
        //Sample of a collection to create multiple instance of 'packages'

        //Create a list of 'content' (Element extends content)
        //myPackages = new ArrayList<Content>();
    	createAllElement();
    	assignAllAttributes();
    	addAllContent();
    	
        //Create the sub tree and modify it as you wish : adding children, name, attributes
        //packages1 = new Element(balise_packages);
        //packages1.setAttribute("attributeName","attributeContent");
        //packages1.addContent(this.firstPackage);
        //myPackages.add(packages1);
        //myPackages.add(packages);
        //packages.addContent(myPackages);

    }
    
	private void createAllElement(){
    	
    	image = new Element(tag_image);
		description = new Element(tag_description);
			author = new Element(tag_author);
			contact = new Element(tag_contact);
			specification = new Element(tag_specification);
        preferences = new Element(tag_preferences);
        	type = new Element(tag_type);
        		machine = new Element(tag_machine);
        			vmdisk = new Element(tag_vmdisk);
        			vmdvd = new Element(tag_vmdvd);
        			vmnic = new Element(tag_vmnic);
        		size = new Element(tag_size);
    		version = new Element(tag_version);
    		packagemanager = new Element(tag_packagemanager);
    		rpmchecksignatures = new Element(tag_rpmchecksignatures);
    		rpmforce = new Element(tag_rpmforce);
    		boottheme = new Element(tag_boottheme);
    		timezone = new Element(tag_timezone);
    		hwclock = new Element(tag_hwclock);
    	users = new Element(tag_users);
    		user = new Element(tag_user);
    }
    
    private void assignAllAttributes(){
    	
    	attribute_image.add(new Attribute("name","SuseAxway"));
    	attribute_image.add(new Attribute("displayname", "SuseAxway"));
    	attribute_image.add(new Attribute("schemaversion", "5.2"));
    	image.setAttributes(attribute_image);
    	
    	attribute_description.add(new Attribute("type","system"));
    	description.setAttributes(attribute_description);
    	
    	attribute_author.add(new Attribute(null,null));
    	author.setAttributes(attribute_author);
    	
    	attribute_contact.add(new Attribute(null,null));
    	contact.setAttributes(attribute_contact);
    	
    	attribute_specification.add(new Attribute(null, null));
    	specification.setAttributes(attribute_specification);
    	
    	attribute_preferences.add(new Attribute(null, null));
    	preferences.setAttributes(attribute_preferences);
    	
    	attribute_type.add(new Attribute("checkprebuilt", "true"));
    	attribute_type.add(new Attribute("boot", "vmxboot/suse-12.3"));
    	attribute_type.add(new Attribute("fsnocheck", "true"));
    	attribute_type.add(new Attribute("filesystem", "ext3"));
    	attribute_type.add(new Attribute("bootloader", "grub2"));
    	attribute_type.add(new Attribute("primary", "true"));
    	attribute_type.add(new Attribute("format", "vmdk"));
    	attribute_type.add(new Attribute("kernelcmdline", "quiet"));
    	attribute_type.add(new Attribute("image", "vmx"));
    	type.setAttributes(attribute_type);
    	
    	attribute_machine.add(new Attribute("memory", "1024"));
    	attribute_machine.add(new Attribute("arch", "x86_64"));
    	attribute_machine.add(new Attribute("guestOS", "suse-64"));
    	machine.setAttributes(attribute_machine);
    	
    	attribute_vmdisk.add(new Attribute("controller", "scsi"));
    	attribute_vmdisk.add(new Attribute("id", "0"));
    	vmdisk.setAttributes(attribute_vmdisk);
    	
    	attribute_vmdvd.add(new Attribute("controller", "ide"));
    	attribute_vmdvd.add(new Attribute("id", "0"));
    	vmdvd.setAttributes(attribute_vmdisk);

        attribute_vmnic.add(new Attribute("driver", "e1000"));
        attribute_vmnic.add(new Attribute("interface", "0"));
        attribute_vmnic.add(new Attribute("mode", "bridged"));
        vmnic.setAttributes(attribute_vmnic);
        
        attribute_size.add(new Attribute("unit", "M"));
        attribute_size.add(new Attribute("additive", "false"));
        size.setAttributes(attribute_size);
        
    	attribute_version.add(new Attribute(null, null));
    	version.setAttributes(attribute_version);
    	  	
    	attribute_packagemanager.add(new Attribute(null, null));
    	packagemanager.setAttributes(attribute_packagemanager);
    	
    	attribute_rpmchecksignatures.add(new Attribute(null, null));
    	rpmchecksignatures.setAttributes(attribute_rpmchecksignatures);
    	
    	attribute_rpmforce.add(new Attribute(null, null));
    	rpmforce.setAttributes(attribute_rpmforce);
    	
    	attribute_boottheme.add(new Attribute(null, null));
    	boottheme.setAttributes(attribute_boottheme);
    	
    	attribute_timezone.add(new Attribute(null, null));
    	timezone.setAttributes(attribute_timezone);
    	
    	attribute_hwclock.add(new Attribute(null, null));
    	hwclock.setAttributes(attribute_hwclock);

    	attribute_users.add(new Attribute("group", "root"));
    	users.setAttributes(attribute_users);
    	
    	attribute_user.add(new Attribute("name","root"));
    	attribute_user.add(new Attribute("pwd","$1$O18RH8FB$Hg7xawIuJlQzLfawBKb/H1"));
    	attribute_user.add(new Attribute("home","/root"));
    	attribute_user.add(new Attribute("shell","/bin/bash"));
    	user.setAttributes(attribute_user);
    	
    }
    
    private void addAllContent() {
		
    	content_image.add(description);
    	content_image.add(preferences);
    	content_image.add(users);
    	image.addContent(content_image);
    	
    	content_description.add(author);
    	content_description.add(contact);
    	content_description.add(specification);
    	description.addContent(content_description);
    	
    	author.addContent("Challut Nicolas");
    	contact.addContent("nchal@etu.univ-savoie.fr");
    	specification.addContent("Tiny Suse");
    	
    	content_preferences.add(type);
        content_preferences.add(version);
        content_preferences.add(packagemanager);
        content_preferences.add(rpmchecksignatures);
        content_preferences.add(rpmforce);
        content_preferences.add(boottheme);
        content_preferences.add(timezone);
        content_preferences.add(hwclock);
        preferences.addContent(content_preferences);
        
        content_type.add(machine);
        content_type.add(size);
        type.addContent(content_type);
        
        size.addContent("16384");
        
        content_machine.add(vmdisk);
        content_machine.add(vmdvd);
        content_machine.add(vmnic);
        machine.addContent(content_machine);

        version.addContent("1.0.0");
        packagemanager.addContent("zypper");
        rpmchecksignatures.addContent("false");
        rpmforce.addContent("false");
        boottheme.addContent("studio");
        timezone.addContent("UTC");
        hwclock.addContent("localtime");
        
        
        
        
    	
	}

    /**
     * setAuthor
     *
     * Fill the /image/description/author field with the given author
     *
     * @param author The author name to be set
     */
    public void setAuthor(String author){
        this.image.getChild(tag_description).getChild(tag_author).addContent(author);
    }

    /**
     * set
     *
     * Fill the /image/description/author field with the given author
     *
     * @param mail The mail to be set
     */
    public void setAuthorMail(String mail){
        this.image.getChild(tag_description).getChild(tag_contact).addContent(mail);
    }

    public Element fileRepresentationRoot(){
        return this.image;
    }
}
