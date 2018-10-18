package me.ianhe.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author iHelin
 * @date 2018/10/18 21:33
 */
public class LinkListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        ListIterator<String> aIterator = a.listIterator();
        Iterator<String> bIterator = b.iterator();
        while (bIterator.hasNext()) {
            if (aIterator.hasNext()) {
                aIterator.next();
            }
            aIterator.add(bIterator.next());
        }
        System.out.println(a);
        bIterator = b.iterator();
        while (bIterator.hasNext()) {
            bIterator.next();
            if (bIterator.hasNext()) {
                bIterator.next();
                bIterator.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
