package com.hbworld.githubcpr.di

import com.hbworld.githubcpr.domain.GithubUseCase
import com.hbworld.githubcpr.viewmodel.ParentViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {


    @ActivityScoped
    @Provides
    fun provideMainViewModel(
        githubUseCase: GithubUseCase
    ) : ParentViewModel{
        return ParentViewModel(githubUseCase)
    }



}