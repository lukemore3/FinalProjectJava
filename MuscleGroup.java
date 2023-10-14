package application;

public class MuscleGroup extends Fitness {
    public String muscleNames;
    public String muscleDescription;
    String muscleCategory;

    public MuscleGroup(String name, String description, String muscleNames, String muscleDescription, String muscleCategory) {
        super(name, description);
        this.muscleNames = muscleNames;
        this.muscleDescription = muscleDescription;
        this.muscleCategory = muscleCategory;
    }
}
