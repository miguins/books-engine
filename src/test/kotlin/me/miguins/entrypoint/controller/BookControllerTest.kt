package me.miguins.entrypoint.controller

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import me.miguins.core.model.Book
import me.miguins.core.ports.BookServicePort
import me.miguins.database.entity.BookEntity
import me.miguins.entrypoint.dto.BookResponse
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@MicronautTest
class BookControllerTest : AnnotationSpec() {

    private val service = mockk<BookServicePort>()
    private val target = BookController(service)

    private lateinit var book: Book
    private lateinit var response: BookResponse

    private var id: UUID = UUID.randomUUID()
    private var date = LocalDateTime.now().toString()

    @BeforeEach
    fun setUp() {
        book = Book(id, date, "Harry Potter", "J. K. Rowling", BigDecimal("79.90"))
        response = BookResponse(book)
    }

    @Test
    fun `return book response with success`() {
        every { service.findById(id) } answers { book }
        val result = target.findById(id)
        result.status shouldBe HttpStatus.OK
        result.body() shouldNotBe null
        result.body() shouldBeEqualToComparingFields response
    }

    @Test
    fun `return list of books response with success`() {
        every { service.listAll() } answers { listOf(book) }
        val result = target.listAll()
        result.status shouldBe HttpStatus.OK
        result.body() shouldNotBe null
    }
}
