package edu.yuryan.spring.controllers;

import edu.yuryan.spring.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //Fetching all people from DAO and send them to representation in the browser
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("{id}")  //Such syntax allows to get the parameter from search line and put it in the variable
    public String show(@PathVariable("id") int id, Model model) {
        //Fetching one person by ID and send s/he to representation in the browser
        model.addAttribute("person", personDAO.show(id));
        return  "people/show";
    }
}
