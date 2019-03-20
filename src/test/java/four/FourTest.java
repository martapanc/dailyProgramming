package four;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourTest {

    //Sort entries by date and time
    //Get guard with most minutes asleep overall
    //Result is guard's ID * minutes of longest asleep time

    @Test
    public void test_read_input_and_sort() {

    }

    @Test
    public void test_get_guard_with_most_time_asleep(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/four/out2"));
        assertEquals(10, Four.getGuardWithMostTimeAsleep(list));
    }

    @Test
    public void test_get_guard_with_most_time_asleep_2(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/four/out"));
        assertEquals(3119, Four.getGuardWithMostTimeAsleep(list));
    }

}
