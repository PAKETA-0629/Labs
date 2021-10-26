import java.util.*;

public class ShannonFano {

    private Tree tree;
    private LetterTable lt;

    private char[] binaryLetters;
    private String[] binaryValues;

    private ArrayList<MyNode> finalNodes = new ArrayList<>();

    public String code(String str) {

        StringBuilder result = new StringBuilder();
        lt = new LetterTable(str);
        binaryLetters = new char[lt.getLetters().length];
        binaryValues = new String[lt.getLetters().length];
        int[] values = lt.getValues();
        int arraySum = Arrays.stream(values).sum();
        tree = new Tree();
        tree.insert(arraySum, '.');
        makeTree(values, 0, values.length, tree.root);
        BTreePrinter.printNode(tree.root);
        int index = 0;
        for (MyNode node: finalNodes) {
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
            binaryLetters[index] = finalNodes.get(index).data;
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


    public String decode(String binaryStr) {

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < binaryStr.length(); i++) {
            buffer.append(binaryStr.charAt(i));

            for (int j = 0; j < binaryValues.length; j++) {
                if (binaryValues[j].equals(buffer.toString())) {
                    result.append(binaryLetters[j]);
                    buffer = new StringBuilder();
                }
            }

        }

        return result.toString();

    }


    private int sum(int[] array, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum+=array[i];
        }
        return sum;
    }


    private void makeTree(int[] values, int start, int end, MyNode root) {

        if(end-start == 2) {
            MyNode node1 = new MyNode(values[start], lt.getLetters()[start], root);
            MyNode node2 = new MyNode(values[++start], lt.getLetters()[start], root);
            tree.insertInNode(root, node1, node2);
            finalNodes.add(node1);
            finalNodes.add(node2);
            return;
        } else if (end-start == 1) {
            MyNode node = new MyNode(values[start], lt.getLetters()[start], root);
            tree.insertInRoot(root, node);
            finalNodes.add(node);
            return;
        }

        int len = 0;
        int i = start;
        int globalSum = sum(values, start, end);
        int[] tempArray = new int[++len];
        int lastElem = values[start+1];
        for(int j = 0, index = start; j < tempArray.length; j++) {
            tempArray[j] = values[index++];
        }
        int sum = Arrays.stream(tempArray).sum();
        if (Math.abs((sum) - (globalSum - sum)) > Math.abs((sum + lastElem) - (globalSum - sum - lastElem))) {
            int[] biggerArray = new int[tempArray.length+1];
            System.arraycopy(tempArray, 0, biggerArray, 0, tempArray.length);
            biggerArray[biggerArray.length-1] = lastElem;
            MyNode myNode1 = new MyNode(Arrays.stream(biggerArray).sum(), '.', root);
            MyNode myNode2 = new MyNode(globalSum - Arrays.stream(biggerArray).sum(), '.', root);
            root.leftChild = myNode1;
            root.rightChild = myNode2;
            makeTree(values, start, i+2, myNode1);
            makeTree(values, i+2, end, myNode2);
        } else {
            MyNode myNode1 = new MyNode(tempArray[0], lt.getLetters()[start], root);
            finalNodes.add(myNode1);
            MyNode myNode2 = new MyNode(globalSum-sum, '.', root);
            tree.insertRight(root, myNode1);
            tree.insertLeft(root, myNode2);
            makeTree(values, i+1, end, myNode2);
        }
    }
}