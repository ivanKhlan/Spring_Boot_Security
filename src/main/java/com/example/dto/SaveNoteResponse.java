package com.example.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SaveNoteResponse {

    private boolean success;
    private Error error;

    public enum Error {
        ok,
        invalidId
    }

    public static SaveNoteResponse success() {
        return SaveNoteResponse.builder().success(true).error(Error.ok).build();
    }

    public static SaveNoteResponse failed(Error error) {
        return SaveNoteResponse.builder().success(false).error(error).build();
    }
}
