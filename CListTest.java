import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CListTest {

    @Test
    void testConstructor() {
        CList<Integer> c= new CList<>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringR());
        assertEquals(0, c.size());
    }

    @Test
    public void testAppend() {
        CList<String> ll= new CList<>();
        ll.append("CLA");
        assertEquals("[CLA]", ll.toString());
        assertEquals("[CLA]", ll.toStringR());
        assertEquals(1, ll.size());
        ll.append("SS");
        assertEquals("[CLA, SS]", ll.toString());
        assertEquals("[SS, CLA]", ll.toStringR());
        assertEquals(2, ll.size());
        ll.append("");
        assertEquals("[CLA, SS, ]", ll.toString());
        assertEquals("[, SS, CLA]", ll.toStringR());
        assertEquals(3, ll.size());
    }

    @Test
    public void testPrepend() {
        CList<String> ll= new CList<>();
        ll.prepend("CLA");
        assertEquals("[CLA]", ll.toString());
        assertEquals("[CLA]", ll.toStringR());
        assertEquals(1, ll.size());
        ll.prepend("SS");
        assertEquals("[SS, CLA]", ll.toString());
        assertEquals("[CLA, SS]", ll.toStringR());
        assertEquals(2, ll.size());
        ll.prepend("");
        assertEquals("[, SS, CLA]", ll.toString());
        assertEquals("[CLA, SS, ]", ll.toStringR());
        assertEquals(3, ll.size());
    }

    @Test
    public void testGetNode() {
        CList<Integer> ll= new CList<>();
        ll.append(5);
        assertEquals(5, ll.getNode(0).value());
        assertEquals("[5]", ll.toString());
        assertEquals("[5]", ll.toStringR());
        assertEquals(1, ll.size());
        ll.append(2);
        assertEquals(2, ll.getNode(1).value());
        assertEquals(5, ll.getNode(0).value());
        assertEquals("[5, 2]", ll.toString());
        assertEquals("[2, 5]", ll.toStringR());
        assertEquals(2, ll.size());
        ll.append(35);
        assertEquals(35, ll.getNode(2).value());
        assertEquals(2, ll.getNode(1).value());
        assertEquals(5, ll.getNode(0).value());
        assertEquals("[5, 2, 35]", ll.toString());
        assertEquals("[35, 2, 5]", ll.toStringR());
        assertEquals(3, ll.size());
        assertThrows(AssertionError.class, () -> ll.getNode(-1));
        assertThrows(AssertionError.class, () -> ll.getNode(4));
    }

    @Test
    public void testRemove() {
        CList<Integer> ll= new CList<>();
        ll.append(12);
// list is one node (12) size 1
        ll.remove(ll.getNode(0));
        assertEquals("[]", ll.toString());
        assertEquals("[]", ll.toStringR());
        assertEquals(0, ll.size());
        ll.append(4);
        ll.append(24);
// list is 2 nodes (4, 24), remove head
        ll.remove(ll.getNode(0));
        assertEquals("[24]", ll.toString());
        assertEquals("[24]", ll.toStringR());
        assertEquals(1, ll.size());
        ll.remove(ll.getNode(0));
        assertEquals("[]", ll.toString());
        assertEquals("[]", ll.toStringR());
        assertEquals(0, ll.size());
        ll.append(3);
        ll.append(5);
        ll.append(9);
        ll.remove(ll.getNode(1));
// list is 3 nodes (3, 5 ,9), remove middle
        assertEquals("[3, 9]", ll.toString());
        assertEquals("[9, 3]", ll.toStringR());
        assertEquals(2, ll.size());
        ll.remove(ll.getNode(1));
// list is 2 nodes (3, 9), remove tail
        assertEquals("[3]", ll.toString());
        assertEquals("[3]", ll.toStringR());
        assertEquals(1, ll.size());
        ll.remove(ll.getNode(0));
        assertEquals("[]", ll.toString());
        assertEquals("[]", ll.toStringR());
        assertEquals(0, ll.size());
        ll.append(2);
        ll.append(4);
        ll.append(6);
        ll.remove(ll.getNode(0));
// list is 3 nodes (2, 4, 6), remove head
        assertEquals("[4, 6]", ll.toString());
        assertEquals("[6, 4]", ll.toStringR());
        assertEquals(2, ll.size());
        ll.append(65);
        ll.append(66);
        ll.remove(ll.getNode(3));
// list is 4 nodes (4, 6, 65, 66), remove tail
        assertEquals("[4, 6, 65]", ll.toString());
        assertEquals("[65, 6, 4]", ll.toStringR());
        assertEquals(3, ll.size());
    }

    @Test
    public void testInsertBefore() {
        CList<Integer> ll= new CList<>();
        ll.append(2);
// insert before head
        ll.insertBefore(4, ll.getNode(0));
        assertEquals("[4, 2]", ll.toString());
        assertEquals("[2, 4]", ll.toStringR());
        assertEquals(2, ll.size());
        ll.insertBefore(1, ll.getNode(1));
// insert between two
        assertEquals("[4, 1, 2]", ll.toString());
        assertEquals("[2, 1, 4]", ll.toStringR());
        assertEquals(3, ll.size());
        ll.insertBefore(10000, ll.getNode(2));
// insert before tail
        assertEquals("[4, 1, 10000, 2]", ll.toString());
        assertEquals("[2, 10000, 1, 4]", ll.toStringR());
        assertEquals(4, ll.size());

    }

}
