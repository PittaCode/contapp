package config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

//@Configuration
public class JokeConfiguration {

    //    @Bean
    public ChuckNorrisQuotes chuckNorrisQuotes() {
        return new ChuckNorrisQuotes();
    }
}
