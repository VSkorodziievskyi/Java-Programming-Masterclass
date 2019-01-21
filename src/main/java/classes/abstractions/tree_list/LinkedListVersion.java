package classes.abstractions.tree_list;

public class LinkedListVersion implements Listing {
    private ListElement head;

    public LinkedListVersion(ListElement head) {
        this.head = head;
    }

    @Override
    public boolean addElement(ListElement element) {
        if (this.head != null) {
            ListElement currentElement = this.head;
            while (true) {
                int index = element.compareTo(currentElement);
                if (index == 0) {
                    System.out.println("Linked List | Cannot add. Element " + element.getValue() + " is already present.");
                    return false;
                } else if (index > 0) {
                    if (currentElement.next() != null) {
                        currentElement = currentElement.next();
                    } else {
                        currentElement.setNext(element).setPrevious(currentElement);
                        return true;
                    }
                } else {
                    if (currentElement.previous() != null) {
                        currentElement.previous().setNext(element).setPrevious(currentElement.previous());
                        element.setNext(currentElement).setPrevious(element);
                    } else {
                        element.setNext(this.head).setPrevious(element);
                        this.head = element;
                    }
                    return true;
                }
            }
        } else {
            this.head = element;
            return true;
        }
    }

    @Override
    public boolean removeElement(ListElement element) {
        ListElement currentElement = this.head;
        while (true) {
            int index = element.compareTo(currentElement);
            if (index > 0) {
                currentElement = currentElement.next();
            } else if (index < 0) {
                System.out.println("Linked List | Cannot remove. Element " + element.getValue() + " is missing.");
                return false;
            } else {
                if (currentElement == this.head) {
                    this.head = currentElement.next();
                } else {
                    currentElement.previous().setNext(currentElement.next());
                    if (currentElement.next() != null) {
                        currentElement.next().setPrevious(currentElement.previous());
                    }
                }
                System.out.println("Linked List | Element " + element.getValue() + " deleted.");
                return true;
            }
        }
    }

    @Override
    public void traverse(ListElement head) {
        if (head != null) {
            System.out.print("Linked List contains: {");
            while (head != null) {
                System.out.print(" [" + head.getValue() + "] ");
                head = head.next();
            }
            System.out.println("}\n");
        } else {
            System.out.println("Linked List | The list is empty.");
        }
    }


    @Override
    public ListElement getHead() {
        return this.head;
    }
}
