import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlayMap = new HashMap<>();
        Map<String, ArrayList<Music>> genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            totalPlayMap.put(genre, 
                           totalPlayMap.getOrDefault(genre, 0) + playCount);
            
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
            }
            genreMap.get(genre).add(new Music(i, playCount));
        }
        
        List<String> sortedGenreList = new ArrayList<>(totalPlayMap.keySet());
        sortedGenreList.sort((genre1, genre2) -> 
                             totalPlayMap.get(genre2) - totalPlayMap.get(genre1));
        
        List<Integer> resultList = new ArrayList<>();
        for (String genre : sortedGenreList) {
            List<Music> musicList = genreMap.get(genre);
            musicList.sort((m1, m2) -> {
                if (m1.playCount == m2.playCount) {
                    return m1.id - m2.id;
                }
                
                return m2.playCount - m1.playCount;
            });
            
            resultList.add(musicList.get(0).id);
            if (musicList.size() > 1) {
                resultList.add(musicList.get(1).id);
            }
        }
        
        return resultList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

class Music {
    int id;
    int playCount;
    
    public Music(int id, int playCount) {
        this.id = id;
        this.playCount = playCount;
    }
}