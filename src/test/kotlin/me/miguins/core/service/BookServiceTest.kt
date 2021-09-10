package me.miguins.core.service

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import me.miguins.core.model.Book
import me.miguins.core.ports.BookEntityServicePort
import me.miguins.database.entity.BookEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@MicronautTest
class BookServiceTest : AnnotationSpec() {

    private val service = mockk<BookEntityServicePort>()
    private val target = BookService(service)


    private lateinit var book: Book
    private lateinit var bookEntity: BookEntity

    private var id: UUID = UUID.randomUUID()
    private var date = LocalDateTime.now().toString()

    @BeforeEach
    fun setUp() {
        book = Book(id, date, "Harry Potter", "J. K. Rowling", BigDecimal("79.90"))
        bookEntity = BookEntity(id, date, "Harry Potter", "J. K. Rowling", BigDecimal("79.90"))
    }

    @Test
    fun `return book by id with success`() {
        every { service.findById(id) } answers { bookEntity }
        val result = target.findById(id)
        result shouldBe book
    }

    @Test
    fun `return books with success`() {
        every { service.findAll() } answers { listOf(bookEntity) }
        val result = target.listAll()
        result shouldBe listOf(book)
    }
}
