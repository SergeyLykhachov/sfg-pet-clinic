package com.slykhachov.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"owners/index", "owners", "owners/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
