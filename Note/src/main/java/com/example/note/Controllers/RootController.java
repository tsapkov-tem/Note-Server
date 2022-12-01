package com.example.note.Controllers;

import com.example.note.Services.CurrentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RootController {
    public final CurrentModel currentModel;

    public RootController(CurrentModel currentModel) {
        this.currentModel = currentModel;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {
        currentModel.uploadCurrentUser();
        return "redirect:/swagger-ui/";
    }
}
