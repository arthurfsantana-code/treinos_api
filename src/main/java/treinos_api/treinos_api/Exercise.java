package treinos_api.treinos_api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int sets;
    private String reps;
    @Column(length = 1000)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id")
    @JsonIgnore
    private Workout workout;

    public Exercise() {}

    public Integer getId() { return id; }
    public String getName() { return name; }
    public int getSets() { return sets; }
    public String getReps() { return reps; }
    public String getImageUrl() { return imageUrl; }
    public Workout getWorkout() { return workout; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSets(int sets) { this.sets = sets; }
    public void setReps(String reps) { this.reps = reps; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}
