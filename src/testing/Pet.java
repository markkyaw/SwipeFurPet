package testing;
public class Pet {
    private String name;
    private String size;
    private String age;
    private String rescueID;
    private String img;
    private String location;
    private Integer distance;
    private Integer children;
    private Integer dogs;
    private Integer cats;
    public Pet(String name, String age, String size, String rescueID, String img, String location, Integer distance, Integer children, Integer dogs, Integer cats) {
        this.name = name;
        this.size = size;
        this.age = age;
        this.rescueID = rescueID;
        this.img = img;
        this.location = location;
        this.distance = distance;
        this.children = children;
        this.dogs = dogs;
        this.cats = cats;
    }
}

