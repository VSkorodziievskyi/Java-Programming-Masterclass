package classes.abstractions.tree_list;

public abstract class ListElement {
    protected ListElement next = null;
    protected ListElement previous = null;
    protected Object value;

    public ListElement(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract ListElement setNext(ListElement element);

    abstract ListElement setPrevious(ListElement element);

    abstract ListElement next();

    abstract ListElement previous();

    abstract int compareTo(ListElement element);

}

