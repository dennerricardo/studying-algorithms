package dev.musicranker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MusicRanker {
    public static void main(String[] args) {
        List<Artist> originalList = new ArrayList<>();
        originalList.add(new Artist("Iron Maiden", 10200));
        originalList.add(new Artist("Metallica", 53423));
        originalList.add(new Artist("Nirvana", 12323));
        originalList.add(new Artist("Pantera", 55463));
        originalList.add(new Artist("Slipknot", 59328));
        originalList.add(new Artist("System of a down", 35422));

        List<Artist> sortedList = originalList.stream()
                .sorted(Comparator.comparingInt((Artist :: getPlays)).reversed()).collect(Collectors.toList());

        System.out.println("----Top Artists----");
        for(Artist a : sortedList){
            System.out.println(a);

        }
    }
}
