package com.blacklenspub.starwarsapp;

import java.util.List;

/**
 * Created by potik on 16-Mar-17.
 */

public interface HomeContract {
    interface HomeView {
        void showLoading();

        void hideLoading();

        void showTitle(String title);

        void showMessage(String message);

        void showAllFilms(List<Film> films);

        void navigateToFilmPage(Film film);
    }

    interface HomePresenter {
        void getAllFilms();

        void onFilmItemClicked(Film film);
    }
}
