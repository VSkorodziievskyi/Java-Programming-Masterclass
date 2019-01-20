package classes.abstractions.tree_list;

public class Main {
    public static void main(String[] args) {
        LinkedListVersion list = new LinkedListVersion(null);
        BinarySearchTreeVersion tree = new BinarySearchTreeVersion(null);
        list.traverse(list.getHead());
        tree.traverse(tree.getHead());
        System.out.println("\n");

        list.removeElement(new Node("3")); //the attempt to remove missing elements from both structures.
        tree.removeElement(new Node("5"));
        list.removeElement(new Node("4"));

        String elements = "5 7 3 9 8 2 1 0 4 6";
        String duplicates = "8 0 4";

        String[] data = elements.split(" ");
        for (String x : data) {
            list.addElement(new Node(x));
            tree.addElement(new Node(x));
        }

        System.out.println("\n*Here Linked List and Binary Search Tree got the following elements and sorted them in ascending order: 5 7 3 9 8 2 1 0 4 6.*\n");

        String[] duplicateData = duplicates.split(" "); //the attempt to add duplicates to both structures.
        for (String x : duplicateData) {
            list.addElement(new Node(x));
            tree.addElement(new Node(x));
        }
        System.out.println("\n");

        list.traverse(list.getHead());

        list.removeElement(new Node("3"));
        list.traverse(list.getHead());
        list.removeElement(new Node("5"));
        list.traverse(list.getHead());
        list.removeElement(new Node("0"));
        list.removeElement(new Node("4"));
        list.removeElement(new Node("2"));
        list.traverse(list.getHead());
        list.removeElement(new Node("9"));
        list.traverse(list.getHead());
        list.removeElement(new Node("8"));
        list.traverse(list.getHead());
        list.removeElement(new Node("6"));
        list.removeElement(new Node("6"));
        list.traverse(list.getHead());
        list.removeElement(list.getHead());
        list.traverse(list.getHead());
        list.removeElement(list.getHead());
        list.traverse(list.getHead());

        System.out.println("\n*Binary Search Tree operates in the same way below.*\n");

        tree.traverse(tree.getHead());

        tree.removeElement(new Node("3"));
        tree.traverse(tree.getHead());
        tree.removeElement(new Node("5"));
        tree.traverse(tree.getHead());
        tree.removeElement(new Node("0"));
        tree.removeElement(new Node("4"));
        tree.removeElement(new Node("2"));
        tree.traverse(tree.getHead());
        tree.removeElement(new Node("9"));
        tree.traverse(tree.getHead());
        tree.removeElement(new Node("8"));
        tree.traverse(tree.getHead());
        tree.removeElement(new Node("6"));
        tree.removeElement(new Node("6"));
        tree.traverse(tree.getHead());
        tree.removeElement(tree.getHead());
        tree.traverse(tree.getHead());
        tree.removeElement(tree.getHead());
        tree.traverse(tree.getHead());
    }
}
