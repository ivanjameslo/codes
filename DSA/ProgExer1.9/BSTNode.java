<<<<<<< HEAD
public class BSTNode {
    protected Software key;
    protected BSTNode left, right;

    public BSTNode() {
        left = right = null;
    }

    public BSTNode(Software el) {
        this(el, null, null);
    }

    public BSTNode(Software el, BSTNode lt, BSTNode rt) {
        key = el;
        left = lt;
        right = rt;
    }
=======
public class BSTNode {
    protected Software key;
    protected BSTNode left, right;

    public BSTNode() {
        left = right = null;
    }

    public BSTNode(Software el) {
        this(el, null, null);
    }

    public BSTNode(Software el, BSTNode lt, BSTNode rt) {
        key = el;
        left = lt;
        right = rt;
    }
>>>>>>> 640518d71f8ad12f15192c81df513d89b2ad0e90
}