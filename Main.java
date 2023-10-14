package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private VBox startPage;
    private VBox intermediatePage;
    private VBox muscleGroupSelectionPage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("muscle workout selector");

        // set up the FitnessApp
        FitnessApp fitnessApp = new FitnessApp();

        // sets up the start page
        startPage = createStartPage(fitnessApp);
        Scene scene = new Scene(startPage, 400, 400);
        primaryStage.setScene(scene);

        // shows the stage
        primaryStage.show();
    }

    private VBox createStartPage(FitnessApp fitnessApp) {
        VBox startPage = new VBox(20);
        startPage.setAlignment(Pos.CENTER);
        startPage.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Label for the welcome message
        Label welcomeLabel = new Label(fitnessApp.getName());
        welcomeLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        // Button for starting
        Button startButton = new Button("ready to start?");
        startButton.setOnAction(e -> showIntermediatePage());

        startPage.getChildren().addAll(welcomeLabel, startButton);
        return startPage;
    }

    private void showIntermediatePage() {
    	//page for in between 
        intermediatePage = createIntermediatePage();
        Scene scene = new Scene(intermediatePage, 400, 300);
        primaryStage.setScene(scene);
    }

    private VBox createIntermediatePage() {
        VBox intermediatePage = new VBox(20);
        intermediatePage.setAlignment(Pos.CENTER);
        intermediatePage.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // label for intermediate page
        Label titleLabel = new Label("click for some workouts");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        Button proceedButton = new Button("come on!");
        proceedButton.setOnAction(e -> showMuscleGroupSelectionPage());

        intermediatePage.getChildren().addAll(titleLabel, proceedButton);
        return intermediatePage;
    }

    private void showMuscleGroupSelectionPage() {
        // creates Muscle Group Selection page
        muscleGroupSelectionPage = createMuscleGroupSelectionPage();
        Scene scene = new Scene(muscleGroupSelectionPage, 400, 300);
        primaryStage.setScene(scene);
    }

    private VBox createMuscleGroupSelectionPage() {
        VBox muscleGroupSelectionPage = new VBox(20);
        muscleGroupSelectionPage.setAlignment(Pos.CENTER);
        muscleGroupSelectionPage.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        Label titleLabel = new Label("Muscle Group Selection");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        Button chestButton = createExerciseButton("chest", "bench press");
        Button backButton = createExerciseButton("back", "deadlift");
        Button shouldersButton = createExerciseButton("shoulders", "shoulder press");
        Button armsButton = createExerciseButton("arms", "bicep curls");
        Button legsButton = createExerciseButton("legs", "squats");
        Button calvesButton = createExerciseButton("calves", "calf raises");
        muscleGroupSelectionPage.getChildren().addAll(titleLabel, chestButton, backButton, shouldersButton, armsButton, legsButton, calvesButton);
        return muscleGroupSelectionPage;
    }

    private Button createExerciseButton(String muscleGroupName, String exerciseName) {
        Button exerciseButton = new Button("click here for " + muscleGroupName + " exercises");
        exerciseButton.setOnAction(e -> showExercisePage(exerciseName));
        return exerciseButton;
    }

    private void showExercisePage(String exerciseName) {
        //exercise page
        VBox exercisePage = createExercisePage(exerciseName);
        Scene scene = new Scene(exercisePage, 400, 300);
        primaryStage.setScene(scene);
    }

    private VBox createExercisePage(String exerciseName) {
        VBox exercisePage = new VBox(20);
        exercisePage.setAlignment(Pos.CENTER);
        exercisePage.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        displayPredefinedInfo(exercisePage, exerciseName);

        Button backButton = new Button("back");
        backButton.setOnAction(e -> showMuscleGroupSelectionPage());

        exercisePage.getChildren().addAll(backButton);
        return exercisePage;
    }

    private void displayPredefinedInfo(VBox exercisePage, String exerciseName) {
        switch (exerciseName) {
            case "bench press":
                displayInfo(exercisePage, "flat bench press: compound press where you press weights up from your chest", "muscle targeted: pects", "area: upper", "duration: 10-30 minutes", "reps: 8-15", "intensity: moderate-very very intense", "equipment: barbell, bench, or none (push up)");
                break;
            case "deadlift":
                displayInfo(exercisePage, "deadlift: compound lift where you lift from the ground from a squat to a stand. (KEEP YOUR BACK STRAIGHT AND HEAD UP!!!) The weight is at your sides or in front of you.", "muscle targeted: back, legs", "area: full body", "duration: 30 minutes to even a couple hours", "reps: 5-10", "intensity: high", "equipment: barbell, plates, trapbar");
                break;
            case "shoulder press":
                displayInfo(exercisePage, "shoulder press or overhead press: lift where you press weight up from your shoulders to a full extention over your head.", "muscle targeted: shoulders", "area: upper", "duration: 20 minutes", "Reps: 8-15", "intensity: light but it depends", "equipment: dumbbells or bar");
                break;
            case "bicep curls":
                displayInfo(exercisePage, "bicep curls: resistance training where you lift a weight from a full extention to fully squeezed back to the extended postion. Usually stopping before a full extension can reduce injury, just take your time and feel the burn.", "muscle targeted: biceps (top of arm)", "area: upper", "duration: 15-30 minutes", "reps: 8-12", "intensity: moderate-intense", "equipment: dumbbells or I suggest a curved bar");
                break;
            case "squats":
                displayInfo(exercisePage, "squats: fundamental leg exercise where you bend your knees to be parallel with your bottom and then back up. Your legs can be at shoulder width or wider, which works different areas of the same muscles.", "muscle targeted: legs", "area: lower", "duration: 25-45 minutes", "reps: 1-25", "intensity: moderate-intense", "equipment: barbell or none (body weight)");
                break;
            case "calf raises":
                displayInfo(exercisePage, "calf raises: really simple exercise for the bottom of your legs where many people tend to forget. You start at a regular flat postion and then lift to your tippy toes and back.", "muscle targeted: calves", "area: lower", "duration: 10-20 minutes", "reps: 15-30", "intensity: light", "equipment: none or barbell");
                break;
            default:
                break;
        }
    }

    private void displayInfo(VBox exercisePage, String... info) {
        for (String data : info) {
            Label label = new Label(data);
            exercisePage.getChildren().add(label);
        }
    }
}
