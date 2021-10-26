import java.util.ArrayList;

public class Hofmann {

    private Tree tree;
    private LetterTable lt;
    private ArrayList<MyNode> mynodes = new ArrayList<>();

    private char[] binaryLetters;
    private String[] binaryValues;

    public String code(String str) {
        StringBuilder result = new StringBuilder();
        lt = new LetterTable(str);


        binaryLetters = new char[lt.getLetters().length];
        binaryValues = new String[lt.getLetters().length];

        NodeList nl = new NodeList(lt.getLetters(), lt.getValues());
        mynodes.addAll(nl.getNodeArray());

        while (nl.getNodeArray().size() > 2) {

            ArrayList<MyNode> nd = new ArrayList<>();
            MyNode newNode = new MyNode(nl.getNodeArray().get(0).key + nl.getNodeArray().get(1).key  , '.');

            nl.getNodeArray().get(0).parent = newNode;
            nl.getNodeArray().get(1).parent = newNode;
            newNode.rightChild = nl.getNodeArray().get(0);
            newNode.leftChild = nl.getNodeArray().get(1);
            nd.add(newNode);

            for (int i = 2; i < nl.getNodeArray().size(); i++) {
                nd.add(nl.getNodeArray().get(i));
            }

            nl.set(nd);
            nl.sortArray();
        }

        MyNode root = new MyNode(nl.getNodeArray().get(0).key + nl.getNodeArray().get(1).key, '.');
        tree = new Tree();
        root.rightChild = nl.getNodeArray().get(0);
        root.leftChild = nl.getNodeArray().get(1);
        nl.getNodeArray().get(0).parent = root;
        nl.getNodeArray().get(1).parent = root;
        tree.root = root;
        BTreePrinter.printNode(tree.root);

        int index = 0;
        for (MyNode node: mynodes) {
            MyNode currentNode = node;
            StringBuilder code = new StringBuilder();
            while(currentNode.parent != null) {

                MyNode parentNode = currentNode.parent;
                if (parentNode.leftChild == currentNode) {
                    code.append("0");
                } else {
                    code.append("1");
                }

                currentNode = parentNode;

            }
            binaryLetters[index] = mynodes.get(index).data;
            binaryValues[index] = code.reverse().toString();
            index++;
        }
        for (int i = 0; i < binaryLetters.length; i++) {
            System.out.println(binaryLetters[i] + " | " + binaryValues[i]);
        }

        for (int i = 0; i < str.length(); i++) {
            for(int j = 0; j < binaryLetters.length; j++) {
                if (str.charAt(i) == binaryLetters[j]) result.append(binaryValues[j]);
            }
        }
        return result.toString();

    }


    public String decode(String code) {
        StringBuilder result = new StringBuilder();
        MyNode current = tree.root;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '0') current = current.leftChild;
            else current = current.rightChild;

            if (current.leftChild == null & current.rightChild == null) {
                result.append(current.data);
                current = tree.root;
            }
        }

        return result.toString();
    }
}
