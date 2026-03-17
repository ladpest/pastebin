package com.ldpst.paste_service.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.ldpst.paste_service.entity.PasteEntity;
import com.ldpst.paste_service.model.Paste;
import com.ldpst.paste_service.repository.PasteRepository;

import jakarta.transaction.Transactional;

@Service
public class PasteService {
    private final PasteRepository pasteRepository;

    public PasteService(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    @Transactional
    public PasteEntity createPaste(Paste paste) {
        PasteEntity pasteEntity = new PasteEntity(paste.getTitle(), paste.getIsPublic(), paste.getText());
        
        return pasteRepository.save(pasteEntity);
    }

    @Transactional
    public Optional<PasteEntity> getPaste(@NonNull String suuid) {
        UUID uuid = UUID.fromString(suuid);
        if (uuid == null) return Optional.empty();
        
        return pasteRepository.findByUuid(uuid);
    }

    @Transactional
    public void deletePaste(@NonNull PasteEntity paste) {
        pasteRepository.delete(paste);
    }
}
