package testing;
public class Preferences implements java.io.Serializable  {
	
	String email;
	String petType; 
    private String size;
    private String age;
    private int children;
    private int dogs;
    private int cats;
    
    public Preferences(String email, String petType, String size, String age, int children, int dogs, int cats) {
    	this.email = email;
    	this.petType = petType; 
    	this.size = size;
        this.age = age;
        this.children = children;
        this.dogs = dogs;
        this.cats = cats;
    }
    
    public String petType() {
    	return petType; 

    }
    
    public String getSize() {
    	return size; 
    	
    }
    
    public String getAge() {
    	return age; 
    }
    
    public int children() {
    	return children;
    }
    public int dogs() {
    	return dogs; 
    }
    
    public int cats() {
    	return cats; 
    }
 }
