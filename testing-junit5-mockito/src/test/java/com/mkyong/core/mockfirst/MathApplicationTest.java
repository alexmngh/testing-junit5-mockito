package com.mkyong.core.mockfirst;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith( Mockito JUnitRunner.class)
@SpringBootTest
class MathApplicationTest {

  //@InjectMocks annotation is used to create and inject the mock object
  @InjectMocks
  MathApplication mathApplication = new MathApplication();

  //@Mock annotation is used to create the mock object to be injected
  @Mock
  CalculatorService calcService;

  @DisplayName("Test MathApplication + add")
  @Test
  void add() {
    //add the behavior of calc service to add two numbers
    when(calcService.add(10.0,20.0)).thenReturn(30.00);

    when(calcService.subtract(20.0,10.0)).thenReturn(10.00);


    //test the add functionality
    assertEquals(mathApplication.add(10.0, 20.0),30.0);
    assertEquals(mathApplication.add(10.0, 20.0),30.0);
    assertEquals(mathApplication.add(10.0, 20.0),30.0);
    assertEquals(mathApplication.subtract(20.0, 10.0),10.0);

    //Убедтимся что вызов calcService был выполнен именно с этими аргументами
    // verify(calcService).add(10.0, 20.0);
    // verify(calcService).add(20.0, 20.0); // Так тест уже не пройдет, т.к аргументы не те

    verify(calcService).subtract(20.0, 10.0);

    // Убедимся что метод add был вызван только три раза и с этими аргументами
    verify(calcService, times(3)).add(10.0, 20.0);
    // Убедимся что метод subtract был вызван только один раз
    verify(calcService, times(1)).subtract(20.0, 10.0);
    // Убедимся что метод multiply не вызывался ни разу
    verify(calcService, never()).multiply(10.0,20.0);

    // Ожидаем хотя бы один вызов метода
    verify(calcService, atLeastOnce()).subtract(20.0, 10.0);

    // Ожидаем минимум 2 вызова
    verify(calcService, atLeast(2)).add(10.0, 20.0);

    // Ожидаем максимум 3 вызова
    verify(calcService, atMost(3)).add(10.0,20.0);

  }
}
