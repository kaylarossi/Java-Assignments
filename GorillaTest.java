import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GorillaTest {
    @Test
    void testGroupA() {
        Gorilla g= new Gorilla("kayla", 2020, 1, 'f');
        assertEquals("kayla", g.name());
        assertEquals(2020, g.year());
        assertEquals(1, g.month());
        assertEquals(true, g.isFemale());
        assertThrows(AssertionError.class, () -> new Gorilla(null, 2020, 5, 'f'));
        assertThrows(AssertionError.class, () -> new Gorilla("", 2020, 3, 'f'));
        assertThrows(AssertionError.class, () -> new Gorilla("norm", 1990, -1, 'm'));
        assertThrows(AssertionError.class, () -> new Gorilla("b", 1991, 13, 'f'));
        assertThrows(AssertionError.class, () -> new Gorilla("c", 1992, 2, 'z'));
    }

    @Test
    void testGroupB() {
        Gorilla g2= new Gorilla("bob", 2020, 3, 'm');
        Gorilla mom= new Gorilla("lisa", 1990, 4, 'f');
        Gorilla pop= new Gorilla("jim", 1990, 3, 'm');
        g2.setMom(mom);
        g2.setPop(pop);
        assertEquals(mom, g2.mom());
        assertEquals(1, mom.numChildren());
        assertEquals(pop, g2.pop());
        assertEquals(1, pop.numChildren());
        assertThrows(AssertionError.class, () -> { g2.setMom(null); });
        assertThrows(AssertionError.class, () -> g2.setMom(pop));
        assertThrows(AssertionError.class, () -> g2.setMom(mom));
        assertThrows(AssertionError.class, () -> { g2.setPop(null); });
        assertThrows(AssertionError.class, () -> g2.setPop(mom));
        assertThrows(AssertionError.class, () -> g2.setPop(pop));
    }

    @Test
    void testGroupC() {
        Gorilla mom1= new Gorilla("wendy", 1989, 5, 'f');
        Gorilla pop1= new Gorilla("peter", 1989, 4, 'm');
        Gorilla kid= new Gorilla("tink", 1996, 6, 'f', mom1, pop1);
        assertEquals(mom1, kid.mom());
        assertEquals(pop1, kid.pop());
        assertEquals(1, mom1.numChildren());
        assertEquals(1, pop1.numChildren());
    }

    @Test
    void testGroupDStep4() {
// Testing isOlder
//same year q's month before r's
        Gorilla q= new Gorilla("q", 1989, 1, 'f');
        Gorilla r= new Gorilla("r", 1989, 6, 'm');
        assertEquals(true, q.isOlder(r));
        assertEquals(false, r.isOlder(q));

// same year same month
        Gorilla qFeb90= new Gorilla("qFeb90", 1990, 2, 'm');
        Gorilla rFeb90= new Gorilla("rFeb90", 1990, 2, 'm');
        assertEquals(false, qFeb90.isOlder(rFeb90));
        assertEquals(false, rFeb90.isOlder(qFeb90));

// same year q's month after r's
        Gorilla qMar89= new Gorilla("qMar89", 1989, 3, 'f');
        Gorilla rJan89= new Gorilla("rJan89", 1989, 1, 'f');
        assertEquals(false, qMar89.isOlder(rJan89));
        assertEquals(true, rJan89.isOlder(qMar89));

//q's year before r's, q's month before r's
        Gorilla qJan89= new Gorilla("k", 1989, 1, 'm');
        Gorilla rMar90= new Gorilla("m", 1990, 3, 'f');
        assertEquals(true, qJan89.isOlder(rMar90));
        assertEquals(false, rMar90.isOlder(qJan89));

// q's year before r's, same month
        Gorilla qMar70= new Gorilla("k", 1970, 3, 'f');
        Gorilla rMar71= new Gorilla("m", 1971, 3, 'f');
        assertEquals(true, qMar70.isOlder(rMar71));
        assertEquals(false, rMar71.isOlder(qMar70));

//q's year before r's, q's month after r's
        Gorilla qApr65= new Gorilla("k", 1965, 4, 'm');
        Gorilla rMar66= new Gorilla("k", 1966, 3, 'f');
        assertEquals(true, qApr65.isOlder(rMar66));
        assertEquals(false, rMar66.isOlder(qApr65));

//q's year after r's, q's month before r's
        Gorilla qJan56= new Gorilla("j", 1956, 1, 'f');
        Gorilla rFeb55= new Gorilla("j", 1955, 2, 'f');
        assertEquals(false, qJan56.isOlder(rFeb55));
        assertEquals(true, rFeb55.isOlder(qJan56));

//q's year after r's, same month
        Gorilla qMar56= new Gorilla("l", 1956, 3, 'm');
        Gorilla rMar55= new Gorilla("l", 1955, 3, 'm');
        assertEquals(false, qMar56.isOlder(rMar55));
        assertEquals(true, rMar55.isOlder(qMar56));

//q's year after r's, q's month after r's
        Gorilla qMay56= new Gorilla("l", 1956, 5, 'f');
        Gorilla rApr55= new Gorilla("l", 1955, 4, 'm');
        assertEquals(false, qMay56.isOlder(rApr55));
        assertEquals(true, rApr55.isOlder(qMay56));

// Neither A nor B has a parent
        Gorilla A= new Gorilla("A", 1990, 1, 'f');
        Gorilla B= new Gorilla("B", 1990, 6, 'm');
        assertEquals(null, A.mom());
        assertEquals(null, B.mom());
        assertEquals(null, A.pop());
        assertEquals(null, B.pop());

//Testing areSiblings
// A and B are the same object and have the same non-null parent
        Gorilla mo= new Gorilla("mo", 1970, 4, 'f');
        Gorilla po= new Gorilla("po", 1970, 3, 'm');
        Gorilla C= new Gorilla("C", 1989, 2, 'f', mo, po);
        Gorilla D= new Gorilla("C", 1989, 2, 'f', mo, po);
        assertEquals(false, C.areSiblings(C));
        assertEquals(mo, C.mom());
        assertEquals(mo, D.mom());
        assertThrows(AssertionError.class, () -> C.areSiblings(null));

// A and B are different objects and have same moms and pops
        Gorilla ma= new Gorilla("ma", 1981, 6, 'f');
        Gorilla pa= new Gorilla("pa", 1988, 2, 'm');
        Gorilla aa= new Gorilla("aa", 1990, 1, 'f', ma, pa);
        Gorilla bb= new Gorilla("bb", 1998, 4, 'f', ma, pa);
        Gorilla ee= new Gorilla("ee", 2010, 5, 'f', mo, po);
        assertEquals(ma, aa.mom());
        assertEquals(ma, bb.mom());
        assertEquals(pa, aa.pop());
        assertEquals(pa, bb.pop());
        assertEquals(true, aa.areSiblings(bb));
        assertEquals(false, ee.areSiblings(bb));
        assertEquals(2, ma.numChildren());

// A and B are different objects and have different moms and pops
        Gorilla mm= new Gorilla("mm", 1999, 1, 'f');
        Gorilla pp= new Gorilla("pp", 1999, 4, 'm');
        Gorilla cc= new Gorilla("cc", 2005, 6, 'f', ma, pa);
        Gorilla dd= new Gorilla("dd", 2014, 8, 'f', mm, pp);
        assertEquals(ma, cc.mom());
        assertEquals(mm, dd.mom());
        assertEquals(pa, cc.pop());
        assertEquals(pp, dd.pop());
        assertEquals(false, cc.areSiblings(dd));
        assertEquals(1, mm.numChildren());

    }
}
