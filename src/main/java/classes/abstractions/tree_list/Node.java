package classes.abstractions.tree_list;

public class Node extends ListElement {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListElement setNext(ListElement element) {
        this.next = element;
        return this.next;
    }

    @Override
    ListElement setPrevious(ListElement element) {
        this.previous = element;
        return this.previous;
    }

    @Override
    ListElement next() {
        return this.next;
    }

    @Override
    ListElement previous() {
        return this.previous;
    }

    @Override
    int compareTo(ListElement element) {
        if (element != null) {
            return ((String) super.getValue()).compareTo((String) element.getValue());
        } else {
            return -1;
        }
    }
}
