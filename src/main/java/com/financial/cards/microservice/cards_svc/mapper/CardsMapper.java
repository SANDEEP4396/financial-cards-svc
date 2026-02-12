package com.financial.cards.microservice.cards_svc.mapper;

import com.financial.cards.microservice.cards_svc.dto.CardDTO;
import com.financial.cards.microservice.cards_svc.entity.Cards;

public class CardsMapper {
    public static CardDTO mapToCardDTO(Cards cards, CardDTO cardDTO) {
        cardDTO.setCardNumber(cards.getCardNumber());
        cardDTO.setCardType(cards.getCardType());
        cardDTO.setPhoneNumber(cards.getPhoneNumber());
        cardDTO.setTotalLimit(cards.getTotalLimit());
        cardDTO.setAvailableAmount(cards.getAvailableAmount());
        cardDTO.setAmountUsed(cards.getAmountUsed());
        return cardDTO;
    }

    @SuppressWarnings("unused")
    public static Cards mapToCards(CardDTO cardDTO, Cards cards) {
        cards.setCardNumber(cardDTO.getCardNumber());
        cards.setCardType(cardDTO.getCardType());
        cards.setPhoneNumber(cardDTO.getPhoneNumber());
        cards.setTotalLimit(cardDTO.getTotalLimit());
        cards.setAvailableAmount(cardDTO.getAvailableAmount());
        cards.setAmountUsed(cardDTO.getAmountUsed());
        return cards;
    }
}
