package com.nearbylocation.repository;

import com.nearbylocation.repository.model.Book;
import java.util.List;
import io.reactivex.Single;

public interface BooksRepository {
    Single<List<Book>> getBooks();
}
