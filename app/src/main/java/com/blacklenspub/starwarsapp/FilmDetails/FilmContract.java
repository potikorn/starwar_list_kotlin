package com.blacklenspub.starwarsapp.FilmDetails;

/**
 * Created by potik on 16-Mar-17.
 */

public interface FilmContract {
    interface FilmView {

        void showLoading();

        void hideLoading();

        void showMessage(String message);

        void showTitle(String title);

        void showReleaseDate(String releaseDate);

        void showDirector(String director);

        void showCrawl(String crawl);

    }

    interface FilmPresenter {
        void getFilmDetails();
    }
}
