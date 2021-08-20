package me.miguins.repository

import jakarta.inject.Singleton
import me.miguins.model.Book
import java.util.*

@Singleton
interface BookRepository {

    fun findById(id: UUID): Book?
    fun findAll(): List<Book>
}