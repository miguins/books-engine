package me.miguins.core.ports

import jakarta.inject.Singleton
import me.miguins.database.entity.BookEntity
import java.util.*

@Singleton
interface BookEntityServicePort {

    fun findById(id: UUID): BookEntity?
    fun findAll(): List<BookEntity>
}