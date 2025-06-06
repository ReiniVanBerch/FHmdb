package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;

import java.util.List;

public class SortContext {
    private MovieSortState currentState;

    public SortContext() {
        this.currentState = new NotSortedState(); // Startzustand
    }

    public void setState(MovieSortState newState) {
        this.currentState = newState;
    }

    public List<MovieEntity> sort(List<MovieEntity> movies) {
        return currentState.sort(movies);
    }

    public MovieSortState getCurrentState() {
        return currentState;
    }
}


