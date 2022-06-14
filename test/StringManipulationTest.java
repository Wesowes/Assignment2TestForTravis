// Wesley So
// CS 410 Junit assignment
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedstring;

    @BeforeEach
    public void setUp() {
        manipulatedstring = new StringManipulation();
    }


    @AfterEach
    public void tearDown() {
        manipulatedstring = null;
    }

    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    } // test given by professor

    @Test //first case
    public void testCount2() {
        manipulatedstring.setString("H  e l l o");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    } // test to see if its counting the letters as "words", extra space included to test similar feature

    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }
    // test to see how it would react to an emptry string

    @Test
    public void testCount4() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }
    // test to see how it would react to a null string

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }
    // test given by professor

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }
    // test given by professor

    @Test // first test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("What is this program");
        assertEquals("W a   s t i   r g a ", manipulatedstring.removeNthCharacter(2, true));
    }
    // test to see if program did as intended

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("What is this program");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }
    // See if string was empty after every character was removed without spacing

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("What is this program");
        assertEquals("                    ", manipulatedstring.removeNthCharacter(1, true));
    }
    // See if string still had spacing after all characters removed with spacing

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Hello This is a throw test");
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, true));
        assertEquals("n must be greater than 0", exception.getMessage());
    }
    // test for error message of removing n = 0;

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("Hello This is a throw test");
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(100, true));
        assertEquals("Choose a number smaller than length of the string", exception.getMessage());
    }
    // test for error message of removing n = 100 Which is longer than manipulated string;

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
    // base case given by professor

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("1 2 3 4");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "3");
        assertEquals(sStings[1], "4");
    }
    // case to see if it works with all strings (aka numbers) as well as individual test of program
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("Hi how are you");
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0, 4));
        assertEquals("Input valid start and end word index", exception.getMessage());
    }
    // Test case error of startword being less than or equal to 0

    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Hi how are you");
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(4, 3));
        assertEquals("Input valid start and end word index", exception.getMessage());
    }
    // Test case error of startword being more than endword

    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("Hi how are you");
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(2, 5));
        assertEquals("End word is out of bounds of string words", exception.getMessage());
    }
    // test case error of endword being a higher index than how many words are in the String (Testing String length vs endword index)

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("Hi how are you");
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(1, 0));
        assertEquals("Input valid start and end word index", exception.getMessage());
    }
    // test case error of endWord being 0, (which happens before comparison of start and endword

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }
    // test case given by professor

    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "TestUnit");
    }
    // test case of longer string, similar to example given in interface(I assume the example was wrong)

    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2,3,8};
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(array));
        assertEquals("Please have the correct number of indexes", exception.getMessage());
    }
    // test case error with an extra index (larger than end index of string)

    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2,-1};
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
        assertEquals("Please input the correct indexes", exception.getMessage());
    }
    // test case error with an invalid index (replaed 3 with -1 to check below 0)

    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2,8};
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
        assertEquals("Please input the correct indexes", exception.getMessage());
    }
    // test case error with an invalid index (above string length (replaced 3 with 8)

}
