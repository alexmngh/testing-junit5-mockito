package com.mkyong.core.services;

import com.mkyong.core.client.ReceiveClient;
import com.mkyong.core.repository.HelloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class) , need this? still able to run.
@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private HelloRepository helloRepository;

  @Mock
  private ReceiveClient receiveClient;



  //@Spy
    @InjectMocks // auto inject helloRepository
    private HelloService helloService = new HelloServiceImpl();

    @BeforeEach
    void setMockOutput() {
        //when(helloService.get()).thenReturn("Hello Mockito");
        when(helloRepository.get()).thenReturn("Hello Mockito From Responsitory");
        when(helloRepository.getName()).thenReturn("Name Bars");
        when(helloRepository.getNameCity()).thenReturn("Bern Alfa Jack");
        when(helloRepository.getCat()).thenReturn("Alfa");
        when(receiveClient.getMaster()).thenReturn(" Jack");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals("Hello Mockito From Responsitory", helloService.get());
    }

  @DisplayName("My Get Bars")
  @Test
  void testGetName() {
    assertEquals("Name Bars", helloService.getName());
  }

  @DisplayName("My Get Name")
  @Test
  void testGetNameCity() {
    assertEquals("Bern Alfa Jack", helloService.getNameCity());
  }

}
