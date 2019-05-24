package mockito;

import mockito.annotations.MyDictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationTest {

    // Alternative to @RunWith(MockitoJUnitRunner.class)
    /*@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    /**
     * @Mock
     * */
    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    // Same as above with the @Mock notation
    @Mock
    List<String> mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        // Both of the following work

//        Mockito.doReturn(100).when(mockedList).size();
        Mockito.when(mockedList.size()).thenReturn(100);

        assertEquals(100, mockedList.size());
    }

    /**
     * @Spy
     * */
    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<>());

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());

        // Both of the following work

//        Mockito.doReturn(100).when(spyList).size();
        Mockito.when(spyList.size()).thenReturn(100);
        assertEquals(100, spyList.size());
    }

    // Same as above but with the @Spy annotation
    @Spy
    List<String> spiedList = new ArrayList<>();

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjected() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }


    /**
     * @Captor
     * */
    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());

        assertEquals("one", arg.getValue());
    }

    @Mock
    List mockedList2;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList2.add("one");
        Mockito.verify(mockedList2).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }

    /**
     * @InjectMocks
     * */

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }

    /*
    * doReturn() ... when()  VS  when() ... thenReturn()
    * The two syntaxes for stubbing are roughly equivalent. However, you can always use doReturn/when for stubbing;
    * but there are cases where you can't use when/thenReturn. Stubbing void methods is one such.
    * Others include use with Mockito spies, and stubbing the same method more than once.
    *
    * One thing that when/thenReturn gives you, that doReturn/when doesn't, is type-checking of the value that
    * you're returning, at compile time. However, I believe this is of almost no value - if you've got the type wrong,
    * you'll find out as soon as you run your test.
    * */
}