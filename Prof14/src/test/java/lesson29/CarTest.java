package lesson29;

import lesson24.Car;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import static org.junit.Assert.assertTrue;

// https://hamcrest.org/JavaHamcrest/tutorial

public class CarTest {
    @Test
    public void propertyTest()
    {
        Car car = new Car("Peugeot", "407", 14_500);
        assertTrue(car instanceof Car);
        assertThat(car, instanceOf(Car.class));
        assertThat(car, hasProperty("price"));
        assertThat(car, hasProperty("model", equalTo("407")));
    }

    @Test
    public void testCars()
    {
        List<Car> cars = Arrays.asList(
                new Car("Peugeot", "407", 14_500),
                new Car("Toyota", "Celica", 24_700)
        );
        assertThat(cars, hasSize(2));
        assertThat(
                cars,
                everyItem(
                        hasProperty("price", greaterThan(10_000.0))
                )
        );
    }
}
