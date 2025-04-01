package at.ac.fhcampuswien.fhmdb.API;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

class MovieAdapter implements JsonDeserializer<Movie> {
    @Override
    public Movie deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jo = json.getAsJsonObject();

        UUID id = UUID.fromString(jo.get("id").getAsString());

        String title = jo.get("title").getAsString();
        String description = jo.get("description").getAsString();
        String imgURL = jo.get("imgUrl").getAsString();

        List<Genre> genres = context.deserialize(jo.get("genres"), List.class);

        List<String> mainCast = context.deserialize(jo.get("mainCast"), List.class);
        List<String> writers = context.deserialize(jo.get("writers"), List.class);
        List<String> directors = context.deserialize(jo.get("directors"), List.class);

        int releaseYear = jo.get("releaseYear").getAsInt();
        int lengthInMinutes = jo.get("lengthInMinutes").getAsInt();
        double rating = jo.get("rating").getAsDouble();




        return new Movie(
                id,
                title,
                genres,
                releaseYear,
                description,
                imgURL,
                lengthInMinutes,
                directors,
                writers,
                mainCast,
                rating);
    }
}
