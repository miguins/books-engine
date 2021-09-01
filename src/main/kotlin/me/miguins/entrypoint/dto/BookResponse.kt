package me.miguins.entrypoint.dto

import me.miguins.core.model.Book
import me.miguins.database.entity.BookEntity
import java.time.LocalDateTime

class BookResponse(book: Book) {

    val id = book.id

    val createdAt = book.createdAt?.let {
        LocalDateTime.parse(it)
    }

    val title = book.title

    val author = book.author

    val price = book.price
}