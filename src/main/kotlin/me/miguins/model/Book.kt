package me.miguins.model

import java.math.BigDecimal
import java.util.*

data class Book(
    val id: UUID? = null,
    val createdAt: String? = null,
    val title: String? = null,
    val author: String? = null,
    val price: BigDecimal? = null
)