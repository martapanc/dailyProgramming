package AoC2018.seventeen;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeventeenTest {

    private final String input1 = "src/test/java/AoC2018/seventeen/input1";
    private final String input2 = "src/test/java/AoC2018/seventeen/input2";

    @Test
    public void test_readInput(){
        Seventeen.readInput(input2);
    }
}