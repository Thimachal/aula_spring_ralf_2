package com.apiaularalf2.aula_spring_ralf_2.Services;

import com.apiaularalf2.aula_spring_ralf_2.Services.IMPL.ClientInterface;
import com.apiaularalf2.aula_spring_ralf_2.Services.IMPL.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceIMPLTest {
    public static final Integer ID = 20;
    public static final String NAME = "JOSEFINA";
    public static final String EMAIL = "TESTANDOEMAIL";
    @InjectMocks
    private ClientService client;
    @Mock
    private ClientInterface clientRepository;

    @Test
    void TestCriation(){
        when(clientRepository.registerClientDTO(any())).thenReturn();
    }

}
