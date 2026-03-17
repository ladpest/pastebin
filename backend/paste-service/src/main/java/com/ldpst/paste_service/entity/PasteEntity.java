package com.ldpst.paste_service.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pastes")
public class PasteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    
    private String title;
    @Column(nullable = false)
    private Boolean isPublic;
    private String text;

    public PasteEntity() {}

    public PasteEntity(String title, Boolean isPublic, String text) {
        this.title = title;
        this.isPublic = isPublic;
        this.text = text;
    }
}
