package me.miguins.database.entity

import java.math.BigDecimal
import java.util.*

data class BookEntity(
    val id: UUID? = null,
    val createdAt: String? = null,
    val title: String? = null,
    val author: String? = null,
    val price: BigDecimal? = null
)