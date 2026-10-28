package app.bebu.tracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import app.bebu.tracker.data.local.dao.AppMetadataDao
import app.bebu.tracker.data.local.entity.AppMetadata

/**
 * Room database for Bebu app.
 * 
 * This is a minimal placeholder database with a single entity to demonstrate
 * the database setup. Schema export is configured in build.gradle.kts.
 * 
 * Real entities for tracking feeding, diapers, sleep, milestones, and journal
 * entries will be added in subsequent PRs following clean architecture principles.
 * 
 * Database version will be incremented when schema changes are made.
 */
@Database(
    entities = [AppMetadata::class],
    version = 1,
    exportSchema = true
)
abstract class BebuDatabase : RoomDatabase() {
    /**
     * DAO for app metadata.
     * 
     * This is a placeholder DAO. Real DAOs for baby tracking features
     * will be added here as the app develops.
     */
    abstract fun appMetadataDao(): AppMetadataDao
}
