package com.alex.movies

import android.app.Application
import com.alex.moviedetail.di.MovieDetailModules
import com.alex.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MoviesComposeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoviesComposeApplication)
            loadKoinModules(
                networkModule
            )
            MovieDetailModules().loadModules()
        }
    }
}