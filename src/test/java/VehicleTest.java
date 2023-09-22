import lv.gb.unittest.hw2.Car;
import lv.gb.unittest.hw2.Motorcycle;
import lv.gb.unittest.hw2.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
/**
 * - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
 */
   @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    }
   /**
   * - проверка того, объект Car создается с 4-мя колесами
   */
    @Test
    public void testCarHas4Wheels(){
        Car car = new Car("Dodge", "Ram", 2010);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
     /**
     * - проверка того, объект Motorcycle создается с 2-мя колесами
     */
     @Test
    public void testMotorcycleHas2Wheels(){
         Motorcycle motorcycle = new Motorcycle("Suzuki", "MModel", 2012);
         assertThat(motorcycle.getNumWheels()).isEqualTo(2);
     }
    /**
     * - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    public void testCarTestDrive(){
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }
    /**
     * - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    public void testMotorcycleTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Suzuki", "MModel", 2012);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
     * машина останавливается (speed = 0)
     */
    @Test
    public void testCarStops(){
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0)
     */

    @Test
    public void testMotorcycleStops(){
        Motorcycle motorcycle = new Motorcycle("Suzuki", "MModel", 2012);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}
