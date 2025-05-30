package at.ac.fhcampuswien.fhmdb.API;

import okhttp3.HttpUrl;

public class MovieAPIRequestBuilder {
    private final String base;
    private String query;
    private String genre;
    private int releaseYear;
    private double ratingFrom;

    public MovieAPIRequestBuilder(String baseURL) {
        base =baseURL;
    }

    public MovieAPIRequestBuilder setQuery(String query) {
        this.query = query;
        return this;
    }

    public MovieAPIRequestBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public MovieAPIRequestBuilder setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public MovieAPIRequestBuilder setRatingFrom(double ratingFrom) {
        this.ratingFrom =ratingFrom;
        return this;
    }

    public String build() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(base).newBuilder();

        if (query != null && !query.isEmpty()) {
            urlBuilder.addQueryParameter("query", query);
        }

        if (genre != null && !genre.isEmpty()) {
            urlBuilder.addQueryParameter("genre", genre);
        }

        if (releaseYear != 0) {
            urlBuilder.addQueryParameter("releaseYear", String.valueOf(releaseYear));
        }

        if (ratingFrom != 0) {
            urlBuilder.addQueryParameter("ratingFrom", String.valueOf(ratingFrom));
        }

        return urlBuilder.build().toString();
    }
}
