
/*  Name(s):Kayla Rossi
 * Netid(s):kmr262
 * What I thought about this assignment:
 * It was fun to figure out the puzzle of connecting the list but the information
 * on javahypertext was not very organized and I found it hard to follow.
 * I don't find the videos to provide me with any educational value,
 * but that just might be my learning style is that i need to read or do
 * it myself in order to fully understand and learn the material. I still have
 * paranoia of not having test all the needed test cases and I feel like that is
 * the extent on my time on the assignments.
 */

/** An instance is a circular doubly linked list. */
public class CList<E> {
    /** Replace "-1" by the time you spent on A3 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 11.25;
    /** Fields head, tail and size implement a circular doubly linked list<br>
     * If the list is empty, head and tail are null.<br>
     *
     * Suppose the list is not empty. <br>
     * Then head points at the first node of the list, field succ of each node<br>
     * points at the next node, and field succ of the last node points at the first node.<br>
     * Likewise, tail points at the last node of the list, field pred of each node<br>
     * points at the previous node, and field pred of the first node points at the last node.<br>
     * Field size contains the number of elements in the list. */
    private Node head, tail;

    /** Number of values in the circular linked list. */
    private int size;

    /** Constructor: an empty circular doubly linked list.. */
    public CList() {
        // Do not change this method.
    }

    /** = the number of values in this circular doubly linked list. <br>
     * This function takes constant time. */
    public int size() {
        return size;
    }

    /** = the first node of the circular doubly linked list (null if the list is empty). */
    public Node head() {
        return head;
    }

    /** = the last node of the circular doubly linked list (null if the list is empty). */
    public Node tail() {
        return tail;
    }

    /** Return the value of node n of this list. <br>
     * Precondition: n is a node of this list; it may not be null. */
    public E value(Node n) {
        assert n != null;
        return n.val;
    }

    /** Return a representation of this circular linked list: its values, <br>
     * with adjacent ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 4 7 8 in that order, the result is "[4, 7, 8]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]" */
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb= new StringBuilder("[" + head.val);
        Node n= head.succ;
        // inv: res contains values of nodes before node n (all of them if n = head),
        // with '[' at the beginning and ", " after each except for the last value.
        while (n != head) {
            sb.append(", ");
            sb.append(n.val);
            n= n.succ;
        }
        sb.append("]");
        return sb.toString();
    }

    /** Return a representation of this circular linked list: its values in reverse order, <br>
     * with adjacent ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list. <br>
     * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]". */
    public String toStringR() { // Note:
        // TODO 1. In writing this, do NOT use fields size and head and the succ fields.
        // Use only field tail and the pred and val fields.
        // Use the same scheme as in toString.

        // You can't test this fully until #2, append, is written.
        // Extreme case to watch out for: E is String and values are the empty string.
        if (tail == null) return "[]";
        StringBuilder sb= new StringBuilder("[" + tail.val);
        Node n= tail.pred;
        // inv: res contains values of nodes before node n (all of them if n = head),
        // with '[' at the beginning and "," after each except for the the last value.
        while (n != tail) {
            sb.append(", ");
            sb.append(n.val);
            n= n.pred;
        }
        sb.append("]");
        return sb.toString();
    }

    /** Add v to the end of this list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], append(2) changes this list to [8, 7, 4, 2]. <br>
     * E.g. if the list is ["AB"], append(null) changes the list to ["AB", null]. */
    public void append(E v) {
        // TODO 2. After writing this method, test this method and
        // method toStringR thoroughly before starting on the next method.
        // These two must be correct in order to be able to write and test all the others.
        Node a= new Node(null, v, null);
        // condition with something in list
        if (size > 0) {
            a.succ= head;
            a.pred= tail;
            tail.succ= a;
            head.pred= a;
            tail= a;
            size++ ;
        }
        // condition: nothing in list, no tail pred or head succ if previous were null
        else {
            a.succ= a;
            a.pred= a;
            tail= a;
            head= a;
            size++ ;
        }
    }

    /** Make the tail the head of list and return the new head;<br>
     * Note: if the list is [] or [5], the list is unchanged.<br>
     * E.g. Suppose the list is [5, 3, 4, 6]. <br>
     * .... After this method is called, the list is [6, 5, 3, 4]. */
    public Node changeHeadToTail() {
        // We give you this method. Do not change.
        if (size <= 1) return head;
        head= tail;
        tail= tail.pred;
        return head;
    }

    /** Insert v at the beginning of the list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], prepend(2) changes this list to [2, 8, 7, 4]. */
    public void prepend(E v) {
        // TODO 3. This is the third method to write and test.
        // Test it thoroughly before writing any others.
        Node b= new Node(null, v, null);
        if (size > 0) {
            b.succ= head;
            b.pred= tail;
            tail.succ= b;
            head.pred= b;
            head= b;
            size++ ;
        } else {
            b.succ= b;
            b.pred= b;
            tail= b;
            head= b;
            size++ ;
        }
    }

    /** Return node number h. <br>
     * Precondition: 0 <= h < size of the list. <br>
     * Note: If h is 0, return first node; if h = 1, return second node, ... */
    public Node getNode(int h) {
        // TODO 4. This method should take time proportional to min(h, size-h).
        // For example, if h < size/2, search from the beginning of the
        // list, otherwise search from the end of the list. If h = size/2,
        // search from either end; it doesn't matter.
        assert h >= 0 && h < size;
        if (h <= size / 2) {
            Node n= head;
            for (int i= 0; i < h; i++ ) {
                n= n.succ;
            }
            return n;
        } else {
            Node n= tail;
            for (int i= size - 1; i > h; i-- ) {
                n= n.pred;
            }
            return n;
        }
    }

    /** Remove node n from this list. <br>
     * This operation must take constant time. <br>
     * Precondition: n must be a node of this list; it may not be null. */
    public void remove(Node n) {
        // TODO 5. Make sure this method takes constant time.
        // n != null
        // size should always be at least 1 when starting
        if (size == 1) {
            head= null;
            tail= null;
        } else if (n == head) {
            n.succ.pred= tail;
            head= n.succ;
            tail.succ= head;
        } else if (n == tail) {
            n.pred.succ= head;
            tail= n.pred;
            head.pred= tail;
        } else if (n != head || n != tail) {
            n.pred.succ= n.succ;
            n.succ.pred= n.pred;
        }
        size-- ;
    }

    /** Insert value v before node n. <br>
     * This operation takes constant time. <br>
     * Precondition: n must be a node of this list; it may not be null.<br>
     * E.g. if the list is [3, 8, 2], n points to the node with 8 in it, <br>
     * and v is 1, the list is changed to [3, 1, 8, 2] */
    public void insertBefore(E v, Node n) {
        // TODO 6. Make sure this method takes constant time.
        Node c= new Node(null, v, null);
        if (n == head) {
            head= c;
        }
        c.succ= n;
        c.pred= n.pred;
        n.pred= c;
        c.pred.succ= c;

        size++ ;
    }

    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        private Node pred; // Previous node (predecessor) on list (tail if this is first node).
        private E val;     // The value of this node
        private Node succ; // Next node (successor) on list (head if this is last node).

        /** Constructor: an instance with predecessor p (can be null), value v, and <br>
         * successor s (can be null). */
        Node(Node p, E v, Node s) {
            pred= p;
            val= v;
            succ= s;
        }

        /** = the predecessor of this node (tail if this is the first node of the list). */
        public Node pred() {
            return pred;
        }

        /** = the value of this node. */
        public E value() {
            return val;
        }

        /** = the next node in this list (head if this is the last node of this list). */
        public Node succ() {
            return succ;
        }
    }
}
