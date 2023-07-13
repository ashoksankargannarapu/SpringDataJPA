package com.nt.repository.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.promotions.Offers;

public interface IOfferRepo extends JpaRepository<Offers, Integer> {

}
