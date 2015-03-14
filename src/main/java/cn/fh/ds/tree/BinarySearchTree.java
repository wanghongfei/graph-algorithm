package cn.fh.ds.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;


    /**
     * 向树中插入一个值
     */
    public void put(T elem) {
        root = doPut(elem, root);
    }

    /**
     * 判断指定值是否在树中
     */
    public boolean contains(T target) {
        return doContain(target, root);
    }

    /**
     * 得到树中的最小值
     */
    public T getMin() {
        return doGetMin(root);
    }

    /**
     * 得到树中最大值
     */
    public T getMax() {
        return root.elem;
    }

    private T doGetMin(Node node) {
        if (null == node.left) {
            return node.elem;
        }

        return doGetMin(node.left);
    }

    private boolean doContain(T target, Node node) {
        if (null == node) {
            return false;
        }

        int comp = target.compareTo(node.elem);
        // 要查找的元素大，在右子树中查找
        if (comp > 0) {
            return doContain(target, node.right);
        } else if (comp < 0) {
            // 要查找的元素小，在左子树中查找
            return doContain(target, node.left);
        } else {
            return true;
        }
    }

    private Node doPut(T elem, Node node) {
        if (null == node) {
            return new Node(elem, null, null);
        }

        int comp = elem.compareTo(node.elem);
        // 要插入的元素大,放在右子树中
        if (comp > 0) {
            node.right = doPut(elem, node.right);
        } else if (comp < 0) {
            // 要插入的元素小,放在左子树中
            node.left = doPut(elem, node.left);
        } else {
            node.elem = elem;
        }

        return node;
    }



    private class Node {
        public Node(T elem, Node left, Node right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        public T elem;
        public Node left;
        public Node right;
    }
}
