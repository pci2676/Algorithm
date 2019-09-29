package programers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genre = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution.solution(genre, plays)));
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, List<Album>> albums = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Album album = new Album(i, genre, plays[i]);
            List<Album> albumList = albums.getOrDefault(genre, new ArrayList<>());
            albumList.add(album);
            Collections.sort(albumList);
            albums.put(genre, albumList);
        }

        List<AlbumBundle> albumBundles = new ArrayList<>();
        for (List<Album> albumList : albums.values()) {
            AlbumBundle albumBundle = new AlbumBundle(albumList);
            albumBundles.add(albumBundle);
        }

        Collections.sort(albumBundles);

        List<Integer> answers = new ArrayList<>();
        for (AlbumBundle albumBundle : albumBundles) {
            answers.addAll(albumBundle.getIndexList());
        }

        answer = answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}

class Album implements Comparable<Album> {
    private Integer index;
    private String genre;
    private Integer plays;

    public Album(Integer index, String genre, Integer plays) {
        this.index = index;
        this.genre = genre;
        this.plays = plays;
    }

    public Integer getPlays() {
        return plays;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public int compareTo(Album album) {
        if (this.plays > album.plays) {
            return -1;
        }
        if (this.plays < album.plays) {
            return 1;
        }
        if (this.index > album.index) {
            return 1;
        }
        if (this.index < album.index) {
            return -1;
        }
        return 0;
    }

}

class AlbumBundle implements Comparable<AlbumBundle> {

    private List<Album> albums;
    private Integer totalPlays;

    public AlbumBundle(List<Album> albums) {
        this.albums = albums;
        this.totalPlays = albums.stream()
                .mapToInt(Album::getPlays)
                .sum();
    }

    public List<Integer> getIndexList() {
        List<Integer> bestIndex = new ArrayList<>();

        for (int i = 0; i < albums.size() && i < 2; i++) {
            bestIndex.add(albums.get(i).getIndex());
        }

        return bestIndex;
    }

    @Override
    public int compareTo(AlbumBundle albumBundle) {
        return albumBundle.totalPlays.compareTo(this.totalPlays);
    }

}
