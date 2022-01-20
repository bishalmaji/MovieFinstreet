package com.finstreet.moviefinstreet.model;

import java.util.ArrayList;

public class Show {
    public int id;
    public String url;
    public String name;
    public String type;
    public String language;
    public ArrayList<String> genres;
    public String status;
    public int runtime;
    public int averageRuntime;
    public String premiered;
    public String ended;
    public String officialSite;
    public Schedule schedule;
    public Rating rating;
    public int weight;
    public Network network;
    public WebChannel webChannel;
    public Object dvdCountry;
    public Externals externals;
    public Image image;
    public String summary;
    public int updated;
    public Links _links;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getAverageRuntime() {
        return averageRuntime;
    }

    public void setAverageRuntime(int averageRuntime) {
        this.averageRuntime = averageRuntime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public WebChannel getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(WebChannel webChannel) {
        this.webChannel = webChannel;
    }

    public Object getDvdCountry() {
        return dvdCountry;
    }

    public void setDvdCountry(Object dvdCountry) {
        this.dvdCountry = dvdCountry;
    }

    public Externals getExternals() {
        return externals;
    }

    public void setExternals(Externals externals) {
        this.externals = externals;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public Show(int id, String url, String name, String type, String language, ArrayList<String> genres, String status, int runtime, int averageRuntime, String premiered, String ended, String officialSite, Schedule schedule, Rating rating, int weight, Network network, WebChannel webChannel, Object dvdCountry, Externals externals, Image image, String summary, int updated, Links _links) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.type = type;
        this.language = language;
        this.genres = genres;
        this.status = status;
        this.runtime = runtime;
        this.averageRuntime = averageRuntime;
        this.premiered = premiered;
        this.ended = ended;
        this.officialSite = officialSite;
        this.schedule = schedule;
        this.rating = rating;
        this.weight = weight;
        this.network = network;
        this.webChannel = webChannel;
        this.dvdCountry = dvdCountry;
        this.externals = externals;
        this.image = image;
        this.summary = summary;
        this.updated = updated;
        this._links = _links;
    }
}
