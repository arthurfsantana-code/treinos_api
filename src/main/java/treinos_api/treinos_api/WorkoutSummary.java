package treinos_api.treinos_api;

public record WorkoutSummary(
        int id,
        String name,
        String level,
        int duration,
        String muscleGroup,
        String imageUrl,
        int exerciseCount
) {}
