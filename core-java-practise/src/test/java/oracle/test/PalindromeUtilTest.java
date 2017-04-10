package oracle.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 */
public class PalindromeUtilTest {

    @Rule
    public ExpectedException throwen=ExpectedException.none();

    @Test
    public void whenStringIsPallindromeShouldReturnTrue(){
        String str="MADAMa";
        boolean actual=PalindromeUtil.isPalindrome(str);
        Assert.assertTrue("expected true but got false",actual);
    }
    @Test
    public void whenStringIsNotPallindromeShouldReturnFalse(){
        String str="MADAMA";
        boolean actual=PalindromeUtil.isPalindrome(str);
        Assert.assertFalse("expected False but got true",actual);
    }

    @Test
    public void whenNullIspassedShouldThrowIllegalArgumentException(){
        throwen.expect(IllegalArgumentException.class);
        throwen.expectMessage("String can not be empty");
        PalindromeUtil.isPalindrome(null);

    }
}