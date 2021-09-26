package com.alex.moviedetail.presentation

internal sealed class MovieDetailViewAction {
    object ShowLoading : MovieDetailViewAction()
    object HideLoading : MovieDetailViewAction()
    object Default : MovieDetailViewAction()
}