package me.miguins.service

import jakarta.inject.Singleton
import me.miguins.model.Book
import me.miguins.repository.BookRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Singleton
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {

    val LOG: Logger = LoggerFactory.getLogger(BookServiceImpl::class.java)

    override fun findById(id: UUID): Book? {
        LOG.info("service.findById", "findById")
        return bookRepository.findById(id)
    }

    override fun listAll(): List<Book> {
        LOG.info("service.listAll", "listAll")
        return bookRepository.findAll()
    }
}