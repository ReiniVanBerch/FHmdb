package at.ac.fhcampuswien.fhmdb.API;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;


public class MovieAPI {
    final OkHttpClient client = new OkHttpClient();
    final private String FHurl = "https://prog2.fh-campuswien.ac.at/";

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Movie.class, new MovieAdapter())  // Use the custom adapter
            .create();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .addHeader("User-Agent", "http.agent")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public ArrayList<Movie> getMovies() throws IOException {
        String subUrl = FHurl + "movies";
        System.out.println(subUrl);

        String moviesAsString = run(subUrl);

        //Tokenizes the typeToken so we have a specific listType for the api

        Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
        return gson.fromJson(moviesAsString, listType);
    }

    public ArrayList<Movie> getMovies(String query, String genre, int releaseYear, double ratingFrom) throws IOException {
        String subUrl = FHurl + "movies";

        if(query != "" || genre != null || releaseYear != 0 || ratingFrom != 0) {
            subUrl += "?";
            if(query != "") {subUrl += "query=" + query + "&";}
            if(genre != null) {subUrl += "genre=" + genre + "&";}
            if(releaseYear != 0) {subUrl += "releaseYear=" + releaseYear + "&";}
            if(ratingFrom != 0) {subUrl += "rating=" + ratingFrom + "&";}
            subUrl = subUrl.substring(0, subUrl.length()-1);
        }

        System.out.println(subUrl);


        String moviesAsString = run(subUrl);

        //Tokenizes the typeToken so we have a specific listType for the api

        Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
        return gson.fromJson(moviesAsString, listType);
    }


    public Movie getMovie(UUID uuid) throws IOException {
        String subUrl = FHurl + "movies/" + uuid;
        System.out.println(subUrl);

        String movieAsString = run(subUrl);

        return gson.fromJson(movieAsString, Movie.class);
    }


    public static void main(String[] args) throws IOException {
        MovieAPI example = new MovieAPI();

        //UUID uuid = UUID.fromString("81d317b0-29e5-4846-97a6-43c07f3edf4a");
        //String response = example.getMovie(uuid);
        //String response = example.getMovies().get(0).toString();

        String response = example.getMovies("d", null, 1994, 0).get(0).toString();

        System.out.println(response);
    }
}
