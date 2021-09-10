package me.miguins.database.service

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import me.miguins.core.model.Book
import me.miguins.database.entity.BookEntity
import me.miguins.database.repository.BookRepository
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@MicronautTest
class BookEntityServiceTest : AnnotationSpec() {

    private val repository = mockk<BookRepository>()
    private val target = BookEntityService(repository)

    private lateinit var bookEntity: BookEntity

    private var id: UUID = UUID.randomUUID()
    private var date = LocalDateTime.now().toString()

    @BeforeEach
    fun setUp() {
        bookEntity = BookEntity(id, date, "Harry Potter", "J. K. Rowling", BigDecimal("79.90"))
    }

    @Test
    fun `return book entity by id with success`() {
        every { repository.findById(id) } answers { bookEntity }
        val result = target.findById(id)
        result shouldBe bookEntity
    }

    @Test
    fun `return books entity with success`() {
        every { repository.findAll() } answers { listOf(bookEntity) }
        val result = target.findAll()
        result shouldBe listOf(bookEntity)
    }
}
