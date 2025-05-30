package at.ac.fhcampuswien.fhmdb.API;

import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class MovieAPI {
    final OkHttpClient client = new OkHttpClient();
    final private String FHurl = "https://prog2.fh-campuswien.ac.at/";



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

    public ArrayList<MovieEntity> getMovies(String query, String genre, int releaseYear, double ratingFrom) throws MovieApiException{
        String base = FHurl + "movies";

        String fullURL = new MovieAPIRequestBuilder(base)
                            .setQuery(query)
                            .setGenre(genre)
                            .setReleaseYear(releaseYear)
                            .setRatingFrom(ratingFrom)
                            .build();

        System.out.println(fullURL);


        try {
            String moviesAsString = run(fullURL);

            Type listType = new TypeToken<ArrayList<MovieEntity>>(){}.getType();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(MovieEntity.class, new MovieAdapter())
                    .create();
            return gson.fromJson(moviesAsString, listType);
        } catch (IOException e) {
            throw new MovieApiException(e.getMessage());
        }


    }

}
