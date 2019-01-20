package classes.abstractions.tree_list;

public interface Listing {
    boolean addElement(ListElement element);

    boolean removeElement(ListElement element);

    void traverse(ListElement head);

    ListElement getHead();
}
