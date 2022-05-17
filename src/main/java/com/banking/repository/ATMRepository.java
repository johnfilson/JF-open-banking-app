package com.banking.repository;

import com.banking.exception.DataAccessException;
import com.banking.model.ATMResponse;
import com.banking.util.BasicReadWebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;

@Repository
public class ATMRepository {

    /**
     * Calls to other API can go in the Repository Layer, sometime people put this call
     * in Service Layer, however, the Service layers doesn't care how it gets the data hence
     * when in we Test, we can Mock data and see how the Service layer behaviours
     */

    @Value("${open.banking.url}")
    private String url;

    private final BasicReadWebClient basicReadWebClient;

    public ATMRepository(BasicReadWebClient basicReadWebClient) {
        this.basicReadWebClient = basicReadWebClient;
    }

    @Cacheable("atmResponse")
    public ATMResponse getATMs() throws DataAccessException {
        var typeReference = new ParameterizedTypeReference<ATMResponse>() {
        };
        return basicReadWebClient.getData(url, typeReference);
    }

}
