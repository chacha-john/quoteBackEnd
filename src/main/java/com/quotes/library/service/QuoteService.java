package com.quotes.library.service;

import com.quotes.library.domain.Quote;
import com.quotes.library.repo.QuoteRepo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.env.spi.QualifiedObjectNameFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service @Data @Slf4j
public class QuoteService {
    private final QuoteRepo quoteRepo;

    public Quote saveQuote(Quote quote){
        log.info("About to save quote");

        quoteRepo.save(quote);

        log.info("Request to save quote {} successful",quote);

        return quote;
    }

    public Quote deleteQuote(Integer quoteId) throws Exception {

        Optional<Quote> optionalQuote = quoteRepo.findById(quoteId);

        if (optionalQuote.isPresent()){

            Quote quote = optionalQuote.get();

            log.info("About to delete quote {}",quote);

            quoteRepo.delete(quote);

            log.info("Quote {} has been deleted",quote);
        }
        else{
            throw new Exception("Quote does not exist!");
        }
        return null;
    }

    public List<Quote> displayAllQuotes(){
        log.info("About to display all quotes");

        List<Quote> quoteList = new ArrayList<>();

        Iterable<Quote> quoteIterable = quoteRepo.findAll();

        for(Quote quote:quoteIterable){
            quoteList.add(quote);
        }

        return quoteList;

    }

/*    public Quote editQuote(Quote quote){
        quote.setQuoteOwner(quote.getQuoteOwner());
        quote.setQuoteMessage(quote.getQuoteMessage());
        quote.setQuoteOwnerDescription(quote.getQuoteOwnerDescription());
        return quote;
    }*/

/*    public List<Quote> displayByOwner(String quoteOwner){
        List<Quote> quoteList = new ArrayList<>();

        Iterable<Quote> quoteIterable = quoteRepo.findByQuoteOwner(quoteOwner);

        for(Quote quote1:quoteIterable){
            quoteList.add(quote1);
        }

        return quoteList;
    }*/

}
