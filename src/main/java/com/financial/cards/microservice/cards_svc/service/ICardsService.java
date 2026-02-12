package com.financial.cards.microservice.cards_svc.service;

import com.financial.cards.microservice.cards_svc.dto.CardDTO;

public interface ICardsService {
    /**
     * Creates a new card for the customer based on the provided phone number.
     *
     * @param phoneNumber - Mobile Number of the Customer
     */
    void createCard(String phoneNumber);

    /**
     * Fetches the card details for a given phone number.
     *
     * @param phoneNumber - Input mobile Number
     * @return Card Details based on a given phoneNumber
     */
    CardDTO fetchCard(String phoneNumber);

    /**
     * Updates the card details based on the provided CardDTO object.
     *
     * @param cardDto - CardDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateCard(CardDTO cardDto);

    /**
     * Deletes the card details associated with the given phone number.
     *
     * @param phoneNumber - Input Mobile Number
     * @return boolean indicating if the delete of card details is successful or not
     */
    boolean deleteCard(String phoneNumber);
}
