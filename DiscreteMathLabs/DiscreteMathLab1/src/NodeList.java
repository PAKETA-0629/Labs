import java.util.ArrayList;

public class NodeList {

    private ArrayList<MyNode> nodeArray = new ArrayList<>();


    NodeList(char[] data, int[] key) {
        for (int i = 0; i < data.length; i++) {
            MyNode node = new MyNode(key[i], data[i]);
            nodeArray.add(node);
        }
        this.sortArray();
    }


    public ArrayList<MyNode> getNodeArray() {
        return nodeArray;
    }

    public void set(ArrayList<MyNode> nd) {
        nodeArray = nd;
    }


    public void add(MyNode node) {
        nodeArray.add(node);
        this.sortArray();
    }

    public void sortArray() {
        for (int i = 0; i < nodeArray.size(); i++) {
            MyNode min = nodeArray.get(i);
            int minId = i;
            for (int j = i + 1; j < nodeArray.size(); j++) {
                if (nodeArray.get(j).key < min.key) {
                    min = nodeArray.get(j);
                    minId = j;
                }
            }

            MyNode temp = nodeArray.get(i);
            nodeArray.set(i, min);
            nodeArray.set(minId, temp);
        }
    }
}
