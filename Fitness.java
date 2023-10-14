package application;

public class Fitness {
    private String name;
    private String description;

    public Fitness(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //getters and setters for names and descriptions
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
