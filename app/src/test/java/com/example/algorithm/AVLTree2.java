package com.example.algorithm;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 4/19/21 3:17 PM
 */

class AVLTree2<E extends Comparable<E>> {

    public TreeNode<E> root;

    public static final int LH = 1;
    public static final int EH = 0;
    public static final int RH = -1;



    private void leftRotate(TreeNode<E> x) {

        if (x == null) return;

        TreeNode<E> y = x.right;

        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;

        // 根据情况来决定是放在parent的左边还是右边
        if (x.parent == null) {
            root = y;
        } else if (x.parent.left == x) {
            x.parent.left = y;
        } else if (x.parent.right == x) {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(TreeNode<E> y) {

        if (y == null) return;

        TreeNode<E> x = y.left;

        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;

        // 根据情况来决定是放在parent的左边还是右边
        if (y.parent == null) {
            root = x;
        } else if (y.parent.left == y) {
            y.parent.left = x;
        } else if (y.parent.right == y) {
            y.parent.right = x;
        }

        x.right = y;
        y.parent = x;

    }

    private void leftBalance(TreeNode<E> t) {
        TreeNode<E> tl = t.left;
        switch (tl.balance) {

            case LH:
                // 左边高 直接右旋
                rightRotate(t);

                // 平衡因子修正
                t.balance = EH;
                tl.balance = EH;

                break;

            case RH:
                // 先左旋后右旋

                TreeNode<E> tlr  = tl.right;

                switch (tlr.balance) {

                    case LH:
                        t.balance = RH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;

                    case RH:
                        t.balance = EH;
                        tl.balance = LH;
                        tlr.balance = EH;
                        break;

                    case EH:
                        break;
                }
                leftRotate(tl);
                rightRotate(t);
                break;
        }

    }

    private void rightBalance(TreeNode<E> t) {

        TreeNode<E> tr = t.right;
        switch (tr.balance) {

            case RH:
                // 左边高 直接右旋
                leftRotate(t);

                // 平衡因子修正
                t.balance = EH;
                tr.balance = EH;

                break;

            case LH:
                // 先右旋后左旋

                TreeNode<E> trl  = tr.left;

                switch (trl.balance) {

                    case LH:
                        t.balance = LH;
                        tr.balance = EH;
                        trl.balance = EH;
                        break;

                    case RH:
                        t.balance = EH;
                        tr.balance = RH;
                        trl.balance = EH;
                        break;

                    case EH:
                        break;
                }
                rightRotate(tr);
                leftRotate(t);
                break;
        }
    }

    public boolean insertElement(E data) {

        TreeNode<E> t = root;
        if (t == null) {
            root = new TreeNode<>(data);
            size++;
            return true;
        }
        // 遍历找到需要插入的父节点

        int cmp;
        TreeNode<E> parent;
        Comparable<? super E> e = data;
        do {
            parent = t;
            cmp = e.compareTo(t.data);
            if (cmp > 0) {
                t = t.right;
            } else if (cmp < 0) {
                t = t.left;
            } else {
                return false;
            }

        } while (t != null);

        // 找到父节点后进行插入
        TreeNode<E> newNode = new TreeNode<>(data);
        newNode.parent = parent;
        if (cmp > 0) {
            parent.right = newNode;

        } else {
            parent.left = newNode;
        }
        // 进行平衡操作
        // 回溯找到失衡点
        while (parent != null) {
            cmp = e.compareTo(parent.data);
            if (cmp > 0) {
                parent.balance--;
            } else if (cmp < 0) {
                parent.balance++;
            }
            if (parent.balance == 0) {
                break;
            }

            if (Math.abs(parent.balance) == 2) {
                fixAfterInsertion(parent);
                break;
            } else {
                parent = parent.parent;
            }
        }
        size++;
        return true;

    }

    private void fixAfterInsertion(TreeNode<E> root) {
        if (root.balance == 2) {
            leftBalance(root);
        }

        if (root.balance == -2) {
            rightBalance(root);
        }
    }

    private int size;


//    public static class TreeNode<E extends Comparable<E>> {
//
//        public TreeNode<E> left;
//        public Node<E> right;
//        public Node<E> parent;
//
//        public E data;
//        public int balance;
//
//        public Node(E data) {
//            this.data = data;
//        }
//
//    }
}
