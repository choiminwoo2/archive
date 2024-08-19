package study.binaryTree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(15);
        binaryTree.insert(14);
        binaryTree.insert(25);

        //          9
        //      7      15
        //  6     8   14  25

        binaryTree.selectOrderTravle(OrderMode.IN_ORDER);
        System.out.println();
        binaryTree.selectOrderTravle(OrderMode.PRE_ORDER);
    }
}
