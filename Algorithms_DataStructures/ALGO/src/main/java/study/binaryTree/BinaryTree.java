package study.binaryTree;

enum OrderMode {
    PRE_ORDER, IN_ORDER, POST_ORDER;
}

public class BinaryTree {

    private Node rootNode;

    public void insert(int value) {

        Node node = new Node(value);
        if (rootNode == null) {
            rootNode = node;
            return;
        }
        Node current = rootNode;
        while (true) {
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    break;
                } else {
                    current = current.getLeft();
                }
            } else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(node);
                    break;
                } else {
                    current = current.getRight();
                }
            } else {
                break;
            }
        }

    }

    public void insert2(int value) {

        Node node = new Node(value);

        if (rootNode == null) {
            rootNode = node;
            return;
        }
        Node current = rootNode;
        while (true) {
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                } else {
                    current = current.getLeft();
                }
            } else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(node);
                } else {
                    current = current.getRight();
                }
            } else {
                break;
            }
        }
    }

    public void selectOrderTravle(OrderMode mode) {

        switch (mode) {
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
        }
    }

    // 전위 순회 => root -> left -> right 순서
    private void preOrder(Node node) {

        if (node != null) {
            System.out.print(node.getValue() + "\t");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    // 중위 순회 왼 -> 루트 -> 오른쪽 노드 순
    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + "\t");
            inOrder(node.getRight());
        }
    }

    //후위 순회 왼 -> 오 -> 루 순
    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + "\t");
        }
    }
}
