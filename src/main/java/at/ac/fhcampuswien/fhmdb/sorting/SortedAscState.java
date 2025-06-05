package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedAscState implements MovieSortState {
    @Override
    public List<MovieEntity> sort(List<MovieEntity> movies) {
        return movies.stream()
                .sorted(Comparator.comparing(MovieEntity::getTitle))
                .collect(Collectors.toList());
    }
}