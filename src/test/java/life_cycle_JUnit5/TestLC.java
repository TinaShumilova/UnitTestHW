package life_cycle_JUnit5;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TestLC {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach");
    }

    @Test
    void testOne() {
        System.out.println("testOne");
    }

    @Test
    void testTwo() {
        System.out.println("testTwo");
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll");
    }

    @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("one");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

}
