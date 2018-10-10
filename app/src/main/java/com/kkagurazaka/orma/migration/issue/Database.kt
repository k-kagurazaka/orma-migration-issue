package com.kkagurazaka.orma.migration.issue

import com.github.gfx.android.orma.annotation.*

@Database(rxJavaSupport = false)
interface DatabaseConfig

@Table
data class Book @Setter constructor(
        @PrimaryKey val id: Long,
        @Column(indexed = true) val title: String
)
