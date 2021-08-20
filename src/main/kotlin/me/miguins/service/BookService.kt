package me.miguins.service

import jakarta.inject.Singleton
import me.miguins.model.Book
import java.util.*

@Singleton
interface BookService {

    fun findById(id: UUID): Book?
    fun listAll(): List<Book>
}