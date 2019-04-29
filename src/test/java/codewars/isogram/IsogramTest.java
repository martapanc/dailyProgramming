package codewars.isogram;

import codewars.Isogram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsogramTest {

    @Test
    void isIsogram() {
        assertEquals(true, Isogram.isIsogram("Dermatoglyphics"));
        assertEquals(true, Isogram.isIsogram("Isogram"));
        assertEquals(false, Isogram.isIsogram("moose"));
        assertEquals(false, Isogram.isIsogram("isIsogram"));
        assertEquals(false, Isogram.isIsogram("aba"));
        assertEquals(false, Isogram.isIsogram("moOse"));
        assertEquals(true, Isogram.isIsogram("thumbscrewjapingly"));
        assertEquals(true, Isogram.isIsogram(""));
    }

    @Test
    void isIsogram2() {
        assertEquals(true, Isogram.isIsogram2("Dermatoglyphics"));
        assertEquals(true, Isogram.isIsogram2("Isogram"));
        assertEquals(false, Isogram.isIsogram2("moose"));
        assertEquals(false, Isogram.isIsogram2("isIsogram"));
        assertEquals(false, Isogram.isIsogram2("aba"));
        assertEquals(false, Isogram.isIsogram2("moOse"));
        assertEquals(true, Isogram.isIsogram2("thumbscrewjapingly"));
        assertEquals(true, Isogram.isIsogram2(""));
    }
}