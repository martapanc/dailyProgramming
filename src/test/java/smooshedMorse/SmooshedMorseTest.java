package smooshedMorse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmooshedMorseTest {

    @Test
    public void testSmooshedMorseEncoding() {
        assertEquals("...---...", SmooshedMorse.encode("sos"));
        assertEquals("-...-...-..-.--", SmooshedMorse.encode("daily"));
        assertEquals(".--..-.-----..-..-----..-.", SmooshedMorse.encode("programmer"));
        assertEquals("-.....-...", SmooshedMorse.encode("bits"));
        assertEquals("-.....-...", SmooshedMorse.encode("three"));
    }

    @Test
    public void testFindEncodingWith15Dashes() {
        SmooshedMorse.findEncodingWith15Dashes();
    }

    @Test
    public void testFindSameSequenceFor13DifferentWords() {
        SmooshedMorse.findSameSequenceFor13DifferentWords();
    }
}