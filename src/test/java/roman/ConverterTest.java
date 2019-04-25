package roman;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    @Test
    public void test_convert_roman_numeral_to_integer(){
        assertEquals(1, Converter.ConvertRomanNumeralToInteger("i"));
        assertEquals(1, Converter.ConvertRomanNumeralToInteger("I"));
        assertEquals(2, Converter.ConvertRomanNumeralToInteger("II"));
        assertEquals(3, Converter.ConvertRomanNumeralToInteger("IIi"));
        assertEquals(4, Converter.ConvertRomanNumeralToInteger("IV"));
        assertEquals(5, Converter.ConvertRomanNumeralToInteger("V"));
        assertEquals(6, Converter.ConvertRomanNumeralToInteger("VI"));
        assertEquals(7, Converter.ConvertRomanNumeralToInteger("VII"));
        assertEquals(9, Converter.ConvertRomanNumeralToInteger("IX"));
        assertEquals(10, Converter.ConvertRomanNumeralToInteger("X"));
        assertEquals(19, Converter.ConvertRomanNumeralToInteger("xix"));
        assertEquals(20, Converter.ConvertRomanNumeralToInteger("xx"));
        assertEquals(29, Converter.ConvertRomanNumeralToInteger("xxix"));
        assertEquals(39, Converter.ConvertRomanNumeralToInteger("xxxix"));
        assertEquals(40, Converter.ConvertRomanNumeralToInteger("xl"));
        assertEquals(44, Converter.ConvertRomanNumeralToInteger("xliv"));
        assertEquals(49, Converter.ConvertRomanNumeralToInteger("xlix"));
        assertEquals(50, Converter.ConvertRomanNumeralToInteger("l"));
        assertEquals(99, Converter.ConvertRomanNumeralToInteger("xcix"));
        assertEquals(100, Converter.ConvertRomanNumeralToInteger("c"));
        assertEquals(109, Converter.ConvertRomanNumeralToInteger("cix"));
        assertEquals(149, Converter.ConvertRomanNumeralToInteger("cxlix"));
        assertEquals(150, Converter.ConvertRomanNumeralToInteger("cl"));
        assertEquals(499, Converter.ConvertRomanNumeralToInteger("cdxcix"));
        assertEquals(800, Converter.ConvertRomanNumeralToInteger("dccc"));
        assertEquals(999, Converter.ConvertRomanNumeralToInteger("cmxcix"));
        assertEquals(1499, Converter.ConvertRomanNumeralToInteger("mcdxcix"));
        assertEquals(9999, Converter.ConvertRomanNumeralToInteger("mmmmmmmmmcmxcix"));
    }

    @Test
    public void test_convert_integer_to_roman_numeral(){
        assertEquals("I", Converter.ConvertIntegerToRomanNumeral(345));

    }
}