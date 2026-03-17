package com.ldpst.paste_service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.ldpst.paste_service.entity.PasteEntity;

public interface PasteRepository extends JpaRepository<PasteEntity, UUID> {
    Optional<PasteEntity> findByUuid(UUID uuid);
    @Override
    void delete(@NonNull PasteEntity pasteEntity);

}
