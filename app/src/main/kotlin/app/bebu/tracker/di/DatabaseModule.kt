package app.bebu.tracker.di

import android.content.Context
import androidx.room.Room
import app.bebu.tracker.data.local.BebuDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for providing database dependencies.
 * 
 * This module demonstrates dependency injection with Hilt:
 * - @Module and @InstallIn to define the module scope
 * - @Provides to create dependency instances
 * - @Singleton for app-level single instances
 * 
 * The database is created once and shared across the app.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    /**
     * Provides the Room database instance.
     * 
     * Database is created with:
     * - Application context (safe to hold for app lifetime)
     * - Database name "bebu_database"
     * - No migration strategy yet (will be added when schema evolves)
     */
    @Provides
    @Singleton
    fun provideBebuDatabase(
        @ApplicationContext context: Context
    ): BebuDatabase {
        return Room.databaseBuilder(
            context,
            BebuDatabase::class.java,
            "bebu_database"
        )
        .build()
    }
    
    /**
     * Provides the AppMetadataDao.
     * 
     * DAOs are accessed through the database instance.
     * As more DAOs are added for features, similar provider methods
     * can be added here.
     */
    @Provides
    fun provideAppMetadataDao(database: BebuDatabase) = database.appMetadataDao()
}
