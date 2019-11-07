package com.beer.discover

class BeerFragmentModel {
    var beers: List<Beer> = emptyList()
        set(value) {
            field = value
//            notifyChange(ChangeEvent.MEDIA_LIST_UPDATED);
        }
}