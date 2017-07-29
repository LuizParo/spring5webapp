package guru.springframework.spring5webapp.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.spring5webapp.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public ModelAndView getAuthors() {
        return new ModelAndView("authors")
            .addObject("authors", this.authorRepository.findAll());
    }
}