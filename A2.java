import java.util.Arrays;

/** NetId: kmr262.

 * What I thought about this assignment: It was difficult to think of what each
 * function wanted first and then figure it out on paper before writing the code
 * then it was a whole new brain twister to figure out the code. I don't think I
 * would have been able to do it without the consultants or TA's hinting me along
 * the process. I also was unsure when looking in the API if I wanted a string
 * or character or array method to utilize.
 */

/** A collection of static functions. <br>
 * All methods assume that String parameters are non-null.
 *
 * If a method is called with arguments that do not satisfy the Preconditions,<br>
 * the behavior is undefined (the method can do anything). You do not have to use assert<br>
 * statements to test preconditions. We will not test with test cases that do <br>
 * not satisfy Preconditions. */
public class A2 {
    /* Each function you write has a "//TODO comment". Look on the right; click a blue
     * rectangle to get to the corresponding "//TODO comment". DO NOT DELETE THESE COMMENTS.
     *
     * Wherever possible, prefer library functions to writing your own loops.
     *
     * The more complicated your loops become, the more important it is to
     * explain the logic in comments.
     *
     * See the JavaHyperText entries for if-statement, while-loop, and for-loop.
     * Use of the break-statement and continue-statement is discouraged but not
     * forbidden. They make loops and programs harder to understand. Usually,
     * they can be eliminated by restructuring/reorganizing code.
     *
     * For some functions, you may be writing a loop to append character after
     * character to an initially empty string. See the JavaHyperText entry for
     * class StringBuilder and a discussion of why it may be better to use that
     * class for this purpose. But for this assignment, use either String or
     * StringBuilder, it doesn't matter which you use.
     *
     * We give complete test cases except for the last two methods. You need practice
     * in thinking about how to test well.
     *  */

    /** Replace "-1" by the time you spent on A2 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 6.25;

    /** Return either s1 + s2 or s1 - s2, depending on b. <br>
     * If b is true, return the sum, otherwise return the difference. */
    public static int sumDif(boolean b, int s1, int s2) {
        // This method is already implemented; it is here to
        // show you different ways of writing simple code.
        if (b) {
            int s;
            s= s1 + s2;
            return s;

            /* equivalently: int s = s1 + s2; return s;
             *
             * or simply: return s1 + s2;
             */
        }

        // b is false;
        return s1 - s2;
    }

    /** Return true iff (i.e. if and only if) s has an even number of characters and<br>
     * the two middle ones (if they exist) are different. <br>
     * Examples: <br>
     * For s = "" return true <br>
     * For s = "$" return false <br>
     * For s = "23" return true <br>
     * For s = "44" return false <br>
     * For s = "22AB" return true <br>
     * For s = "2AAB" return false <br>
     * For s = "abcdefaabcdefg" return false <br>
     * For s = "abcdef$abcdefg" return true <br>
     * For s = "aaaaaaaaaaaaaaaa" return false <br>
     * For s = "aaaaaaa$aaaaaaaa" return true */
    public static boolean isMidDiff(String s) {
        // TODO 1. There is no need for a loop. Do not use a loop.
        // This can be done cleanly in 8 statements or less.
        // Hint: Follow these Principles:
        // Principle: Avoid unnecessary case analysis
        // Principle: Avoid the same expression in several places.
        // Principle: Keep the structure of the method as simple as possible.
        if (s.length() % 2 != 0) { return false; }
        if (s.length() == 0) { return true; }
        return s.charAt(s.length() / 2) != s.charAt(s.length() / 2 - 1);
    }

    /** Return s but, for each character that is a lower-case letter in a..z, <br>
     * insert the corresponding upper-case letter after it. <br>
     * Examples: <br>
     * For s = "", return "". <br>
     * For s = "b", return "bB". <br>
     * For s = "B", return "B". <br>
     * For s = "å", return "å". <br>
     * For s = "$", return "$" <br>
     * For s = "1ABCDEFx", return "1ABCDEFxX".<br>
     * For s = "1Z$Bby", return "1Z$BbByY"<br>
     * For s = "abcdefghijklmnopqrstuvwxyz", <br>
     * ......... return "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ" */
    // char and int are interchangable int(a) = 96 also can compare primitive op on chars
    public static String addCapsToSmalls(String s) {
        /* TODO 2. Look at the fourth example, for s = "å".
         * 'å' is NOT a character in a..z, so a corresponding upper-case
         * letter is NOT added.
         * If this isn't working for you, you may be using Eclipse on a
         * Windows 10 computer, and the wrong Text File coding is being used.
         * It should be UTF-8. You have to change it.
         * Look at the last item on this JavaHyperText webpage to see how to do it:
         *   https://www.cs.cornell.edu/courses/JavaAndDS/eclipse/Ecl01eclipse.html
         */
        if (s.length() == 0) { return s; }
        // creates an empty string
        String t= "";

        for (int i= 0; i < s.length(); i++ ) {
            // looks at each index in string
            Character c= s.charAt(i);
            // adds c to string t
            t= t.concat(c.toString());
            // adds uppercase to t if index position is lowercase
            int a= 'a';
            int z= 'z';
            if (c >= a && c <= z) {
                Character b= Character.toUpperCase(c);
                t= t.concat(b.toString());
            }
        }

        return t;
    }

    /** Return s but with each occurrence of a letter in 'a'..'y' replaced by<br>
     * the following letter and 'z' replaced by 'a'.<br>
     * Examples: <br>
     * successor("") = "" <br>
     * successor("åç") = "åç" <br>
     * successor("abcdefghijklmnopqrstuvwxyz") = "bcdefghijklmnopqrstuvwxyza" <br>
     * successor("ABCDEFGHIJKLMNOPQRSTUVWXYZ") = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" <br>
     * successor("1z$aàēĤƀ") = "1a$bàēĤƀ" */
    // want s = "cs2110" return s = "dt2110" but when s="zoo" return s = "app"
    // create a new string and a for loop, look at each index
    // increment char by one
    public static String successor(String s) {
        // TODO 3. The same things about the UTF-8 encoding discussed in
        // the previous method addCapsToSmalls apply here also.
        // Hint: Follow these Principles:
        // Principle: Avoid unnecessary case analysis like the plague.
        // Principle: Avoid "magic numbers" ---the use of int constants for characters.
        // ... If you don't know what this means, look up "magic numbers" in JavaHyperText.
        // Principle: Use short names where long mnemonic names are unnecessary.
        if (s.length() == 0) { return s; }
        String tmp= "";
        for (int i= 0; i < s.length(); i++ ) {
            Character x= s.charAt(i);
            if (x >= 'a' && x < 'z') {
                // adds the following char to the already defined string tmp
                tmp= tmp + (char) (x + 1);
                // turns z into a
            } else if (x == 'z') {
                tmp= tmp + 'a';
            } else {
                tmp= tmp + x;
            }
        }
        return tmp;
    }

    /** Precondition: s and s1 are not null. <br>
     * Return true iff s contains more than one occurrence of s1. <br>
     * Examples: For s = "" and s1 = "", return false <br>
     * For s = "a" and s1 = "", return true: <br>
     * .... The empty string occurs before and after each character! <br>
     * For s = "abc" and s1 = "", return true <br>
     * For s = "" and s1 = "a", return false. <br>
     * For s = "abcb" and s1 = "c", return false. <br>
     * For s = "acbc" and s1 = "c", return true. <br>
     * For s = "abbc" and s1 = "ab", return false. <br>
     * For s = "aaa" and s1 = "aa", return true. <br>
     * For s = "abbbabc" and s1 = "ab", return true. */
    public static boolean moreThan1(String s, String s1) {
        // TODO 4 Do not use a loop or recursion. Instead, look through the
        // methods of class String and see how you can tell that the first
        // and last occurrences of s1 in s are the same occurrence. Be sure
        // you handle correctly the case that s1 does not occur in s.
        //
        // Hint: Follow this Principle:
        // Principle: Be aware of efficiency considerations.
        // Note that a call like s.indexOf(s1) may take time proportional to the
        // length of string s. If s contains 1,000 characters and s1 contains 5 chars,
        // then about 9996 tests may have to be made in the worst case. So you don't
        // want to have the same method call executed several times. Even the call
        // of contains in the code below is wasteful.
        //
        // if (s.contains(s1)) {
        // int k= s.indexOf(s1);
        // ...
        // }
        // look at first occurance of s1 from left
        // look for second occruance from right side if they equal each other
        // then theres only one, not equal then more than one occurance

        if (s.length() == 0 && s1.length() >= 0) { return false; }
        if (s.length() > 0 && s1.length() == 0) { return true; }

        return s.indexOf(s1) != s.lastIndexOf(s1);

    }

    /** Return true iff s and u are anagrams.<br>
     * Note: 2 strings are anagrams of each other if swapping the characters<br>
     * around in one changes it into the other.<br>
     * Note: 'a' and 'A' are different chars, and the space ' ' is a character.
     *
     * Examples: For s = "noon", u = "noon", return true. <br>
     * For s = "mary", u = "army", return true. <br>
     * For s = "tom marvolo riddle", u = "i am lordvoldemort", return true. <br>
     * For s = "tommarvoloriddle", u = "i am lordvoldemort", return false. <br>
     * For s = "hello", u = "world", return false. */
    public static boolean haveSameChars(String s, String t) {
        // TODO 5
        /* Do not use a loop or recursion! This can be done in
         * five lines using methods of classes String and Arrays
         * (https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html).
         * Hint: how can a sequence of characters be uniquely ordered? You might
         * need to first convert the string into an array of characters and then
         * use methods in class Arrays. */
        // sort and compare. string into char array and sort
        if (s.equals(t)) { return true; }
        // cast string to car array
        char tmpArrayS[]= s.toCharArray();
        char tmpArrayt[]= t.toCharArray();
        // sort the arrays
        Arrays.sort(tmpArrayS);
        Arrays.sort(tmpArrayt);
        // cast arrays back to strings
        String newS= new String(tmpArrayS);
        String newt= new String(tmpArrayt);
        // return true if the strings are equal
        return newS.equals(newt);
    }

    /** Return n iff s consists of x catenated with itself n times<br>
     * (return 0 if n in the line above does not exist).<br>
     * Examples: <br>
     * For nCat("", "") return 1<br>
     * For nCat("xxx", "") return 0<br>
     * For nCat("x", "x") return 1 <br>
     * For nCat("", "x") return 0 <br>
     * For nCat("xx", "x") return 2 <br>
     * For nCat("ccbbbb", "bb") return 0 <br>
     * For nCat("bbbbcc", "bb") return 0 <br>
     * For nCat("bbbbbb", "bb") return 3 <br>
     * For nCat("bbbbbb", "bbb") return 2 <br>
     * For nCat("bbbbbb", "bbbb") return 0 <br>
     * For nCat("bbbbbb", "bbbbb") return 0 <br>
     * For nCat("bbbbbb", "bbbbbb") return 1 <br>
     * For nCat("bbbbbb", "bbbbbbb") return 0 <br>
     * For nCat("xyzxyz", "xyz") return 2 <br>
     * For nCat("xyzxyz", "xyzxyz") return 1 <br>
     * For nCat(s, s) (for any s) return 1 */
    public static int nCat(String s, String x) {
        // TODO 6. Directive. Do NOT create an array of chars simply to make
        // testing easier. Just use the two strings s and x and perhaps a
        // few local variables.
        // Hint: Follow this Principle:
        // Make the structure of a loop reflect the structure of the data it processes.
        // Use function equals, not ==, to test equality of strings.
        // s must consist fully of x, s must be multiple versions of x, return
        // the number of versions of x that make up s
        // look at each index in s and each index in x
        // s = cs2110 x = rq2
        if (s.equals(x)) return 1;
        if (x.length() == 0 && s.length() == 0) return 1;
        if (x.length() == 0) return 0;
        if (x.length() > s.length() || s.length() % x.length() != 0)
            return 0;
        int n= 0;
        for (int i= 0; i < s.length(); i= i + x.length()) {
            n= n + 1;
            // looks at substring of s from index i to length of x to see if
            // substring is equal to s
            if (!s.substring(i, i + x.length()).equals(x)) return 0;
        }
        return n;
    }

    /** Return the shortest substring x of s such that s = x + x + ... + x. <br>
     * Examples: For s = "" return ""<br>
     * For s = "xxxxxxxxx" return "x" <br>
     * For s = "xyxyxyxy" return "xy" <br>
     * For s = "012012012012" return "012" <br>
     * For s = "hellohellohello" return "hello" <br>
     * For s = "hellohelloworld" return "hellohelloworld" <br>
     * For s = "hellohell" return "hellohell" */
    public static String findShort(String s) {
        // TODO 7.
        // 1. To implement this one, start checking for the shortest
        // substring to have length 1, then 2, then 3, and stop when
        // the answer is found. To make each of those checks,
        // use the previous method nCat.
        //
        // 2. If the answer is found within a loop body, it is best to have
        // the method return from within the loop body. That is far better than having
        // a break statement and then fiddling after the loop to figure out what
        // to return.

        // 3. Note that nCat(s, s) = 1, for any s.

        for (int i= 0; i < s.length(); i++ ) {
            // define a new string newx that is a substring of s and look at the
            // indices until finds substring within s and repeats
            String newx= s.substring(0, i + 1);
            // if below statement true, means that s does contain at
            // least 1 version of x
            if (nCat(s, newx) > 0) { return newx; }
        }
        // if the if statement returns 0 then s does not contain any version of x
        return s;
    }
}
