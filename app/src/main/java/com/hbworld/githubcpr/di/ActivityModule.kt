package com.hbworld.githubcpr.di

import com.hbworld.githubcpr.domain.GithubRepository
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
        githubRepository: GithubRepository
    ) : ParentViewModel{
        return ParentViewModel(githubRepository)
    }



}