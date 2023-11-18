public class BST {

    protected BSTNode root;

    public BST() {
        root = null;
    }

    public Boolean searchName(String el) {
        return searchName(root, el);
    }

    protected Boolean searchName(BSTNode p, String el) {
        while (p != null) {
            if (el.compareToIgnoreCase(p.key.getSoftwareName()) == 0){
                return true;
            }
            else if (el.compareToIgnoreCase(p.key.getSoftwareName()) < 0) {
                p = p.left;
            } 
            else if (el.compareToIgnoreCase(p.key.getSoftwareName()) > 0) {
                p = p.right;
            }
        }
        return false;
    }

    public Boolean searchVersion(String s) {
        return searchVersion(root, s);
    }

    protected Boolean searchVersion(BSTNode p, String s) {
        while (p != null){
            if (s.compareToIgnoreCase(p.key.getSoftwareVersion()) == 0){
                return true;
            }
            else if (s.compareToIgnoreCase(p.key.getSoftwareVersion()) < 0) {
                p = p.left;
            } 
            else if (s.compareToIgnoreCase(p.key.getSoftwareVersion()) > 0) {
                p = p.right;
            }
        }
        return false;
    }

    public void selected(String el, int q){
        selected(root, el, q);
    }

    public void selected(BSTNode p, String el, int q) { // Figure 6.9
        while (p != null)
        if (el.compareToIgnoreCase(p.key.getSoftwareName()) == 0){
                System.out.println(String.format("%-30s %-10s %-10d %-10.2f", p.key.getSoftwareName(), p.key.getSoftwareVersion(), p.key.getQuantity(), p.key.getPrice()));
                break;
        }
        else if (el.compareToIgnoreCase(p.key.getSoftwareName()) < 0){
            p = p.left;
        }
        else if (el.compareToIgnoreCase(p.key.getSoftwareName()) > 0) {
            p = p.right;
        }
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(BSTNode p) {
        if (p != null) {
            inorder(p.left);
            System.out.printf(String.format("%-30s %-10s %-10d %.2f \n", p.key.getSoftwareName(), p.key.getSoftwareVersion(), p.key.getQuantity(), p.key.getPrice()));
            inorder(p.right);
        }
    } // Figure 6.11

    public void insert(Software el) {
        BSTNode p = root, prev = null;
        while (p != null) { // find a place for inserting new node;
            prev = p;
            if (p.key.getSoftwareName().compareToIgnoreCase(el.getSoftwareName()) < 0)
                p = p.right;
            else
                p = p.left;
        }
        if (root == null) // tree is empty;
            root = new BSTNode(el);
        else if (prev.key.getSoftwareName().compareToIgnoreCase(el.getSoftwareName()) < 0)
            prev.right = new BSTNode(el);
        else
            prev.left = new BSTNode(el);
    } // Figure 6.23

    public void deleteByMerging(Software el) {
        BSTNode tmp, node, p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p; // with element el;
            if (p.key.getSoftwareName().compareToIgnoreCase(el.getSoftwareName()) < 0)
                p = p.right;
            else
                p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child: its left
                node = node.left; // child (if any) is attached to its
            // parent;
            else if (node.left == null) // node has no left child: its right
                node = node.right; // child is attached to its parent;
            else { // be ready for merging subtrees;
                tmp = node.left; // 1. move left
                while (tmp.right != null) // 2. and then right as far as
                    tmp = tmp.right; // possible;
                tmp.right = // 3. establish the link between
                        node.right; // the rightmost node of the left
                // subtree and the right subtree;
                node = node.left; // 4 }
            }

            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else
                prev.right = node; // 5.
        } else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else
            System.out.println("the tree is empty");
    } // Figure 6.29
}