package com.banking.services;

import com.banking.model.*;
import com.banking.repository.ATMRepository;
import com.banking.service.ATMFinderService;
import com.banking.service.ATMService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ATMServicesTest {

    private ATMService atmService;
    private ATMRepository atmRepository;


    @BeforeEach
    public void setUp() {
        atmService = Mockito.mock(ATMFinderService.class);
        atmRepository = Mockito.mock(ATMRepository.class);

    }


    @Test
    @DisplayName("TC_01 Test Services ATM Identification function")
    public void getATMByIdentificationTest() {
        String id = "TestID";
        List<ATM> mockAtm = Arrays.asList(new ATM(id, Collections.singletonList("GB"), new Location()));
        Brand mockBrand = new Brand("Lloyds Bank", mockAtm);
        List<Brand> mockBrandList = Arrays.asList(mockBrand);
        ATMData mockAtmData = new ATMData(mockBrandList);
        List<ATMData> mockAtmDataList = Arrays.asList(mockAtmData);
        ATMResponse atmResponse = new ATMResponse(new Meta(), mockAtmDataList);
        Mockito.when(this.atmRepository.getATMs()).thenReturn(atmResponse);
        System.out.println(this.atmRepository.getATMs());
        List<ATM> atmList = this.atmService.getATMByIdentification(id);
        Assertions.assertEquals(1, atmList.size());
        Mockito.verify(atmService, Mockito.times(1));
    }

    /**
     * ATM Service doesn't throw an exception. It uses Optional which returns an Option.Empty
     */
    @Test
    @DisplayName("TC_02 Test Services ATM Identification for null exception")
    public void getATMByNullIdentificationTest() {
        Mockito.when(atmService.getATMByIdentification(null)).thenReturn(null);
        Mockito.verify(atmService, Mockito.times(1));
    }

    /**
     * This is a simple silly test to show that call ATMService is only get called once
     */
    @Test
    @DisplayName("TC_03 Test Services ATM Identification called once")
    public void getATMByIdentificationTest2() {
        String id = "23";
        List<ATM> mockAtmResponse = Arrays.asList(new ATM("ABCD", Collections.singletonList("GB"), new Location()));
        Mockito.when(this.atmService.getATMByIdentification(id)).thenReturn((List<ATM>) mockAtmResponse);
        List<ATM> atmList = atmService.getATMByIdentification(id);
        Assertions.assertEquals(1, atmList.size());
        Mockito.verify(atmService, Mockito.times(1));

    }
}
