package at.ac.fhcampuswien.fhmdb.API;

import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
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

    public ArrayList<MovieEntity> getMovies() throws IOException {
        String subUrl = FHurl + "movies";
        System.out.println(subUrl);

        String moviesAsString = run(subUrl);

        //Tokenizes the typeToken so we have a specific listType for the api

        Type listType = new TypeToken<ArrayList<MovieEntity>>(){}.getType();
        return gson.fromJson(moviesAsString, listType);
    }

    public ArrayList<MovieEntity> getMovies(String query, String genre, int releaseYear, double ratingFrom) throws IOException {
        String subUrl = FHurl + "movies";

        HttpUrl.Builder urlBuilder = HttpUrl.parse(subUrl).newBuilder();


        if(query != "" && query != null) {urlBuilder.addQueryParameter("query", query);}
        if(genre != "" && genre != null) {urlBuilder.addQueryParameter("genre", genre);}
        if(releaseYear != 0) {urlBuilder.addQueryParameter("releaseYear", String.valueOf(releaseYear));}
        if(ratingFrom != 0) {urlBuilder.addQueryParameter("ratingFrom", String.valueOf(ratingFrom));}


        System.out.println(urlBuilder.build());


        String moviesAsString = run(urlBuilder.build().toString());

        //Tokenizes the typeToken so we have a specific listType for the api

        Type listType = new TypeToken<ArrayList<MovieEntity>>(){}.getType();
        return gson.fromJson(moviesAsString, listType);
    }


    public Movie getMovie(UUID uuid) throws IOException {
        String subUrl = FHurl + "movies/" + uuid;
        System.out.println(subUrl);

        String movieAsString = run(subUrl);

        return gson.fromJson(movieAsString, Movie.class);
    }
}
