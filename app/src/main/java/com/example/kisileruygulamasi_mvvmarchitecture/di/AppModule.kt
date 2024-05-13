package com.example.kisileruygulamasi_mvvmarchitecture.di

import com.example.kisileruygulamasi_mvvmarchitecture.data.repo.KisilerDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDaoRepository() : KisilerDaoRepository {
        return KisilerDaoRepository()
    }
}