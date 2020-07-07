

public class Node {
    public Document val;
    public Node left;
    public Node right;
    public int ht;

    public Node(Document value) {
        this.val = value;
        this.left = null;
        this.right = null;
        this.ht = 0;
    }
}
