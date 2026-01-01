import java.util.*;

class State {
    int sheep;
    int wolf;
    List<Integer> nextNodes;
    
    public State(int sheep, int wolf, List<Integer> nextNodes) {
        this.sheep = sheep;
        this.wolf = wolf;
        this.nextNodes = nextNodes;
    }
}

class Solution {
    public List<Integer>[] adjList;
    
    public int solution(int[] info, int[][] edges) {
        makeTree(info.length, edges);
        
        return bfs(info);
    }
    
    public void makeTree(int infoLength, int[][] edges) {
        adjList = new ArrayList[infoLength];
        
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
        }
    }
    
    public int bfs(int[] info) {
        Deque<State> queue = new ArrayDeque<>();
        queue.addLast(new State(1, 0, new ArrayList<>(adjList[0])));

        int maxSheepCount = 0;
        
        while (!queue.isEmpty()) {
            State poll = queue.pollFirst();
            maxSheepCount = Math.max(maxSheepCount, poll.sheep);
            
            List<Integer> pollNextNodes = poll.nextNodes;
            for (int i = 0; i < pollNextNodes.size(); i++) {
                int nextNode = pollNextNodes.get(i);
                
                int nextSheep = poll.sheep + (info[nextNode] == 0 ? 1 : 0);
                int nextWolf = poll.wolf + (info[nextNode] == 1 ? 1 : 0);
                
                if (nextSheep > nextWolf) {
                    List<Integer> copy = new ArrayList<>(pollNextNodes);
                    copy.remove(i);
                    copy.addAll(adjList[nextNode]);
                    
                    queue.addLast(new State(nextSheep, nextWolf, copy));
                }
            }
        }
        
        return maxSheepCount;
    }
}