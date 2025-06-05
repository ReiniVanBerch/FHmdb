package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;

import java.util.List;

public interface MovieSortState {
    List<MovieEntity> sort(List<MovieEntity> movies);
}