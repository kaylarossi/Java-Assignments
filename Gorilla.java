/*NetID: kmr262. Time spent: 8 hours 30 minutes
 * What I thought about this assignment:
 * I thought that office hours were vital for completing this assignment and
 * having confidence in my work. There is a big disconnect between lecture
 * and actually writing the code first hand. I have a detailed Matlab background
 * so I felt that this was a bit difficult to understand at first, but talking
 * to the TAs and consultants helped me to understand a lot of details with not
 * just the assignment but also the actual writing in Java. I don't feel that
 * lecture affectively teaches code implementation. I learned a lot doing
 * this assignment, it was a good way to dive into learning the language. I wish
 * lecture or recitation could hold just as much first-hand code implementation.
 */

/** An instance maintains info about the gorilla */

public class Gorilla {

    /** Gorilla name. Must contain at least 1 character. */
    private String name;

    /** Gorilla gender. 'f' for female, 'm' for male. */
    private char gender;

    /** Year of birth. Can be any integer */
    private int year;

    /** Month of birth. 1 for Jan, 2 for Feb., ..., 12 for Dec. */
    private int month;

    /** Mother of this gorilla, null if unknown. */
    private Gorilla mom;

    /** Father of this gorilla, null if unknown. */
    private Gorilla pop;

    /** Number of known children of this gorilla. */
    private int children;

    /** Constructor: a new Gorilla with name n, birth year y, birth month m, and gender g. Its
     * father and mother are unknown, and it has no children. Precondition: n has at least one
     * character in it, m is 1 for Jan, 2 for Feb, etc., and g is 'f' or 'm' for female or male */

    public Gorilla(String n, int y, int m, char g) {
        assert n != null && 1 <= n.length();
        assert m >= 1 && m < 13;
        assert g == 'f' || g == 'm';
        name= n;
        year= y;
        month= m;
        gender= g;
        mom= null;
        pop= null;
        children= 0;

    }

    /** = the name of this Gorilla */
    public String name() {
        return name;
    }

    /** ="this gorilla is female" */
    public boolean isFemale() {
        return gender == 'f';
    }

    /** = is the month this gorilla was born, in the range 1..12. */
    public int month() {
        return month;
    }

    /** = the year this gorilla was born. */
    public int year() {
        return year;
    }

    /** = (pointer to) the object for mother of this gorilla (null if unknown). */
    public Gorilla mom() {
        return mom;
    }

    /** = (pointer to) the object for father of this gorilla (null if unknown). */
    public Gorilla pop() {
        return pop;
    }

    /** = the number of known children of this gorilla. */
    public int numChildren() {
        return children;
    }

    /** Set the gorilla's mom to mother. Precondition: this gorilla's mom is null, mother is not
     * null, and mother is female. */
    public void setMom(Gorilla mother) {
        assert mom == null;
        assert mother != null;
        assert mother.isFemale();
        mom= mother;
        mom.children++ ;
    }

    /** Set this gorilla's dad to father. Precondition: this gorilla's dad is null, father is not
     * null, and father is male. */
    public void setPop(Gorilla father) {
        assert pop == null;
        assert father != null;
        assert !father.isFemale();
        pop= father;
        pop.children++ ;
    }

    /** Constructor: a new Gorilla with name n, birth year y, birth month m, gender g,<br>
     * mother mother, father father, and no children.<br>
     * Precondition: n has at least one character in it, m is 1 for Jan, 2 for Feb, etc., <br>
     * g is 'f' or 'm' for female or male, mother is non-null and female, and <br>
     * father is non-null and male. */
    public Gorilla(String n, int y, int m, char g, Gorilla mother, Gorilla father) {
        assert n != null && 1 <= n.length();
        assert m >= 1 && m < 13;
        assert g == 'f' || g == 'm';
        assert mother != null & mother.isFemale();
        assert father != null & !father.isFemale();
        name= n;
        year= y;
        month= m;
        gender= g;
        setMom(mother);
        setPop(father);
    }

    /** = "r is not null and this gorilla was born before r." */
    public boolean isOlder(Gorilla r) {
        return r != null && (year < r.year || month < r.month && year == r.year);
    }

    /** = "this gorilla and r are siblings." <br>
     * Precondition: r is not null */
    public boolean areSiblings(Gorilla r) {
        assert r != null;
        return this != r && mom == r.mom && pop == r.pop;
    }
}
