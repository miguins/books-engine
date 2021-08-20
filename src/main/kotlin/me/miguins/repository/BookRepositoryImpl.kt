package me.miguins.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import jakarta.inject.Singleton
import me.miguins.model.Book
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@Singleton
class BookRepositoryImpl(private val cqlSession: CqlSession) : BookRepository {

    val LOG: Logger = LoggerFactory.getLogger(BookRepositoryImpl::class.java)

    override fun findById(id: UUID): Book? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Book> {
        LOG.info("books accessed on the database")

        val selectResult = cqlSession.execute(
            (SimpleStatement.newInstance("SELECT * FROM books.book"))
        )
        return selectResult.map {
            Book(
                it.getUuid("id"),
                it.getString("createdAt"),
                it.getString("title"),
                it.getString("author"),
                it.getBigDecimal("price"),
            )
        }.toList()
    }

}