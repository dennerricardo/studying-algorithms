package dev.musicranker;

public class Artist {
    private String name;
    private int plays;

    public Artist(String name, int plays){
        this.name = name;
        this.plays = plays;
    }

    public int getPlays() {
        return plays;
    }

    @Override
    public String toString() {
        return name + " ("+ plays + " plays)";
    }

}
