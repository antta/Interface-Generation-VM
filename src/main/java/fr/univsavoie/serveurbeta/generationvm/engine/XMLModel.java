package fr.univsavoie.serveurbeta.generationvm.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Content;
import org.jdom2.Element;

/**
 * Created with IntelliJ IDEA.
 * User: patrick-edouard & nicolas
 * Date: 12/2/13
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 *
 * This class is made to be the representation of the config.xml file.
 *
 * For instance, the following sample was made to generate de vm with
 * Jenkins pre-installed.
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
    	private Element usersRoot;
    		private Element userRoot;
    	
    		private List<Element> listRepo = new ArrayList<Element>();
    	
    private String tagImage              	= "image";
    private String tagDescription        	= "description";
    private String tagAauthor             	= "author";
    private String tagContact            	= "contact";
    private String tagSpecification      	= "specification";
    private String tagPreferences        	= "preferences";
	private String tagType               	= "type";
	private String tagMachine            	= "machine";
	private String tagVmdisk             	= "vmdisk";
	private String tagVmdvd              	= "vmdvd";
	private String tagVmnic              	= "vmnic";
	private String tagSize               	= "size";
	private String tagVersion            	= "version";
	private String tagPackagemanager     	= "packagemanager";
	private String tagRpmchecksignatures 	= "rpm-check-signatures";
	private String tagRpmforce           	= "rpm-force";
	private String tagBoottheme          	= "boot-theme";
	private String tagTimezone           	= "timezone";
	private String tagHwclock            	= "hwclock";
	private String tagUsers              	= "users";
	private String tagUser               	= "user";
	private String tagPackages				= "packages";
	private String tagPackage				= "package";
	private String tagRepository			= "repository";
	private String tagSource				= "source";
	
	private List<Attribute> attributeImage				= new ArrayList<Attribute>();
	private List<Attribute> attributeDescription      	= new ArrayList<Attribute>();
	private List<Attribute> attributeAuthor           	= new ArrayList<Attribute>();
	private List<Attribute> attributeContact           	= new ArrayList<Attribute>();
	private List<Attribute> attributeSpecification     	= new ArrayList<Attribute>();
	private List<Attribute> attributePreferences       	= new ArrayList<Attribute>();
	private List<Attribute> attributeType              	= new ArrayList<Attribute>();
	private List<Attribute> attributeMachine           	= new ArrayList<Attribute>();
	private List<Attribute> attributeVmdisk            	= new ArrayList<Attribute>();
	private List<Attribute> attributeVmdvd             	= new ArrayList<Attribute>();
	private List<Attribute> attributeVmnic             	= new ArrayList<Attribute>();
	private List<Attribute> attributeSize              	= new ArrayList<Attribute>();
	private List<Attribute> attributeVersion           	= new ArrayList<Attribute>();
	private List<Attribute> attributePackagemanager    	= new ArrayList<Attribute>();
	private List<Attribute> attributeRpmchecksignatures	= new ArrayList<Attribute>();
	private List<Attribute> attributeRpmforce          	= new ArrayList<Attribute>();
	private List<Attribute> attributeBoottheme			= new ArrayList<Attribute>();
	private List<Attribute> attributeTimezone           = new ArrayList<Attribute>();
	private List<Attribute> attributeHwclock            = new ArrayList<Attribute>();
	private List<Attribute> attributeUsersRoot 		    = new ArrayList<Attribute>();
	private List<Attribute> attributeUser               = new ArrayList<Attribute>();
	
	private List<Content> contentImage	                = new ArrayList<Content>();
	private List<Content> contentDescription            = new ArrayList<Content>();
	private List<Content> contentPreferences            = new ArrayList<Content>();
	private List<Content> contentType                   = new ArrayList<Content>();
	private List<Content> contentMachine                = new ArrayList<Content>();
	private List<Content> contentUsers                  = new ArrayList<Content>();

	private int templateNumber = 1;
	
	public XMLModel(){
		createTree();
	}
	
	public XMLModel(int choice){
		
		createTree();
		this.setTemplateNumber(choice);
		
	}
	
	public int getTemplateNumber() {
		return templateNumber;
	}

	public final void setTemplateNumber(int templateNumber) {
		this.templateNumber = templateNumber;
	}

	/**
	 * function who regroup all creating function
	 * it use those function : 
	 * 		createAllElement();
	 * 		assignAllAttributes();
	 * 		addAllContent();
	 * 
	 *@author nicolas
	 */
    private final void createTree(){

    	createAllElement();
    	assignAllAttributes();
    	addAllContent();
    }
    
    /**
     * Create all the element of XML, instanciate all the element of class
     * 
     * @author nicolas
     */
	private void createAllElement(){
    	
    	image = new Element(tagImage);
		description = new Element(tagDescription);
			author = new Element(tagAauthor);
			contact = new Element(tagContact);
			specification = new Element(tagSpecification);
        preferences = new Element(tagPreferences);
        	type = new Element(tagType);
        		machine = new Element(tagMachine);
        			vmdisk = new Element(tagVmdisk);
        			vmdvd = new Element(tagVmdvd);
        			vmnic = new Element(tagVmnic);
        		size = new Element(tagSize);
    		version = new Element(tagVersion);
    		packagemanager = new Element(tagPackagemanager);
    		rpmchecksignatures = new Element(tagRpmchecksignatures);
    		rpmforce = new Element(tagRpmforce);
    		boottheme = new Element(tagBoottheme);
    		timezone = new Element(tagTimezone);
    		hwclock = new Element(tagHwclock);
    	usersRoot = new Element(tagUsers);
    		userRoot = new Element(tagUser);
    	new Element(tagPackages);
    		createXMLviaTemplate(this.getTemplateNumber());
    		createRepoDefault();
    		
    }
	
	/**
	 * add a new attribute in the attribute's list then add list to element
	 * 
	 * @author nicolas
	 */
    private void assignAllAttributes(){
    	
    	attributeImage.add(new Attribute("name","SuseAxway"));
    	attributeImage.add(new Attribute("displayname", "SuseAxway"));
    	attributeImage.add(new Attribute("schemaversion", "5.2"));
    	image.setAttributes(attributeImage);
    	
    	attributeDescription.add(new Attribute("type","system"));
    	description.setAttributes(attributeDescription);
    	
    	author.setAttributes(attributeAuthor);

    	contact.setAttributes(attributeContact);

    	specification.setAttributes(attributeSpecification);

    	preferences.setAttributes(attributePreferences);
    	
    	attributeType.add(new Attribute("checkprebuilt", "true"));
    	attributeType.add(new Attribute("boot", "vmxboot/suse-12.3"));
    	attributeType.add(new Attribute("fsnocheck", "true"));
    	attributeType.add(new Attribute("filesystem", "ext3"));
    	attributeType.add(new Attribute("bootloader", "grub"));	//Change to grub2 if it gets patched
    	attributeType.add(new Attribute("primary", "true"));
    	attributeType.add(new Attribute("format", "vmdk"));
    	attributeType.add(new Attribute("kernelcmdline", "quiet"));
    	attributeType.add(new Attribute("image", "vmx"));
    	type.setAttributes(attributeType);
    	
    	attributeMachine.add(new Attribute("memory", "1024"));
    	attributeMachine.add(new Attribute("arch", "x86_64"));
    	attributeMachine.add(new Attribute("guestOS", "suse-64"));
    	machine.setAttributes(attributeMachine);
    	
    	attributeVmdisk.add(new Attribute("controller", "scsi"));
    	attributeVmdisk.add(new Attribute("id", "0"));
    	vmdisk.setAttributes(attributeVmdisk);
    	
    	attributeVmdvd.add(new Attribute("controller", "ide"));
    	attributeVmdvd.add(new Attribute("id", "0"));
    	vmdvd.setAttributes(attributeVmdvd);

        attributeVmnic.add(new Attribute("driver", "e1000"));
        attributeVmnic.add(new Attribute("interface", "0"));
        attributeVmnic.add(new Attribute("mode", "bridged"));
        vmnic.setAttributes(attributeVmnic);
        
        attributeSize.add(new Attribute("unit", "M"));
        attributeSize.add(new Attribute("additive", "false"));
        size.setAttributes(attributeSize);
        
    	version.setAttributes(attributeVersion);

    	packagemanager.setAttributes(attributePackagemanager);

    	rpmchecksignatures.setAttributes(attributeRpmchecksignatures);

    	rpmforce.setAttributes(attributeRpmforce);

    	boottheme.setAttributes(attributeBoottheme);

    	timezone.setAttributes(attributeTimezone);

    	hwclock.setAttributes(attributeHwclock);

    	attributeUsersRoot.add(new Attribute("group", "root"));
    	usersRoot.setAttributes(attributeUsersRoot);  	
    	
    	attributeUser.add(new Attribute("name","root"));
    	attributeUser.add(new Attribute("pwd","$1$O18RH8FB$Hg7xawIuJlQzLfawBKb/H1"));
    	attributeUser.add(new Attribute("home","/root"));
    	attributeUser.add(new Attribute("shell","/bin/bash"));
    	userRoot.setAttributes(attributeUser);
    	
    }
    
    /**
     * add content to element's content list then add content to element
     * 
     * @author nicolas
     */
    private void addAllContent() {
		
    	contentImage.add(description);
    	contentImage.add(preferences);
    	contentImage.add(usersRoot);
    	contentImage.addAll(listRepo);
    	image.addContent(contentImage);
    	
    	contentDescription.add(author);
    	contentDescription.add(contact);
    	contentDescription.add(specification);
    	description.addContent(contentDescription);
    	
    	author.addContent("VM'owner");
    	contact.addContent("owner@domain.com");
    	specification.addContent("Tiny Suse");
    	
    	contentPreferences.add(type);
        contentPreferences.add(version);
        contentPreferences.add(packagemanager);
        contentPreferences.add(rpmchecksignatures);
        contentPreferences.add(rpmforce);
        contentPreferences.add(boottheme);
        contentPreferences.add(timezone);
        contentPreferences.add(hwclock);
        preferences.addContent(contentPreferences);
        
        contentType.add(machine);
        contentType.add(size);
        type.addContent(contentType);
        
        size.addContent("16384");
        
        contentMachine.add(vmdisk);
        contentMachine.add(vmdvd);
        contentMachine.add(vmnic);
        machine.addContent(contentMachine);

        version.addContent("1.0.0");
        packagemanager.addContent("zypper");
        rpmchecksignatures.addContent("false");
        rpmforce.addContent("false");
        boottheme.addContent("studio");
        timezone.addContent("UTC");
        hwclock.addContent("localtime");
        
        contentUsers.add(userRoot);
        usersRoot.addContent(contentUsers);        	
	}
    
    private void createXMLviaTemplate(int choice){
    	
    	switch(choice){
    	case 1 :createPackageTemplate(jeOSPackages());
    			break;
    	case 2 :createPackageTemplate(gnomePackages());
    			break;
    	default : throw new IllegalArgumentException();
    	}
    }
    private void createPackageTemplate(List<String> listPackage){
    	
    	List<String> listTypePackage = new ArrayList<String>();
    	listTypePackage.add("image");
    	listTypePackage.add("bootstrap");
    	// liste des attributs de la balise <package type=image>
    	List<Attribute> listAttributeImage = new ArrayList<Attribute>();
		listAttributeImage.add(new Attribute("type","image"));
		listAttributeImage.add(new Attribute("patternType","onlyRequired"));
		// liste des attributs de la balise <package type="bootstrap">
		List<Attribute> listAttributeBootstrap = new ArrayList<Attribute>();
		listAttributeBootstrap.add(new Attribute("type","bootstrap"));
		// liste de liste d'attribut
		List<List<Attribute>> listAttributePackage = new ArrayList<List<Attribute>>();
		listAttributePackage.add(listAttributeImage);
		listAttributePackage.add(listAttributeBootstrap);
		// liste de liste de package
		List<List<String>> listListPackage = new ArrayList<List<String>>();
		listListPackage.add(listPackage);
		listListPackage.add(bootstrapPackages());
		
		for(int i = 0; i < listTypePackage.size(); ++i){
			
			createPackages(listTypePackage.get(i), listAttributePackage.get(i), listListPackage.get(i));
		}
    }
    
    private void createPackages (String typePackage, List<Attribute> listAttribute, List<String> listPackage){
    	
    	Element temporaryElement = new Element(tagPackages);
    	temporaryElement.setAttributes(listAttribute);
    	image.addContent(temporaryElement);

    	for(String packageName : listPackage){
    		addPackage(packageName, typePackage);
    	}
    }
    
    private void createRepoDefault(){
    	
    	List<String> listPath = new ArrayList<String>();
    	List<String> listTypeRepo = new ArrayList<String>();
    	listPath.add("http://download.opensuse.org/distribution/12.3/repo/oss/");
    	listPath.add("http://download.opensuse.org/update/12.3/");
    	listTypeRepo.add("yast2");
    	listTypeRepo.add("rpm-md");
    	listRepo.add(new Element(tagRepository));
    	listRepo.add(new Element(tagRepository));
    	for(int i = 0; i < listRepo.size(); i++){
    		listRepo.get(i).setAttribute("type",listTypeRepo.get(i));
    		listRepo.get(i).addContent(new Element(tagSource).setAttribute("path",listPath.get(i)));
    	}
    
    }

    private List<String> jeOSPackages(){
 
	    List<String> listTemp = new ArrayList<String>();
    	listTemp.add("aaa_base");
	    listTemp.add("branding-openSUSE");
		listTemp.add("patterns-openSUSE-base");
		listTemp.add("grub");
		listTemp.add("hwinfo");
		listTemp.add("iputils");
		listTemp.add("kernel-default");
		listTemp.add("netcfg");
		listTemp.add("openSUSE-build-key");
		listTemp.add("openssh");
		listTemp.add("plymouth");
		listTemp.add("polkit-default-privs");
		listTemp.add("rpcbind");
		listTemp.add("syslog-ng");
		listTemp.add("vim");
		listTemp.add("zypper");
		listTemp.add("timezone");
		return listTemp;
    }
    
    private List<String> gnomePackages(){
    	
	    List<String> listTemp = new ArrayList<String>();
        listTemp.add("gnome-terminal");
        listTemp.add("gtk2-branding-openSUSE");
        listTemp.add("gtk3-branding-openSUSE");
        listTemp.add("gvfs-backends");
        listTemp.add("libgnomesu");
        listTemp.add("sax2-tools");
        listTemp.add("tomboy");
        listTemp.add("yast2-control-center-gnome");
        listTemp.add("SuSEfirewall2");
        listTemp.add("grub2");
        listTemp.add("glibc-locale");
        listTemp.add("iputils");
        listTemp.add("kernel-default");
        listTemp.add("less");
        listTemp.add("plymouth");
        listTemp.add("syslog-ng");
        listTemp.add("vim");
        listTemp.add("yast2");
        listTemp.add("yast2-firstboot");
        listTemp.add("zypper");
        listTemp.add("dbus-1-x11");
        listTemp.add("icewm");
        listTemp.add("x11-tools");
        listTemp.add("xf86-video-modesetting");
        listTemp.add("xorg-x11");
        listTemp.add("xorg-x11-driver-input");
        listTemp.add("xorg-x11-driver-video");
        listTemp.add("xorg-x11-fonts");
        listTemp.add("xorg-x11-server");
        listTemp.add("yast2-branding-openSUSE");
        listTemp.add("yast2-theme-openSUSE");
        listTemp.add("yast2-x11");
		return listTemp;

    }
	
	private List<String> bootstrapPackages(){
		
		List<String> listTemp = new ArrayList<String>();
		listTemp.add("filesystem");
		listTemp.add("glibc-locale");
		listTemp.add("module-init-tools");
		return listTemp;
	}
	
	
    /**
     * setAuthor
     *
     * Fill the /image/description/author field with the given author
     *
     * @param author The author name to be set
     */
    public void setAuthor(String author){
        this.image.getChild(tagDescription).getChild(tagAauthor).setText(author);
    }

    /**
     * setAuthorMail
     *
     * Fill the /image/description/author field with the given author
     *
     * @param mail The mail to be set
     */
    public void setAuthorMail(String mail){
        this.image.getChild(tagDescription).getChild(tagContact).setText(mail);
    }

    /**
     * setSpecification
     *
     * Fill the /image/description/author field with the given author
     *
     * @param specification The mail to be set
     */
    public void setSpecification(String specification){
        this.image.getChild(tagDescription).getChild(tagSpecification).setText(specification);
    }

    /**
     * addPackage
     *
     * Add a package with default parameter. This is the easiest way to add a package.
     *
     * @param packageName the name of the package used on the repository
     */
    public void addPackage(String packageName){
        this.addPackage(packageName, "image");
    }

    /**
     * addPackage
     *
     * Add a package with the given packageType
     *
     * @param packageName the name of the package used on the repository
     * @param packageType see http://doc.opensuse.org/projects/kiwi/doc/#sec.description.repository
     */
    public void addPackage(String packageName, String packageType){
        List<Element> packagesList = this.image.getChildren("packages");
        for(Element e : packagesList){
            for(Attribute a : e.getAttributes()){
                if(a.getName().equals("type")) {
                    if(a.getValue().equals(packageType)) {
                        e.addContent(new Element(this.tagPackage).setAttribute("name",packageName));
                        return;
                    }
                }
            }
        }
    }

    /**
     * addPackage
     *
     * Add a package with the given packageType
     *
     * @param packageName the name of the package used on the repository
     * @param groupType ex root ect
     * @param userAttributes must have name, pwd, home, shell
     */
    public void addUser(String packageName, String groupType, Collection<Attribute> userAttributes){
        List<Element> packagesList = this.image.getChildren("users");
        for(Element e : packagesList){
            // search if the user group does exist
            for(Attribute a : e.getAttributes()){
                if(a.getName().equals("group")) {
                    if(a.getValue().equals(groupType)) {
                        e.addContent(new Element(this.tagUser).setAttributes(userAttributes));
                        return;
                    }
                }
            }
            // if user group doesn't exist we need to create it
            e.addContent(new Element(groupType).addContent(new Element(this.tagUser).setAttributes(userAttributes)));
        }
    }


    /**
     * addRepository
     *
     * Add a repository with the given repositoryType
     *
     * @param repositoryURL the name of the package used on the repository
     * @param repositoryType see http://doc.opensuse.org/projects/kiwi/doc/#sec.description.repository
     */
    public void addRepository(String repositoryURL, String repositoryType){
        List<Element> packagesList = this.image.getChildren("repository");
        for(Element e : packagesList){
            for(Attribute a : e.getAttributes()){
                if(a.getName().equals("type")) {
                    if(a.getValue().equals(repositoryType)) {
                        e.addContent(new Element(this.tagRepository).setAttribute("path",repositoryURL));
                        return;
                    }
                }
            }
        }
    }

    public Element fileRepresentationRoot(){
        return this.image;
    }
}
