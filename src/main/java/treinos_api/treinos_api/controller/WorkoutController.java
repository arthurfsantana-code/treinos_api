package treinos_api.treinos_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import treinos_api.treinos_api.Workout;
import treinos_api.treinos_api.repository.WorkoutRepository;

import java.util.List;

@RestController
@RequestMapping({"/api/treinos", "/api/workouts"})
@CrossOrigin(origins = "*")
public class WorkoutController {

    private final WorkoutRepository repository;

    public WorkoutController(WorkoutRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Workout> listarTreinos() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Workout buscarTreino(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Treino não encontrado"
                ));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workout criarTreino(@RequestBody Workout workout) {
        workout.setId(null);
        return repository.save(workout);
    }
}
