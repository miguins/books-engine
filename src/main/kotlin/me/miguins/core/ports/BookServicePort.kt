package me.miguins.core.ports

import jakarta.inject.Singleton
import me.miguins.core.model.Book
import java.util.*

@Singleton
interface BookServicePort {

    fun findById(id: UUID): Book?
    fun listAll(): List<Book>
}