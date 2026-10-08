
import java.util.*;

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Create adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // Visited array
        boolean[] visited = new boolean[n];

        // Start DFS
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int current, int destination,
                        ArrayList<Integer>[] graph,
                        boolean[] visited) {

        // Destination reached
        if (current == destination) {
            return true;
        }

        visited[current] = true;

        // Visit all connected vertices
        for (int next : graph[current]) {

            if (!visited[next]) {

                if (dfs(next, destination, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

