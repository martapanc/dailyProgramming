package mockito.maths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){
        when(calcService.add(10.0, 20.0)).thenReturn(30.0);
        when(calcService.subtract(10.0, 20.0)).thenReturn(-10.0);

        assertEquals(30.0, mathApplication.add(10.0, 20.0),0.01);
        assertEquals(-10.0, mathApplication.subtract(10.0, 20.0), 0.01);
    }
}