import java.util.*;

class Solution {
    //장르별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시
    private static class Genre implements Comparable<Genre> {
        public String title;
        public int count;

        public Genre(String title, int count) {
            this.title = title;
            this.count = count;
        }

        @Override
        public int compareTo(Genre o) {
            return o.count - count;
        }
    }

    private static class Music implements Comparable<Music> {
        public int seq;
        public int count;

        public Music(int seq, int count) {
            this.seq = seq;
            this.count = count;
        }

        @Override
        public int compareTo(Music o) {
            if (o.count == count) {
                return seq - o.seq;
            }
            return o.count - count;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Music>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int count = total.getOrDefault(genres[i], 0);
            total.put(genres[i], count + plays[i]);
            map.putIfAbsent(genres[i], new ArrayList<>());
            List<Music> music = map.get(genres[i]);
            music.add(new Music(i, plays[i]));
            map.put(genres[i], music);
        }

        List<Genre> temp = new ArrayList<>();
        for (String genre : total.keySet()) {
            temp.add(new Genre(genre, total.get(genre)));
        }
        Collections.sort(temp);

        List<Integer> result = new ArrayList<>();
        for (Genre genre : temp) {
            List<Music> music = map.get(genre.title);
            if (music.size() < 2) {
                result.add(music.get(0).seq);
                continue;
            }
            
            Collections.sort(music);
            for (int i = 0; i < 2; i++) {
                result.add(music.get(i).seq);
            }
        }

        return result.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}