package me.miguins.core.mapper

import me.miguins.core.model.Book
import me.miguins.database.entity.BookEntity

class BookConverter {

    companion object {

        fun bookToBookEntity(book: Book) =
            BookEntity(book.id, book.createdAt, book.title, book.author, book.price)

        fun bookEntityToBook(bookEntity: BookEntity) =
            Book(bookEntity.id, bookEntity.createdAt, bookEntity.title, bookEntity.author, bookEntity.price)

        fun bookEntityListToBookList(bookEntityList: List<BookEntity>) =
            bookEntityList.map {
                bookEntityToBook(it)
            }
    }
}