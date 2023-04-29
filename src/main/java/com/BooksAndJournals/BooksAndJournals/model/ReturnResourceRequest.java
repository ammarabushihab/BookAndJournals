package com.BooksAndJournals.BooksAndJournals.model;

import lombok.Data;

@Data
public class ReturnResourceRequest {
    private Long userId;
    private Long resourceId;
}
