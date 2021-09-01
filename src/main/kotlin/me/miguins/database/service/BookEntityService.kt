package me.miguins.database.service

import jakarta.inject.Singleton
import me.miguins.core.ports.BookEntityServicePort
import me.miguins.core.service.BookService
import me.miguins.database.entity.BookEntity
import me.miguins.database.repository.BookRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Singleton
class BookEntityService(private val bookRepository: BookRepository): BookEntityServicePort {

    val LOG: Logger = LoggerFactory.getLogger(BookEntityService::class.java)

    override fun findById(id: UUID): BookEntity? {
        LOG.info("entityService.findById")
        return bookRepository.findById(id)
    }

    override fun findAll(): List<BookEntity> {
        LOG.info("entityService.findAll")
        return bookRepository.findAll()
    }
}