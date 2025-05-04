package at.ac.fhcampuswien.fhmdb.API;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

class MovieAdapter implements JsonDeserializer<MovieEntity> {
    @Override
    public MovieEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jo = json.getAsJsonObject();

        String apiId = jo.get("id").getAsString();

        String title = jo.get("title").getAsString();
        String description = jo.get("description").getAsString();
        String imgURL = jo.get("imgUrl").getAsString();

        List<Genre> genresAsGenre = context.deserialize(jo.get("genres"), new TypeToken<List<Genre>>() {}.getType());
        String genres = genresAsGenre.stream()
                .map(Genre::toString)
                .collect(Collectors.joining(", "));

        int releaseYear = jo.get("releaseYear").getAsInt();
        int lengthInMinutes = jo.get("lengthInMinutes").getAsInt();
        double rating = jo.get("rating").getAsDouble();

        return new MovieEntity(
                apiId,
                title,
                description,
                genres,
                releaseYear,
                imgURL,
                lengthInMinutes,
                rating);
    }
}
