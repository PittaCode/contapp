package com.pittacode.contapp.jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/jokes")
public class JokeController {

    private JokeService chuckNorrisJokes;

    @Autowired
    public JokeController(JokeService chuckNorrisJokes) {
        this.chuckNorrisJokes = chuckNorrisJokes;
    }

    @GetMapping(path = "/chuck-norris/random")
    public String getRandomChuckNorrisJoke(Model model) {
        String randomJoke = chuckNorrisJokes.getRandomJoke();
        model.addAttribute("randomJoke", randomJoke);

        return "joke";
    }
}
