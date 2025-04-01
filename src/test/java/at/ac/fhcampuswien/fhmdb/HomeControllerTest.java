package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    @DisplayName("Movie: Testet den Initializier")
    public void movie_test_the_initializer(){
        List<Movie> test =   Movie.initializeMovies();
        assertNotNull(test);
    }
    @Test
    @DisplayName("Movie: Check the getter for Description")
    public void movie_check_if_the_get_desc_returns_a_value(){
        Movie.initializeMovies();
        List<Movie> test =   Movie.initializeMovies();
        String desc =test.get(0).getDescription();
        assertEquals("a captain is on the search for the last surviving son of a family", desc);
    }
    @Test
    @DisplayName("Movie: Check the getter for Title")
    public void movie_check_if_the_get_title_returns_a_value(){
        Movie.initializeMovies();
        List<Movie> test =   Movie.initializeMovies();
        String title =test.get(0).getTitle();
        assertEquals("Saving Private Jamey Ryan", title);
    }

    //checks toString method

    //checks equals method


    @Test
    @DisplayName("checks if list is filtered without having to consider capitalisation")
    public void check_if_list_is_filtered_without_capitalisation_accuracy() {
        HomeController test = new HomeController();

        test.initializeLogic();
        String testQuery = "di";
        List<Movie> actualList = test.filterSearchField(testQuery, Movie.initializeMovies());
        List<Movie> expectedList = new ArrayList<>();
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);
        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));
        expectedList.add(new Movie("The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5));
        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        test.sortAscending(expected);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("checks if list is filtered by a genre")
    public void check_if_list_filters_by_genre() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = test.filterGenre(Genre.DOCUMENTARY, Movie.initializeMovies());
        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        expectedList.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        expectedList.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        expectedList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));
        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));

        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);
        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        test.sortAscending(expected);

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("checks if just the filtered list is sorted in ascending order")
    public void check_if_filtered_list_is_ascending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = test.filterGenre(Genre.DOCUMENTARY, Movie.initializeMovies());
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));
        expectedList.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        expectedList.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        expectedList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        expectedList.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));

        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks if just the filtered list is sorted in descending order")
    public void check_if_filtered_list_is_descending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = test.filterGenre(Genre.DOCUMENTARY, Movie.initializeMovies());
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortDescending(actual);

        List<Movie> expectedList = new ArrayList<>();

        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        expectedList.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        expectedList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        expectedList.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        expectedList.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));
        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks if list is sorted in ascending order")
    public void check_if_unfiltered_list_is_ascending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = Movie.initializeMovies();
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));
        expectedList.add(new Movie("Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3));
        expectedList.add(new Movie("Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3));
        expectedList.add(new Movie("Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2));
        expectedList.add(new Movie("Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5));
        expectedList.add(new Movie("Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2));
        expectedList.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        expectedList.add(new Movie("New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2));
        expectedList.add(new Movie("Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,3.7 ));
        expectedList.add(new Movie("Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3));
        expectedList.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        expectedList.add(new Movie("The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5));
        expectedList.add(new Movie("The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5));
        expectedList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        expectedList.add(new Movie("Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1));
        expectedList.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));


        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks if list is sorted in descending order")
    public void check_if_unfiltered_list_is_descending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = Movie.initializeMovies();
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortDescending(actual);

        List<Movie> expectedList = new ArrayList<>();

        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        expectedList.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        expectedList.add(new Movie("Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1));
        expectedList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        expectedList.add(new Movie("The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5));
        expectedList.add(new Movie("The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5));
        expectedList.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        expectedList.add(new Movie("Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3));
        expectedList.add(new Movie("Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,3.7 ));
        expectedList.add(new Movie("New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2));
        expectedList.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        expectedList.add(new Movie("Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2));
        expectedList.add(new Movie("Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5));
        expectedList.add(new Movie("Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2));
        expectedList.add(new Movie("Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3));
        expectedList.add(new Movie("Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3));
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));

        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("checks if initial list is sorted in ascending order")
    public void check_if_initial_list_is_ascending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        ObservableList<Movie> actual = test.getObservableMovies();

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));
        expectedList.add(new Movie("Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3));
        expectedList.add(new Movie("Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3));
        expectedList.add(new Movie("Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2));
        expectedList.add(new Movie("Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5));
        expectedList.add(new Movie("Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2));
        expectedList.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        expectedList.add(new Movie("New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2));
        expectedList.add(new Movie("Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,3.7 ));
        expectedList.add(new Movie("Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3));
        expectedList.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        expectedList.add(new Movie("The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5));
        expectedList.add(new Movie("The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5));
        expectedList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        expectedList.add(new Movie("Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1));
        expectedList.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        expectedList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));


        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Checks if the Actor playing in the most movies gets returned")
    public void check_actor_with_most_movies(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        String actual = test.getMostPopularActor(testList);
        String expected = "Louis Tomlinson";

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Check for the longest movie title")
    public void check_movie_length(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        int actual = test.getLongestMovieTitle(testList);
        int expected = 19;
        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Check for the most movies from one director")
    public void check_movies_director(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock", "Charlie Lightning"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        long actual = test.countMoviesFrom(testList,"Charlie Lightning");
        long expected = 2;
        assertEquals(expected, actual);


    }
    @Test
    @DisplayName("Check for the most movies from one director")
    public void check_movies_director_zero(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock", "Charlie Lightning"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        long actual = test.countMoviesFrom(testList,"Lewis Hamilton");
        long expected = 0;
        assertEquals(expected, actual);


    }
    @Test
    @DisplayName("Check for movies between years 1998-2002")
    public void check_movies_release_year_filter_1998_2002() {
        HomeController test = new HomeController();
        List<Movie> inList = new ArrayList<>();
        inList.add(new Movie( "All Of Those Voices", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY), 2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", "https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg", 108, 4.3));
        inList.add(new Movie( "Chabin in the forrest", List.of(Genre.BIOGRAPHY, Genre.COMEDY), 2016, "A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting", "URL10", 22, 3));
        inList.add(new Movie( "Complex Instinct", List.of(Genre.THRILLER), 2004, "A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time", "URL13", 140, 3));
        inList.add(new Movie( "Dont look down", List.of(Genre.SCIENCE_FICTION, Genre.HISTORY), 2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth", "URL12", 112, 2));
        inList.add(new Movie( "Funny Games", List.of(Genre.BIOGRAPHY, Genre.COMEDY), 2024, "Two boys visit a family and try to entertain them, based on a real event", "URL8", 129, 5));
        inList.add(new Movie( "Good Boys", List.of(Genre.ACTION, Genre.ADVENTURE), 2010, "A movie about a group of dogs, trying to be good, so they can get praise", "URL7", 155, 2.2));
        inList.add(new Movie( "Men in Black", List.of(Genre.DOCUMENTARY, Genre.DRAMA), 1999, "a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life", "URL4", 110, 2.4));
        inList.add(new Movie( "New Kids Turbo", List.of(Genre.HISTORY), 2002, "crazy people from the netherlands decide that their life needs a change", "URL3", 133, 1.2));
        inList.add(new Movie( "Saving Private Jamey Ryan", List.of(Genre.WAR), 1998, "a captain is on the search for the last surviving son of a family", "URL1", 220, 3.7));
        inList.add(new Movie( "Slow and boring", List.of(Genre.BIOGRAPHY, Genre.COMEDY), 2025, "a group of bicyclist are investigated by an undercover cop", "URL9", 111, 3));
        inList.add(new Movie( "Snow White", List.of(Genre.DOCUMENTARY), 1970, "seven dwarf rise a orphan child that they found in the woods", "URL2", 123, 2.1));
        inList.add(new Movie( "The Good, The Bad and the Beautiful", List.of(Genre.WESTERN), 1975, "A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often", "URL14", 190, 4.5));
        inList.add(new Movie( "The greatest Snowman", List.of(Genre.DRAMA, Genre.ANIMATION, Genre.MUSICAL), 2007, "a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted", "URL7", 120, 3.5));
        inList.add(new Movie( "This is us", List.of(Genre.DOCUMENTARY), 2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", "https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg", 92, 4.7));
        inList.add(new Movie( "Triathlon - the documentation", List.of(Genre.SPORT), 2009, "One of sports greatest moment as you watch a live recorded triathlon for 7 hours", "URL11", 475, 1));
        inList.add(new Movie( "We will never be royals", List.of(Genre.DOCUMENTARY, Genre.MUSICAL), 2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood", "URL5", 108, 3.4));
        inList.add(new Movie( "Wrong Direction", List.of(Genre.DOCUMENTARY, Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran", "URL6", 90, 4.5));

        List<Movie> expected = new ArrayList<>();
        expected.add(new Movie("Dont look down", List.of(Genre.SCIENCE_FICTION, Genre.HISTORY), 2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth", "URL12", 112, 2));
        expected.add(new Movie("Men in Black", List.of(Genre.DOCUMENTARY, Genre.DRAMA), 1999, "a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life", "URL4", 110, 2.4));
        expected.add(new Movie("New Kids Turbo", List.of(Genre.HISTORY), 2002, "crazy people from the netherlands decide that their life needs a change", "URL3", 133, 1.2));
        expected.add(new Movie("Saving Private Jamey Ryan", List.of(Genre.WAR), 1998, "a captain is on the search for the last surviving son of a family", "URL1", 220, 3.7));

        List<Movie> actual = test.getMoviesBetweenYears(inList,1998,2002);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Check for movies between years 1970-1975")
    public void check_movies_release_year_filter_1970_1975() {
        HomeController test = new HomeController();
        List<Movie> inList = new ArrayList<>();
        inList.add(new Movie( "All Of Those Voices", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY), 2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", "https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg", 108, 4.3));
        inList.add(new Movie( "Chabin in the forrest", List.of(Genre.BIOGRAPHY, Genre.COMEDY), 2016, "A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting", "URL10", 22, 3));
        inList.add(new Movie( "Complex Instinct", List.of(Genre.THRILLER), 2004, "A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time", "URL13", 140, 3));
        inList.add(new Movie( "Dont look down", List.of(Genre.SCIENCE_FICTION, Genre.HISTORY), 2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth", "URL12", 112, 2));
        inList.add(new Movie( "Funny Games", List.of(Genre.BIOGRAPHY, Genre.COMEDY), 2024, "Two boys visit a family and try to entertain them, based on a real event", "URL8", 129, 5));
        inList.add(new Movie( "Good Boys", List.of(Genre.ACTION, Genre.ADVENTURE), 2010, "A movie about a group of dogs, trying to be good, so they can get praise", "URL7", 155, 2.2));
        inList.add(new Movie( "Men in Black", List.of(Genre.DOCUMENTARY, Genre.DRAMA), 1999, "a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life", "URL4", 110, 2.4));
        inList.add(new Movie( "New Kids Turbo", List.of(Genre.HISTORY), 2002, "crazy people from the netherlands decide that their life needs a change", "URL3", 133, 1.2));
        inList.add(new Movie( "Saving Private Jamey Ryan", List.of(Genre.WAR), 1998, "a captain is on the search for the last surviving son of a family", "URL1", 220, 3.7));
        inList.add(new Movie( "Slow and boring", List.of(Genre.BIOGRAPHY, Genre.COMEDY), 2025, "a group of bicyclist are investigated by an undercover cop", "URL9", 111, 3));
        inList.add(new Movie( "Snow White", List.of(Genre.DOCUMENTARY), 1970, "seven dwarf rise a orphan child that they found in the woods", "URL2", 123, 2.1));
        inList.add(new Movie( "The Good, The Bad and the Beautiful", List.of(Genre.WESTERN), 1975, "A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often", "URL14", 190, 4.5));
        inList.add(new Movie( "The greatest Snowman", List.of(Genre.DRAMA, Genre.ANIMATION, Genre.MUSICAL), 2007, "a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted", "URL7", 120, 3.5));
        inList.add(new Movie( "This is us", List.of(Genre.DOCUMENTARY), 2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", "https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg", 92, 4.7));
        inList.add(new Movie( "Triathlon - the documentation", List.of(Genre.SPORT), 2009, "One of sports greatest moment as you watch a live recorded triathlon for 7 hours", "URL11", 475, 1));
        inList.add(new Movie( "We will never be royals", List.of(Genre.DOCUMENTARY, Genre.MUSICAL), 2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood", "URL5", 108, 3.4));
        inList.add(new Movie( "Wrong Direction", List.of(Genre.DOCUMENTARY, Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran", "URL6", 90, 4.5));

        List<Movie> expected = new ArrayList<>();
        expected.add(new Movie( "Snow White", List.of(Genre.DOCUMENTARY), 1970, "seven dwarf rise a orphan child that they found in the woods", "URL2", 123, 2.1));
        expected.add(new Movie( "The Good, The Bad and the Beautiful", List.of(Genre.WESTERN), 1975, "A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often", "URL14", 190, 4.5));

        List<Movie> actual = test.getMoviesBetweenYears(inList,1970,1975);

        assertEquals(expected, actual);

    }
    /*@Test
    @DisplayName("checks if a filtered list can be reverted back in its original state")
    public void check_if_filtered_list_is_unfiltered_again() {

        HomeController test = new HomeController();
        test.initializeLogic();
        //List<Movie> actualList = Movie.initializeMovies();
        List<Movie> actualList = test.getFilteredMovies(Genre.DOCUMENTARY);
        actualList = test.getFilteredMovies(null);

        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY)));
        expectedList.add(new Movie("Chabin in the forrest","A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting",List.of(Genre.FANTASY,Genre.HORROR,Genre.ROMANCE)));
        expectedList.add(new Movie("Complex Instinct","A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time",List.of(Genre.THRILLER)));
        expectedList.add(new Movie("Dont look down", "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY)));
        expectedList.add(new Movie("Funny Games","Two boys visit a family and try to entertain them, based on a real event",List.of(Genre.BIOGRAPHY,Genre.COMEDY)));
        expectedList.add(new Movie("Good Boys","A movie about a group of dogs, trying to be good, so they can get praise",List.of(Genre.ACTION,Genre.ADVENTURE)));
        expectedList.add(new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)));
        expectedList.add(new Movie("New Kids Turbo","crazy people from the netherlands decide that their life needs a change",List.of(Genre.HISTORY)));
        expectedList.add(new Movie("Saving Private Jamey Ryan", "a captain is on the search for the last surviving son of a family", List.of(Genre.WAR)));
        expectedList.add(new Movie("Slow and boring","a group of bicyclist are investigated by an undercover cop",List.of(Genre.CRIME,Genre.FAMILY)));
        expectedList.add(new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("The Good, The Bad and the Beautiful","A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often",List.of(Genre.WESTERN)));
        expectedList.add(new Movie("The greatest Snowman","a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL)));
        expectedList.add(new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("Triathlon - the documentation","One of sports greatest moment as you watch a live recorded triathlon for 7 hours",List.of(Genre.SPORT)));
        expectedList.add(new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)));
        expectedList.add(new Movie("Wrong Direction", "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran",List.of(Genre.DRAMA,Genre.MYSTERY)));

        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);
    }*/
}