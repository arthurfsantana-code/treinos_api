package treinos_api.treinos_api;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String level;
    private int duration;
    private String muscleGroup;

    @Column(length = 1000)
    private String imageUrl;

    @OneToMany(
            mappedBy = "workout",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Exercise> exercises = new ArrayList<>();

    public Workout() {

    }
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getLevel() { return level; }
    public int getDuration() { return duration; }
    public String getMuscleGroup() { return muscleGroup; }
    public String getImageUrl() { return imageUrl; }
    public List<Exercise> getExercises() { return exercises; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLevel(String level) { this.level = level; }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setExercises(List<Exercise> exercises) {
        this.exercises.clear();
        if (exercises != null) {
            for (Exercise exercise : exercises) {
                exercise.setWorkout(this);
                this.exercises.add(exercise);
            }
        }
    }
}
