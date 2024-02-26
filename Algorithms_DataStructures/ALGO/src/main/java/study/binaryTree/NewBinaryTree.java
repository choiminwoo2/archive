package study.binaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NewBinaryTree {

    Node root;

    public NewBinaryTree() {
        this.root = null;
    }

    public Node getRootNode() {
        return this.root;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = newNode;
            if (current.getValue() == value) {
                throw new IllegalArgumentException("같은 수 입니다.");
            }
            while (true) {
                if (value < current.getValue()) {
                    if (current.getLeft() == null) {
                        current.setLeft(current);
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else if (value > current.getValue()) {
                    if (current.getRight() == null) {
                        current.setRight(current);
                        break;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }

    void preOrders(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrders(node.getLeft());
            preOrders(node.getRight());
        }
    }

    List bfs(Node node) {
        Queue queue = new LinkedList();
        List list = new ArrayList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = (Node) queue.poll();
            list.add(current);
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return list;
    }
}
