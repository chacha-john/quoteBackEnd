package com.quotes.library.domain;

import lombok.Data;

import javax.persistence.*;

@Data @Entity @Table(name = "tbl_quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quoteId;

    private final String quoteMessage;

    private final String quoteOwner;

    private final String quoteOwnerDescription;
}
