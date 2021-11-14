package com.quotes.library.repo;

import com.quotes.library.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepo extends JpaRepository<Quote,Integer> {
    Iterable<Quote> findByQuoteOwner(String quoteOwner);
}
