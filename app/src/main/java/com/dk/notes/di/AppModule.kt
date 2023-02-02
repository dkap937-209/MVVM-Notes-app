package com.dk.notes.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dk.notes.data.TodoDatabase
import com.dk.notes.data.TodoRepository
import com.dk.notes.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTOdoRepository(db: TodoDatabase): TodoRepository{
        return  TodoRepositoryImpl(db.dao)
    }

}