package treinos_api.treinos_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import treinos_api.treinos_api.Workout;
import treinos_api.treinos_api.WorkoutSummary;
import treinos_api.treinos_api.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    private final WorkoutRepository repository;

    public WorkoutService(WorkoutRepository repository) {
        this.repository = repository;
    }
    @Transactional(readOnly = true)
    public List<WorkoutSummary> findAll(String level) {
        return repository.findAll().stream()
                .filter(w -> level == null
                        || level.isBlank()
                        || w.getLevel().equalsIgnoreCase(level))
                .map(w -> new WorkoutSummary(
                        w.getId(),
                        w.getName(),
                        w.getLevel(),
                        w.getDuration(),
                        w.getMuscleGroup(),
                        w.getImageUrl(),
                        w.getExercises().size()
                ))
                .toList();
    }
    @Transactional(readOnly = true)
    public Optional<Workout> findById(int id) {
        return repository.findById(id);
    }
    @Transactional
    public Workout save(Workout workout) {
        workout.setId(null);

        if (workout.getExercises() != null) {
            workout.getExercises().forEach(exercise -> {
                exercise.setId(null);
                exercise.setWorkout(workout);
            });
        }
        return repository.save(workout);
    }
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
