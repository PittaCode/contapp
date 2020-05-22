package com.pittacode.contapp.jokes;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class ChcuckNorrisJokeService implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public ChcuckNorrisJokeService() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getRandomJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
