package me.miguins.core.service

import jakarta.inject.Singleton
import me.miguins.core.mapper.BookConverter
import me.miguins.core.model.Book
import me.miguins.core.ports.BookEntityServicePort
import me.miguins.core.ports.BookServicePort
import me.miguins.database.repository.BookRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Singleton
class BookService(private val bookEntityServicePort: BookEntityServicePort) : BookServicePort {

    val LOG: Logger = LoggerFactory.getLogger(BookService::class.java)

    override fun findById(id: UUID): Book? {
        LOG.info("service.findById", "findById")
        return bookEntityServicePort.findById(id)?.let { BookConverter.bookEntityToBook(it) }
    }

    override fun listAll(): List<Book> {
        LOG.info("service.listAll", "listAll")
        return BookConverter.bookEntityListToBookList(bookEntityServicePort.findAll())
    }
}