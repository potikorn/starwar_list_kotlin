package com.blacklenspub.starwarsapp;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by potik on 16-Mar-17.
 */

public class HomePresenterImpl implements HomeContract.HomePresenter {

    private HomeContract.HomeView homeView;
    private StarWarsApi starWarsApi;

    public HomePresenterImpl(HomeContract.HomeView view) {
        this.homeView = view;
        starWarsApi = Apis.getStarWarsApi();
        view.showTitle("All Star Wars Films");
    }

    @Override
    public void getAllFilms() {
        homeView.showLoading();
        starWarsApi.getAllFilms().enqueue(new Callback<FilmResponse>() {
            @Override
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                homeView.showAllFilms(response.body().getResults());
                homeView.hideLoading();
            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {
                homeView.showMessage(t.getMessage());
                homeView.hideLoading();
            }
        });
    }

    @Override
    public void onFilmItemClicked(Film film) {
        homeView.navigateToFilmPage(film);
    }
}
