package app.bebu.tracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Placeholder entity for app metadata.
 * 
 * This entity exists solely to demonstrate Room database setup with
 * schema export. It can store app-level settings or metadata.
 * 
 * Real entities for baby tracking (feeding, diapers, sleep, etc.)
 * will be added in feature development PRs.
 */
@Entity(tableName = "app_metadata")
data class AppMetadata(
    @PrimaryKey
    val key: String,
    val value: String
)
