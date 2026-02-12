package com.financial.cards.microservice.cards_svc.repository;

import com.financial.cards.microservice.cards_svc.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    Optional<Cards> findByCardNumber(String cardNumber);
    Optional<Cards> findByPhoneNumber(String phoneNumber);
}
