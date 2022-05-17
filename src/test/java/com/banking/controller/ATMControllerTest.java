package com.banking.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class ATMControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String Identification = "LFFFBC11";
    private static final String SupportedCurrencies = "GBP";
    private static final String TownName = "CONSETT";

    private static final String AddressLine = "1 VICTORIA ROAD;";
/**

 */
    @Test
    @DisplayName("TC_01 Get ATM details with a Valid ID")
    public void getAtmControllerTestWithValidID() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/atms?")
                        .param("identification", "LFFFBC11"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Identification").value(Identification))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].SupportedCurrencies").value(SupportedCurrencies))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Location.PostalAddress.TownName").value(TownName))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Location.PostalAddress.AddressLine").value(AddressLine));

    }

    /**
     *
     * @throws Exception I could validate the Bad Request if it was a customised response
     */
    @Test
    @DisplayName("TC_02 Negative Test scenario ATM ID NULL")
    public void getAtmControllerTestWithInvalidID() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/atms?")
                        .param("identification",(String)null))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest());
    }

    /**
     *
     * @throws Exception I could validate the Not Found Message but in this case it's standard
     */
    @Test
    @DisplayName("TC_03 Negative Test scenario Wrong URL Template")
    public void getAtmControllerTestWithUnreachable() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("identification","LFFFBC11"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
    }

}

