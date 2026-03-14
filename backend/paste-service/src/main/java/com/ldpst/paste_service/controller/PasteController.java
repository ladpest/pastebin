package com.ldpst.paste_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paste")
public class PasteController {
    @GetMapping("/create")
    public String createPaste() {
        return "Paste created";
    }
}
