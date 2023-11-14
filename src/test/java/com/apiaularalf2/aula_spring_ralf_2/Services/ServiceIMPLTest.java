package com.apiaularalf2.aula_spring_ralf_2.Services;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import com.apiaularalf2.aula_spring_ralf_2.Models.Client;
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
    public static final Long ID = 20L;
    public static final String NAME = "JOSEFINA";
    public static final String EMAIL = "TESTANDOEMAIL";
    @InjectMocks
    private ClientService client;
    @Mock
    private ClientInterface clientRepository;
    Client test = new Client(ID,NAME,EMAIL);

    @Test
    void TestCriation(){
        when(clientRepository.registerClientDTO(any())).thenReturn(test);
    }

}
