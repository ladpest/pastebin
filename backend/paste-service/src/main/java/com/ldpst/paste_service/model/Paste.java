package com.ldpst.paste_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paste {
    private Long uuid;
    private Boolean isPublic = true;
    private String title = "Untitled";
    private String text;
}
