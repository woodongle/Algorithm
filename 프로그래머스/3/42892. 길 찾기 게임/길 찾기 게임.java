import java.util.*;

class Node {
    int num, x, y;
    Node left, right;
    
    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    private List<Node> nodes;
    
    public int[][] solution(int[][] nodeinfo) {
        makeTree(nodeinfo);
        
        List<Integer> preOrderList = new ArrayList<>();
        preOrder(nodes.get(0), preOrderList);
        List<Integer> postOrderList = new ArrayList<>();
        postOrder(nodes.get(0), postOrderList);
        
        int[][] answer = new int[2][nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }
        
        return answer;
    }
    
    public void makeTree(int[][] nodeinfo) {
        nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        nodes.sort((node1, node2) -> {
            if (node1.y != node2.y) {
                return node2.y - node1.y;
            }
            
            return node1.x - node2.x;
        });
        
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            Node parentNode = root;
            
            while (true) {
                Node currentNode = nodes.get(i);
                
                if (parentNode.x > currentNode.x) {
                    if (parentNode.left == null) {
                        parentNode.left = currentNode;
                        break;
                    }
                    
                    parentNode = parentNode.left;
                } else {
                    if (parentNode.right == null) {
                        parentNode.right = currentNode;
                        break;
                    }
                    
                    parentNode = parentNode.right;
                }
            }
        }
    }
    
    public void preOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        list.add(node.num);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
    
    public void postOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.num);
    }
}