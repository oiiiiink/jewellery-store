package by.grsu.jewellerystore.controller;

import by.grsu.jewellerystore.dto.FeedbackDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingsController {

    @GetMapping("")
    public String getStartPage(Model model) {
        model.addAttribute("feedBack", new FeedbackDto());

        return "index.html";
    }

}
