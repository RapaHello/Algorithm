import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {   
        Map<String, Integer> playerMap = new HashMap<>();
        if (players.length > 4) {
            for (int i = 0; i < players.length; i++) {
                playerMap.put(players[i], i);
            }
        }

        if (callings.length > 1) {
            for (String call : callings) {
                Integer idx = playerMap.get(call);
                if (idx != null && idx > 0) {
                    players[idx] = players[idx - 1];
                    players[idx - 1] = call;
                }

                playerMap.put(players[idx], idx);
                playerMap.put(players[idx - 1], idx - 1);
            }
        }
        
        return players;
    }
}
