package com.cesarmaranho.todocrmpay.di

import android.app.Application
import androidx.room.Room
import com.cesarmaranho.todocrmpay.data.AppDataBase
import com.cesarmaranho.todocrmpay.data.Converters
import com.cesarmaranho.todocrmpay.domain.use_cases.CreateTaskUseCase
import com.cesarmaranho.todocrmpay.domain.use_cases.GetAllTasksUseCase
import com.cesarmaranho.todocrmpay.domain.use_cases.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TodoModules {

    @Provides
    @Singleton
    fun providerAppDataBase(app: Application): AppDataBase {
        return Room.databaseBuilder(
            app,
            AppDataBase::class.java,
            "todo_crmpay"
        )
            .addTypeConverter(Converters())
            .build()
    }

    @Provides
    @Singleton
    fun provideCreateTaskUseCase(
        dataBase: AppDataBase
    ): CreateTaskUseCase {
        return CreateTaskUseCase(dataBase.appDao)
    }

    @Provides
    @Singleton
    fun provideUpdateTaskUseCase(
        dataBase: AppDataBase
    ): UpdateTaskUseCase {
        return UpdateTaskUseCase(dataBase.appDao)
    }

    @Provides
    @Singleton
    fun provideGetAllTasksUseCase(
        dataBase: AppDataBase
    ): GetAllTasksUseCase {
        return GetAllTasksUseCase(dataBase.appDao)
    }



}