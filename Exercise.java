package application;

public class Exercise extends Fitness {
    private int repetitions;
    private int durationMinutes;
    private int intensity;
    private String equipment;
    private int caloriesBurned;

    public Exercise(String name, String description, int repetitions, int durationMinutes, int intensity, String equipment, int caloriesBurned) {
        super(name, description);
        this.repetitions = repetitions;
        this.durationMinutes = durationMinutes;
        this.intensity = intensity;
        this.equipment = equipment;
        this.caloriesBurned = caloriesBurned;
    }

    // getters
    public int getRepetitions() {
        return repetitions;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getIntensity() {
        return intensity;
    }

    public String getEquipment() {
        return equipment;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }
}
