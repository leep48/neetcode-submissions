/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // start at node, then for each neighbor, explore those nodes
        // stop recursive path if hash map contains already seen non-sealed
        HashMap<Node, Node> seen = new HashMap<>();
        
        return dfs(node, seen);
    }

    private Node dfs(Node node, HashMap<Node, Node> seen) {
        if (node == null) {
            return null;
        }

        if (seen.containsKey(node)) {
            return seen.get(node);
        }

        Node copy = new Node(node.val);
        seen.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(n, seen));
        }

        return copy;
    }
}