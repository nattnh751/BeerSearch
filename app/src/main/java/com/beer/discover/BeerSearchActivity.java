package com.beer.discover;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BeerSearchActivity extends MainActivity implements BeerFragmentListener, SearchResultsCallBack {
    private ProgressBar loadingProgressBar;
    private BeerFragmentModel beerModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBeerSearchView();
    }
    private void showBeerSearchView() {
        loadingProgressBar = findViewById(R.id.loader);
        loadingProgressBar.setVisibility(View.VISIBLE);
        LoadTask loadTask = new LoadTask();
        loadTask.execute();
    }

    @Override
    public void onSearchTextUpdated(@NotNull String v) {
        loadingProgressBar.setVisibility(View.VISIBLE);
        ApiHelper.searchForBeerWithName(this, this, v);
    }

    @Override
    public void GetBeerComplete(GetBeerResponse response) {
        loadingProgressBar.setVisibility(View.GONE);
        if(response.beers != null) {
            beerModel.setBeers( response.beers);
        }
    }

    private class LoadTask extends AsyncTask<String, Void, BeerFragmentModel> {
        @Override
        protected BeerFragmentModel doInBackground(String... urls) {
            BeerFragmentModel model = new BeerFragmentModel();
            return model;
        }

        @Override
        protected void onPostExecute(BeerFragmentModel result) {
            loadingProgressBar.setVisibility(View.GONE);
            beerModel = result;
            showNewFragment(getBeerSearchFragment());
        }
    }

    private Fragment getBeerSearchFragment() {
        BeerSearchFragment frag = new BeerSearchFragment();
        frag.setModel(beerModel);
        frag.setViewListener(this);
        return frag;
    }

}
