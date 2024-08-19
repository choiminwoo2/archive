package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;

class TreeNode {

    int value;

    TreeNode left;

    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {

    private TreeNode root;

    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            return;
        }

        TreeNode current = root;
        if (current.value == value) {
            return;
        }
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                } else {
                    current = current.left;
                }
            } else if (value > current.value) {
                if (current.right == null) {
                    current.right = node;
                    break;
                } else {
                    current = current.right;
                }
            }
        }


    }

    public List<Integer> postOrderTrable() {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.value);
        }
    }

    public List printDFS() {
        TreeNode node = root;
        List list = new ArrayList();
        Queue queue = new LinkedList();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = (TreeNode) queue.poll();
            list.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

}

public class Gold5639 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree binaryTree = new BinaryTree();
        StringJoiner sj = new StringJoiner(",");
        String str;
        while ((str = br.readLine()) != null) {
            sj.add(str);
        }
        String[] preList = String.valueOf(sj).split(",");
        Arrays.stream(preList)
                .mapToInt(Integer::parseInt)
                .forEach(binaryTree::insert);
        List<Integer> list = binaryTree.postOrderTrable();
        list.stream().forEach(System.out::println);

        List<TreeNode> list2 = (List<TreeNode>) binaryTree.printDFS();
        list2.stream().map(obj -> obj.value)
                .forEach(System.out::println);

        binaryTree.printDFS();
        br.close();
    }
}
