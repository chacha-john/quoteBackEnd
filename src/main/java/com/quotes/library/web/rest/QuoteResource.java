package com.quotes.library.web.rest;

import com.quotes.library.domain.Quote;
import com.quotes.library.service.QuoteService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j @Data @RequestMapping("/quote")
public class QuoteResource {
    private final QuoteService quoteService;

    @PostMapping("/save")
    public Quote saveQuote(@RequestBody Quote quote){
        log.info("Requesting to save quote...");

        quoteService.saveQuote(quote);

        log.info("Quote {} saved successfully.",quote);

        return quote;
    }

    @DeleteMapping("/delete/{quoteId}")
    public Quote deleteQuote(@PathVariable Integer quoteId) throws Exception {
        log.info("Requesting to delete quote...");

        quoteService.deleteQuote(quoteId);

        log.info("Quote deleted successfully.");

        return null;
    }

    @GetMapping("/listall")
    public List<Quote> displayAllQuotes(){
        log.info("Request to display all quotes...");

        return quoteService.displayAllQuotes();

    }

/*    @GetMapping("/list/{quoteOwner}")
    public List<Quote> displayByOwner(@RequestParam String quoteOwner){
        log.info("Requesting to get quote owner");

        return quoteService.displayByOwner(quoteOwner);
    }*/
}
