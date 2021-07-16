package catherine.demo.spring5jokesApp.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
//because we annotated it with service, it's going to become a spring managed bean. So spring is going
//to create an instance of this in the spring context
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    //no args constructor here. We are instantiating a new chuckNorrisQuotes here.
    //dependency injection in the future: when we call this class chuckNorrisQuotes
    //will be configured automatically
    public JokeServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
