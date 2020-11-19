/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author Johan
 */
public class CircularSimplyLinkedList<E> implements List<E> {
    private Nodo<E> last;
    private int current;

    public CircularSimplyLinkedList() {
        last = null;
        current = 0;
    }

    @Override
    public boolean add(E element, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private class Nodo<E> {
        private E data;
        private Nodo<E> next;

        public Nodo(E data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean addLast(E e) {
        Nodo<E> n = new Nodo<>(e);
        if (isEmpty()) {
            last = n;
            last.next = last;
        } else {
            n.next = last.next;
            last.next = n;
            last = n;
        }
        current++;
        return true;
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    public int indexOf(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    public boolean insert(int index, E e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    public boolean set(int index, E e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean contains(E e) {
        Nodo<E> pos = last.next;
        do {
            if (pos.data.equals(e))
                return true;
            pos = pos.next;
        } while (pos != last.next);
        return false;
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

}
