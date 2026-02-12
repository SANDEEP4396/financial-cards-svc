package com.financial.cards.microservice.cards_svc.service.impl;

import com.financial.cards.microservice.cards_svc.constants.CardConstants;
import com.financial.cards.microservice.cards_svc.dto.CardDTO;
import com.financial.cards.microservice.cards_svc.entity.Cards;
import com.financial.cards.microservice.cards_svc.exception.CardAlreadyExistsException;
import com.financial.cards.microservice.cards_svc.exception.ResourceNotFoundException;
import com.financial.cards.microservice.cards_svc.mapper.CardsMapper;
import com.financial.cards.microservice.cards_svc.repository.CardsRepository;
import com.financial.cards.microservice.cards_svc.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    /**
     * @param phoneNumber - Mobile Number of the Customer
     */
    @Override
    public void createCard(String phoneNumber) {
        Optional<Cards> optionalCards = cardsRepository.findByPhoneNumber(phoneNumber);
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given phoneNumber " + phoneNumber);
        }
        cardsRepository.save(createNewCard(phoneNumber));
    }

    /**
     * @param phoneNumber - Mobile Number of the Customer
     * @return the new card details
     */
    private Cards createNewCard(String phoneNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setPhoneNumber(phoneNumber);
        newCard.setCardType(CardConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    /**
     *
     * @param phoneNumber - Input mobile Number
     * @return Card Details based on a given phoneNumber
     */
    @Override
    public CardDTO fetchCard(String phoneNumber) {
        Cards cards = cardsRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "phoneNumber", phoneNumber)
        );
        return CardsMapper.mapToCardDTO(cards, new CardDTO());
    }

    /**
     *
     * @param cardsDto - CardDTO Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateCard(CardDTO cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    /**
     * @param phoneNumber - Input phoneNumber
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Override
    public boolean deleteCard(String phoneNumber) {
        Cards cards = cardsRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "phoneNumber", phoneNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
