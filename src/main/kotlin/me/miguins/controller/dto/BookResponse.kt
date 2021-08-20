package me.miguins.controller.dto

import me.miguins.model.Book
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