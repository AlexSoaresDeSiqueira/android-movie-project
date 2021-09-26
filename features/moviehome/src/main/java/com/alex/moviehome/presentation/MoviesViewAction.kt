package com.alex.moviehome.presentation

internal sealed class MoviesViewAction {
    object ShowLoading : MoviesViewAction()
    object HideLoading : MoviesViewAction()
    object Default : MoviesViewAction()
}