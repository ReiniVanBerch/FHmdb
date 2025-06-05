package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;

import java.util.List;

public class NotSortedState implements MovieSortState {
    @Override
    public List<MovieEntity> sort(List<MovieEntity> movies) {
        return movies;  // keine sortierung
    }
}