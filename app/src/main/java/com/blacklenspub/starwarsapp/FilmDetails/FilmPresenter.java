package com.blacklenspub.starwarsapp.FilmDetails;

import android.util.Log;
import android.widget.Toast;

import com.blacklenspub.starwarsapp.Apis;
import com.blacklenspub.starwarsapp.Film;
import com.blacklenspub.starwarsapp.StarWarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by potik on 16-Mar-17.
 */

public class FilmPresenter implements FilmContract.FilmPresenter {

    private FilmContract.FilmView view;
    private StarWarsApi starWarsApi;
    private long id;

    public FilmPresenter(FilmContract.FilmView view, long id) {
        this.view = view;
        starWarsApi = Apis.getStarWarsApi();
        this.id = id;
    }

    @Override
    public void getFilmDetails() {
        view.showLoading();
        starWarsApi.getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                view.showTitle(response.body().title);
                view.showReleaseDate(response.body().releaseDate);
                view.showDirector(response.body().director);
                view.showCrawl(response.body().openingCrawl);
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                view.showMessage(t.getMessage());
                view.hideLoading();
            }
        });
    }
}
