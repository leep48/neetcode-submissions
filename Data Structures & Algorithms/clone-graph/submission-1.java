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
        HashMap<Node, Node> oldNew = new HashMap<>();

        return dfs(node, oldNew);
    }

    private Node dfs(Node node, HashMap<Node, Node> oldNew) {
        if (node == null) {
            return null;
        }

        if (oldNew.containsKey(node)) {
            return oldNew.get(node);
        }

        Node copy = new Node(node.val);
        oldNew.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(n, oldNew));
        }

        return copy;
    }
}