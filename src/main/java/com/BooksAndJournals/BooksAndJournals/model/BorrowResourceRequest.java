package com.BooksAndJournals.BooksAndJournals.model;

import lombok.Data;

@Data
public class BorrowResourceRequest {
    private Long userId;
    private Long resourceId;
}
