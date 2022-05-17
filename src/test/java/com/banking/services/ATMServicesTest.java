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
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class ATMServicesTest {



    private ATMRepository atmRepository;
    private ATMService atmService;
    @BeforeEach
    public void setUp() {
        atmService = Mockito.mock(ATMFinderService.class);
        atmRepository = Mockito.mock(ATMRepository.class);

    }

    @Test
    @DisplayName("TC_01 Test Services ATM Identification function")
    public void getATMByIdentificationTest() {
        String id = "LFFFAC11";
        List<ATM> mockAtm = Arrays.asList(new ATM(id, Collections.singletonList("GB"), new Location()));
        Brand mockBrand = new Brand("Lloyds Bank", mockAtm);
        List<Brand> mockBrandList = Arrays.asList(mockBrand);
        ATMData mockAtmData = new ATMData(mockBrandList);
        List<ATMData> mockAtmDataList = Arrays.asList(mockAtmData);
        ATMResponse atmResponse = new ATMResponse(new Meta(), mockAtmDataList);
        Mockito.when(atmRepository.getATMs()).thenReturn(atmResponse);
        ATMFinderService atmFinderService =  new ATMFinderService(atmRepository);
        List<ATM> atmList = atmFinderService.getATMByIdentification(id);
        Assertions.assertEquals(1, atmList.size());

    }

    /**
     * ATM Service doesn't throw an exception. It uses Optional which returns an Option.Empty
     * This is a negative scenario, and it doesn't work because the repo is not mock correctly
     */
    @Test
    @DisplayName("TC_02 Test Services ATM Identification for null")
    public void getATMByNullIdentificationTest() {
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
        Assertions.assertEquals(0, atmList.size());
    }

}
