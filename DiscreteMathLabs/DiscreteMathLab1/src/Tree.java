public class Tree {

    MyNode root;

    public void insertInNode(MyNode root, MyNode left, MyNode right) {
        root.rightChild = right;
        root.leftChild = left;
    }

    public void insertLeft(MyNode root, MyNode left) {
        root.leftChild = left;
    }

    public void insertRight(MyNode root, MyNode right) {
        root.rightChild = right;
    }


    public void insertInRoot(MyNode root, MyNode myNode) {

        if (root.rightChild == null) root.rightChild = myNode;
        else if (root.leftChild == null) root.leftChild = myNode;

    }

    public void insert(int key, char data) {
        MyNode myNode = new MyNode();
        myNode.key = key;
        myNode.data = data;
        if (root == null) {
            root = myNode;
        } else {
            MyNode current = root;
            MyNode prev;
            while(true) {
                prev = current;
                if(key < prev.key) {
                    current = current.leftChild;
                    if(current==null) {
                        prev.leftChild = myNode;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if(current==null) {
                        prev.rightChild = myNode;
                        return;
                    }
                }
            }
        }
    }

    public void print(MyNode startMyNode){
        if (startMyNode != null) {
            startMyNode.printNode();
            print(startMyNode.leftChild);
            print(startMyNode.rightChild);

        }
    }
}
