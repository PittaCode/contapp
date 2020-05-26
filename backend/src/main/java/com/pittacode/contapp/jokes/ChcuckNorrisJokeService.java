package com.pittacode.contapp.jokes;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChcuckNorrisJokeService implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    @Autowired
    public ChcuckNorrisJokeService(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @Override
    public String getRandomJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
