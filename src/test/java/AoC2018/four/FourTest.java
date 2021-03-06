package AoC2018.four;

import org.junit.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourTest {

    //Sort entries by date and time
    //Get guard with most minutes asleep overall
    //Result is guard's ID * minute of most common asleep time

    @Test
    public void test_read_input_and_sort() {

    }

    @Test
    public void test_get_guard_with_most_time_asleep(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/AoC2018/four/out2"));
        assertEquals(10, Four.getGuardWithMostTimeAsleep(list));
    }

    @Test
    public void test_get_guard_with_most_time_asleep_2(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/AoC2018/four/out"));
        assertEquals(1487, Four.getGuardWithMostTimeAsleep(list));
    }

    @Test
    public void test_draw_sleep_pattern(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/AoC2018/four/out2"));
        Four.drawSleepPattern(10, list);
    }

    @Test
    public void test_draw_sleep_pattern_2(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/AoC2018/four/out"));
        Four.drawSleepPattern(1487, list);
    }
    //Result is 1487*34

    // Part 2 - Example
    // Matrix where x are the minutes and y are the guard IDs
    //   000000000011111111112222222222333333333344444444445555555555
    //   012345678901234567890123456789012345678901234567890123456789
    //10 .....11111111111111111112111101111111111111111111111111.....
    //99 ....................................1111222223222211111.....
    //
    // The result is the ID of the guard times the minute you chose (e.g. 99 * 45 = 4455)

    @Test
    public void test_sleep_count_matrix(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/AoC2018/four/out2"));
        Four.buildSleepCountMatrix(list);
    }

    @Test
    public void test_sleep_count_matrix_2(){
        List<GuardStatus> list = Four.sortInputByDate(Four.readInputAndParse("src/main/java/AoC2018/four/out"));
        Four.buildSleepCountMatrix(list);
    }

}
