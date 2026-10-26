package treinos_api.treinos_api.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import treinos_api.treinos_api.Workout;

import java.util.List;

public interface WorkoutRepository
        extends JpaRepository<Workout, Integer> {

    @Override
    @EntityGraph(attributePaths = "exercises")
    List<Workout> findAll();
}