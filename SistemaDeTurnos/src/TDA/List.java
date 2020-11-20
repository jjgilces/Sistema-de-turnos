package TDA;

/**
 *
 * @author Johan
 */
public interface List<E> {
    
    boolean addFirst(E element);
    boolean addLast(E element);
    boolean add(E element, int index);
    E get(int index);
    boolean remove(int index);
    boolean isEmpty();
    boolean contains(E element);
    boolean removeFirst();
    boolean removeLast();
    E getFirst();
    E getLast(); 
    int size();
//    List<E> slicing(int inicio, int fin);
}
