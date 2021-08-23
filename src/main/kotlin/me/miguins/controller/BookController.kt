package me.miguins.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import me.miguins.controller.dto.BookResponse
import me.miguins.service.BookService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/api/v1/books")
class BookController(private val bookService: BookService) {

    val LOG: Logger = LoggerFactory.getLogger(BookController::class.java)

    @Get
    fun listAll(): HttpResponse<Any> {

        val books = bookService.listAll().map {
            BookResponse(it)
        }

        LOG.info("all books returned", "listAll")

        return HttpResponse.ok(books)
    }

    @Get("{id}")
    fun findById(@PathVariable id: UUID): HttpResponse<Any> {

        val book = bookService.findById(id) ?: return HttpResponse.notFound()

        LOG.info("returning founded book", "findById")

        return HttpResponse.ok(BookResponse(book))
    }
}