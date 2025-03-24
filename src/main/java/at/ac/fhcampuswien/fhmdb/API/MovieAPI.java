package at.ac.fhcampuswien.fhmdb.API;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import okhttp3.*;
import java.io.IOException;




public class MovieAPI {
    final OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        MovieAPI example = new MovieAPI();
        String response = example.run("https://google.com");
        System.out.println(response);
    }
}
