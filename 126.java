import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
            HashSet<String> dict) {
        // Construct a graph of words.
        // NOTE: naive O(n^2) construction will get a TLE.
        dict.add(start);
        dict.add(end);
        ArrayList<String> words = new ArrayList<String>(dict);
        ArrayList<ArrayList<Integer>> wordNeighbors =
            new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < words.size(); i++) {
            wordNeighbors.add(new ArrayList<Integer>());
        }
        HashMap<String, ArrayList<Integer>> groups =
            new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.size(); i++) {
            char[] word = words.get(i).toCharArray();
            for (int j = 0; j < word.length; j++) {
                char old = word[j];
                word[j] = '#';
                String flag = String.valueOf(word);
                ArrayList<Integer> group;
                if ((group = groups.get(flag)) != null) {
                    for (int k : group) {
                        wordNeighbors.get(i).add(k);
                        wordNeighbors.get(k).add(i);
                    }
                    group.add(i);
                } else {
                    group = new ArrayList<Integer>();
                    group.add(i);
                    groups.put(flag, group);
                }
                word[j] = old;
            }
        }
        // BFS to color the shortest paths.
        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(start)) startIndex = i;
            if (words.get(i).equals(end)) endIndex = i;
        }
        int[] dis = getShortestDistances(wordNeighbors, startIndex,
                endIndex);
        // DFS to find all paths.
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        path.add(start);
        findPaths(words, startIndex, endIndex, dis, wordNeighbors, path, paths);
        return paths;
    }

    private void findPaths(ArrayList<String> words, int pos, int endPos,
            int[] dis, ArrayList<ArrayList<Integer>> wordNeighbors,
            ArrayList<String> path, ArrayList<ArrayList<String>> paths) {
        if (pos == endPos) {
            paths.add(new ArrayList<String>(path));
            return;
        }
        for (int neighbor : wordNeighbors.get(pos)) {
            if (dis[neighbor] == dis[pos] - 1) {
                path.add(words.get(neighbor));
                findPaths(words, neighbor, endPos, dis, wordNeighbors, path,
                        paths);
                path.remove(path.size() - 1);
            }
        }
    }

    private int[] getShortestDistances(
            ArrayList<ArrayList<Integer>> wordNeighbors, int start, int end) {
        int[] dis = new int[wordNeighbors.size()];
        for (int i = 0; i < dis.length; i++) dis[i] = -1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(end);
        dis[end] = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            for (int neighbor : wordNeighbors.get(head)) {
                if (dis[neighbor] == -1) {
                    dis[neighbor] = dis[head] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dis;
    }

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("input"));
        String start = scan.nextLine();
        String end = scan.nextLine();
        HashSet<String> dict = new HashSet<String>();
        while (scan.hasNextLine()) {
            dict.add(scan.nextLine());
        }
        new Solution().findLadders(start, end, dict);
    }
}
