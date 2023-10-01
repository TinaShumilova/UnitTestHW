import lv.gb.unittest.hw6.model.Average;
import lv.gb.unittest.hw6.view.ConsoleUI;
import lv.gb.unittest.hw6.model.ListOfNumbers;
import lv.gb.unittest.hw6.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListTest {


    /**
     * Данный тест проверяет что:
     * 1. Списку можно задать определённое значение с помощью метода setNumberList.
     * 2. Информацию о списке можно вернуть пользователю в виде строки.
     */
    @Test
    public void testSetList(){
        ListOfNumbers l1 = new ListOfNumbers();
        Integer[] array = {3, 5, 4, 6, 7, 4};
        l1.setNumberList(array);
        assertThat(l1.getInfo()).isEqualTo("List of numbers: 3, 5, 4, 6, 7, 4, ");
    }

    /**
     * Данный тест проверяет, что в список можно положить рандомные значения задав определённый размер спискаю
     */
    @Test
    public void testRandomList(){
        ListOfNumbers list = new ListOfNumbers();
        list.randomSetList(10);
        assertThat(list.getSize()).isEqualTo(10);
    }

    /**
     * Данный тест что, метод findAverage верно рассчитывает среднее значение из заданного списка чисел
     */
    @Test
    public void testAverageNumberInList(){
        Integer[] array = {3,5,4,6,7,4};
        ListOfNumbers list = new ListOfNumbers(array);
        Average average = new Average();
        average.findAverage(list);
        assertEquals(4.833333333333333, average.findAverage(list));
    }

    /**
     * Данный тест проверяет что, при сравнении среднего значения чисел в дву списка - второе значение больше
     */
    @Test
    public void testSecondAverageIsLarger(){
        ListOfNumbers list1 = new ListOfNumbers();
        ListOfNumbers list2 = new ListOfNumbers();
        Average average = mock(Average.class);
        when(average.largerAverageOfList(list1, list2)).thenReturn("Второй список имеет большее среднее значение");
        average.largerAverageOfList(list1,list2);
        assertEquals("Второй список имеет большее среднее значение", average.largerAverageOfList(list1,list2));
    }

    /**
     * Данный тест проверяет что, при сравнении среднего значения чисел в дву списка - первое значение больше
     */
    @Test
    public void testFirstAverageIsLarger(){
        Integer[] array1 = { 76, 59, 24, 25, 90}; //54.8
        Integer[] array2 = { 71, 77, 27, 26, 9}; //42.0

        ListOfNumbers list1 = new ListOfNumbers();
        list1.setNumberList(array1);
        ListOfNumbers list2 = new ListOfNumbers(array2);

        Average a1 = new Average();

        assertEquals("Первый список имеет большее среднее значение",a1.largerAverageOfList(list1,list2));
    }

    /**
     * Данный тест проверяет что, при сравнении среднего значения чисел в двух списка - оба значения равны
     */
    @Test
    public void testBothAveragesSimilar(){
        Integer[] array1 = { 76, 59, 24, 25, 90}; //54.8
        Integer[] array2 = {  76, 59, 24, 25, 90}; //54.8

        ListOfNumbers list1 = new ListOfNumbers();
        list1.setNumberList(array1);
        ListOfNumbers list2 = new ListOfNumbers(array2);

        Average a1 = new Average();

        assertEquals("Средние значения равны",a1.largerAverageOfList(list1,list2));
    }

    /**
     * Данный тест проверяет что, при взаимодействии с интерфейсом, пользователь получает результат "No data"б если
     * не было выполнено никаких действий по сравнению данных.
     * Данный тест имитирует работу пользователя.
     */
    @Test
    public void testgetAnswerNodata(){
        View view = new ConsoleUI();
        assertEquals("No data", view.getAnswer());
    }

    /**
     * Данный тест проверяет что, при взаимодействии с интерфейсом, пользователь получает результат "Второй список
     * имеет большее среднее значение", если при сравнении данных среднее значение второго списка больше.
     * Данный тест имитирует работу пользователя.
     */
    @Test
    public void testgetAnswerWithData1(){
        View view = new ConsoleUI();
        view.execute();

        String expectedResult = "Второй список имеет большее среднее значение";
        assertEquals(expectedResult, view.getAnswer());
    }

}
