import lv.gb.unittest.hw1.CalculatorFolder.Calculator;
import lv.gb.unittest.hw3.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {


    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));


        /*
        * Позитивная проверка
        * */
        assertThat(Calculator.calculatingDiscount(100, 20)).isEqualTo(80);

        /*
        * Негативная проверка
        * */
//        assertThat(Calculator.calculatingDiscount(164.54, 20)).isEqualTo(144.54);
//
//        assertThatThrownBy(()->
//                Calculator.calculatingDiscount(1000,-10))
//                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void cirkle(){
        Calculator calculator = new Calculator();
        assertTrue(Math.abs(62 - calculator.computeLengthCircle(10)) < 1);
    }

 //Напишите тесты, покрывающие на 100% метод evenOddNumber.

    /**
     * Тест проверяющий четное ли число.
     * @return true
     */
    @Test
    public void testIsNumberEven(){
        Numbers number = new Numbers();
        assertTrue(number.evenOddNumber(0));
    }

    /**
     * Тест проверяющий нечетное ли число.
     * @return false
     */
    @Test
    public void testIsNumberOdd(){
        Numbers number = new Numbers();
        assertFalse(number.evenOddNumber(5));
    }

    /**
     * Тест проверяющий что число попадает в интервал.
     *@return true
     */
    @Test
    public void testNumberIsInInterval(){
        Numbers number = new Numbers();
        assertTrue(number.numberInInterval(45));
    }
    /**
     * Тест проверяющий, что число больше нижней границы.
     * @return true
     */
    @Test
    public void testNumberIsOnLowerBorder(){
        Numbers number = new Numbers();
        assertTrue(number.numberInInterval(26));
    }
    /**
     * Тест проверяющий, что число ниже верней границы.
     * @return true
     */
    @Test
    public void testNumberIsOnHigherBorder(){
        Numbers number = new Numbers();
        assertTrue(number.numberInInterval(99));
    }
    /**
     * Тест проверяющий, что число ниже нижней границы.
     * @return false
     */
    @Test
    public void testNumberIsUpperHigherBorder(){
        Numbers number = new Numbers();
        assertFalse(number.numberInInterval(100));
    }
    /**
     * Тест проверяющий, что число выше верней границы.
     * @return false
     */
    @Test
    public void testNumberIsBelowLowerBorder(){
        Numbers number = new Numbers();
        assertFalse(number.numberInInterval(25));
    }

}