public class MyNode {

    public int key;
    public char data;
    public MyNode leftChild;
    public MyNode rightChild;
    public MyNode parent;

    public MyNode() {}

    public MyNode(int key, char data) {
        this.key = key;
        this.data = data;
    }

    public MyNode(int key, char data, MyNode parent) {
        this.key = key;
        this.data = data;
        this.parent = parent;
    }

    public void printNode() {
        System.out.println(key + " " + data + " ");
    }
}
