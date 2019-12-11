package ru.controller;

import org.apache.tomcat.jni.User;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.model.Person;
import ru.service.PersonService;
import ru.service.SecurityService;
import ru.validator.PersonValidator;

import javax.management.modelmbean.ModelMBeanOperationInfo;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private PersonValidator personValidator;
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("username", new Person());
        return "registartion";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registaration(@ModelAttribute("userForm") Person userForm, BindingResult bindingResult, Model model){
        personValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors())
            return "registrator";
        personService.save(userForm);
        securityService.autoLogin(userForm.getName(), userForm.getConfPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if( error != null)
            model.addAttribute("error", "username or password не верны.");
        if( logout != null)
            model.addAttribute("message", "Успешно.");
        return "login";
    }
    @RequestMapping(value = {"/", "welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
