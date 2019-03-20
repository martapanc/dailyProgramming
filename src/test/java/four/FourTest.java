package four;

import org.junit.Test;

public class FourTest {

    //Sort entries by date and time
    //Get guard with most minutes asleep overall
    //Result is guard's ID * minutes of longest asleep time

    @Test
    public void test_read_input_and_sort() {

        Four.sortInputByDate(Four.readInputAndParse());

    }

}
