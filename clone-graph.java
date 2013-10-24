/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        nodeMap = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (nodeMap.containsKey(node.label)) return nodeMap.get(node.label);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        nodeMap.put(node.label, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (neighbor.label == node.label) {
                copy.neighbors.add(copy);
            } else {
                UndirectedGraphNode neighborCopy = clone(neighbor);
                copy.neighbors.add(neighborCopy);
            }
        }
        return copy;
    }
    
    Map<Integer, UndirectedGraphNode> nodeMap;
}
