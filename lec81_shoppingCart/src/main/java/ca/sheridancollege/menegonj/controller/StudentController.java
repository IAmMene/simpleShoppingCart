package ca.sheridancollege.menegonj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.menegonj.beans.Phone;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("phones", new ArrayList<Phone>());
        }

        model.addAttribute("phone", new Phone());
        return "index";
    }

    @GetMapping ("/test")
    public String test (Model model, HttpSession session, @ModelAttribute Phone phone) {
    	session.invalidate(); 
    return "index";
    }
    
    @PostMapping("/insertPhone")
    public String insertPhone(@ModelAttribute Phone phone, HttpSession session, Model model) {
        List<Phone> phones = (List<Phone>) session.getAttribute("phones");

        if (phones == null) {
            phones = new ArrayList<>();
        }

        phones.add(phone);
        session.setAttribute("phones", phones);

        model.addAttribute("phone", new Phone());

        return "index";
    }
}
