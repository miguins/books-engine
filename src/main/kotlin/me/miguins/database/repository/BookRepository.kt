package me.miguins.database.repository

import jakarta.inject.Singleton
import me.miguins.database.entity.BookEntity
import java.util.*

@Singleton
interface BookRepository {

    fun findById(id: UUID): BookEntity?
    fun findAll(): List<BookEntity>
}