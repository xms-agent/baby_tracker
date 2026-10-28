package app.bebu.tracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.bebu.tracker.data.local.entity.AppMetadata
import kotlinx.coroutines.flow.Flow

/**
 * DAO (Data Access Object) for app metadata.
 * 
 * Demonstrates Room DAO patterns:
 * - @Insert, @Query annotations
 * - Flow for reactive data
 * - Conflict resolution strategies
 * 
 * This is a placeholder. Real DAOs for baby tracking features will follow
 * similar patterns but with domain-specific queries and operations.
 */
@Dao
interface AppMetadataDao {
    @Query("SELECT * FROM app_metadata WHERE key = :key")
    fun get(key: String): Flow<AppMetadata?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(metadata: AppMetadata)
}
