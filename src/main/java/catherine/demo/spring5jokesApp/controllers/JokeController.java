package catherine.demo.spring5jokesApp.controllers;

import catherine.demo.spring5jokesApp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//spring stereotype
@Controller
public class JokeController {
    // bring in the joke service
    private final JokeService jokeService;

    //this constructor will initialize the jokeService
    //code to an interface for dependency injection
    //because we have a construct around jokeservice, it will be injected into this class
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    //give us the path: index or index.html
    //when a request come to it, going to the root of the context that is running the application
    //context, we will invoke this method for the request to be processed
    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        //add in joke property. model is a map implementation, so we are adding in a property
        //with the string of joke so we'll be able to reference this from our view
        model.addAttribute("joke", jokeService.getJoke());

        //tell MVC that we want to do the index view
        //tells thymeleaf to look for a template file under templates called index
        return "index";
    }
}
