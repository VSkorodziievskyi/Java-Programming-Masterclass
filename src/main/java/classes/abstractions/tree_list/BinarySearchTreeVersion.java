package classes.abstractions.tree_list;

public class BinarySearchTreeVersion implements Listing {
    private ListElement head;

    public BinarySearchTreeVersion(ListElement head) {
        this.head = head;
    }

    @Override
    public boolean addElement(ListElement node) {
        if (this.head != null) {
            ListElement currentNode = this.head;
            while (true) {
                int index = node.compareTo(currentNode);
                if (index == 0) {
                    System.out.println("Binary Search Tree | Cannot add. Node " + node.getValue() + " is already present.");
                    return false;
                } else if (index > 0) {
                    if (currentNode.next() != null) {
                        currentNode = currentNode.next();
                    } else {
                        currentNode.setNext(node);
                        return true;
                    }
                } else {
                    if (currentNode.previous() != null) {
                        currentNode = currentNode.previous();
                    } else {
                        currentNode.setPrevious(node);
                        return true;
                    }
                }
            }
        } else {
            this.head = node;
            return true;
        }
    }

    @Override
    public boolean removeElement(ListElement node) {
        ListElement currentNode = this.head;
        ListElement parentNode = currentNode;

        while (currentNode != null) {
            int index = node.compareTo(currentNode);
            if (index == 0) {
                performRemoval(currentNode, parentNode);
                System.out.println("Binary Search Tree | Node " + node.getValue() + " deleted.");
                return true;
            } else if (index > 0) {
                parentNode = currentNode;
                currentNode = currentNode.next();
            } else {
                parentNode = currentNode;
                currentNode = currentNode.previous();
            }
        }
        System.out.println("Binary Search Tree | Cannot remove. Node " + node.getValue() + " is missing.");
        return false;
    }

    private void performRemoval(ListElement currentNode, ListElement parentNode) {
        if (currentNode.next() != null && currentNode.previous() != null) {
            ListElement successor = currentNode.next();
            ListElement leftmostParent = currentNode;
            while (successor.previous() != null) {
                leftmostParent = successor;
                successor = successor.previous();
            }
            currentNode.setValue(successor.getValue());
            if (leftmostParent == currentNode) {
                currentNode.setNext(successor.next());
            } else {
                leftmostParent.setPrevious(successor.next());
            }
        } else if (currentNode.previous() == null) {
            if (parentNode.next() == currentNode) {
                parentNode.setNext(currentNode.next());
            } else if (parentNode.previous() == currentNode) {
                parentNode.setPrevious(currentNode.next());
            } else {
                this.head = currentNode.next();
            }
        } else {
            if (parentNode.next() == currentNode) {
                parentNode.setNext(currentNode.previous());
            } else if (parentNode.previous() == currentNode) {
                parentNode.setPrevious(currentNode.previous());
            } else {
                this.head = currentNode.previous();
            }
        }
    }

    private void performTraverse(ListElement head, int index) {
        if (head != null) {
            performTraverse(head.previous(), index + 1);
            System.out.print(" [" + head.getValue() + "] ");
            performTraverse(head.next(), index + 1);
        } else if (index == 0) {
            System.out.println("Binary Search Tree | The tree is empty.");
        }
    }

    @Override
    public void traverse(ListElement head) {
        if (head != null) {
            System.out.print("Binary Search Tree contains: {");
            performTraverse(head, 0);
            System.out.println("}\n");
        } else {
            performTraverse(head, 0);
        }
    }

    @Override
    public ListElement getHead() {
        return this.head;
    }
}
