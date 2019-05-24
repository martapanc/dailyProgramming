package mockito.annotations;

import org.junit.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class MyClassTest {

    @Spy
    private MyClass myClass;

    @Test
    public void test(){

        /*
        * Both approaches behave differently if you use a spied object instead of a mock:
        *
        * when(...) thenReturn(...) makes a real method call just before the specified value will be returned.
        *   So if the called method throws an Exception you have to deal with it / mock it etc.
        *   Of course you still get your result (what you define in thenReturn(...))
        *
        * doReturn(...) when(...) does not call the method at all.
        * */

        // would work fine
        doReturn("test").when(myClass).anotherMethodInClass();

        // would throw a NullPointerException
        when(myClass.anotherMethodInClass()).thenReturn("test");
    }

}