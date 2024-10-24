package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {

    private final TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();

    @Test
    public void testCalculatePremium() {
        Date agreementDateFrom = new Date(2024, 9, 24); // Месяц 9 - это октябрь
        Date agreementDateTo = new Date(2024, 10, 24);

        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                "Alexey", "Romanov", agreementDateFrom, agreementDateTo
        );

        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }
}