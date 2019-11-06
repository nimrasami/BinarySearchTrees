
class Node {

    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class BinaryTree {

    Node root;

    BinaryTree() {
        root = null;
    }

    public static void main(String args[]) {

        BinaryTree bTree = new BinaryTree();

        int array[] = {5, 85, 89, 3, 2, 8, 65, 92};

        for (int i = 0; i < array.length; i++) {
            bTree.insert(array[i]);
        }

        System.out.println("Pre-Order:");
        bTree.PreOrder(bTree.root);

        System.out.println();
        System.out.println(" Node" + "\t" + "Height" + "\t" + "Balance Factor");

        int[] outputArray = {2, 65, 92, 8, 89, 85, 3, 5};

        for (int x = 0; x < outputArray.length; x++) {
            System.out.println(outputArray[x] + "\t" + bTree.Height(bTree.newNode(outputArray[x])) + "\t" + bTree.BalanceFactor(bTree.newNode(outputArray[x])));
        }

    }

    public void print() {
        PrintRecursive(root);
    }

    //Recursive call to print()
    public void PrintRecursive(Node currentNode) {

        if (currentNode != null) {
            System.out.println(" " + currentNode.value + "\t" + Height(currentNode) + "\t" + BalanceFactor(currentNode));

            PrintRecursive(currentNode.left);
            PrintRecursive(currentNode.right);
        }

    }

    public void insert(int value) {
        root = addRecursive(root, value);
    }

    public void Preorder() {
        PreOrder(root);
    }

    public void PreOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.print(currentNode.value + " ");

        PreOrder(currentNode.left);

        PreOrder(currentNode.right);
    }

    public int Height(Node currentNode) {
        if (currentNode == null) {
            return -1;
        }

        return Math.max(Height(currentNode.left), Height(currentNode.right)) + 1;
    }

    // Find the BalanceFactor of a Node
    public int BalanceFactor(Node currentNode) {
        int BalanceFactor = 0;
        if (currentNode == null) {
            return 0;
        } else {
            return (Height(currentNode.left) - Height(currentNode.right));
        }
    }

    private Node addRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = addRecursive(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = addRecursive(currentNode.right, value);
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;
    }

    public Node newNode(int value) {
        Node currentNode = root;

        while (currentNode.value != value) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

}
