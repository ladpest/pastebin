package com.ldpst.paste_service.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ldpst.paste_service.entity.PasteEntity;
import com.ldpst.paste_service.model.Paste;
import com.ldpst.paste_service.model.ResponseWrapper;
import com.ldpst.paste_service.service.PasteService;


@RestController
@RequestMapping("/api/paste")
public class PasteController {
    private final PasteService pasteService;

    public PasteController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPaste(@RequestBody Paste paste) {
        pasteService.createPaste(paste);
        return ResponseEntity.status(201).body("Sucessful created");
    }
    
    @GetMapping("/get")
    public ResponseEntity<ResponseWrapper<PasteEntity>> getPaste(@RequestParam String uuid) {
        if (uuid == null || uuid.isEmpty()) {
            return ResponseEntity.status(400)
                .body(new ResponseWrapper<PasteEntity>()
                    .message("UUID param is not found")
                    .object(null)
                );
        }
        Optional<PasteEntity> optPaste = pasteService.getPaste(uuid);
        if (!optPaste.isPresent() || optPaste.get() == null) {
            return ResponseEntity.status(404)
                .body(new ResponseWrapper<PasteEntity>()
                    .message("Paste with UUID: \"" + uuid + "\" is not found")
                    .object(null)
                );
        }
        return ResponseEntity.status(200)
                .body(new ResponseWrapper<PasteEntity>()
                    .message(null)
                    .object(optPaste.get())
                );
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePaste(@RequestParam String uuid) {
        if (uuid == null || uuid.isEmpty()) return ResponseEntity.status(400).body("UUID param is not found");
        Optional<PasteEntity> optPaste = pasteService.getPaste(uuid);
        if (!optPaste.isPresent()) return ResponseEntity.status(404).body("Paste with UUID: \"" + uuid + "\" is not found");
        PasteEntity pasteEntity = optPaste.get();
        if (pasteEntity == null) return ResponseEntity.status(404).body("Paste with UUID: \"" + uuid + "\" is not found");

        pasteService.deletePaste(pasteEntity);
        return ResponseEntity.ok("Paste with UUID: \"" + uuid + "\" successful deleted");
    }
}
