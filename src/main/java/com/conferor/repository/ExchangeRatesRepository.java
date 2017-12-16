package com.conferor.repository;

import com.conferor.model.ExchangeRates;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeRatesRepository extends MongoRepository<ExchangeRates, String> {

}
