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
    public void onSearchTextUpdated(@NotNull final String v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(v.length() <= 0) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            beerModel.setBeers( new ArrayList<Beer>());
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loadingProgressBar.setVisibility(View.VISIBLE);
                        }
                    });
                    ApiHelper.searchForBeerWithName(BeerSearchActivity.this, BeerSearchActivity.this, v);
                }
            }
        }).start();
    }

    @Override
    public void GetBeerComplete(final GetBeerResponse response) {
        if(response.beers != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingProgressBar.setVisibility(View.GONE);
                    beerModel.setBeers( response.beers);
                }
            });
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingProgressBar.setVisibility(View.GONE);
                    beerModel.setBeers( response.beers);
                }
            });
        }
    }

    @Override
    public void onBeerSelected(@NotNull BeerItemListResource beer) {
        //Todo make a view helper that shows a beer
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
