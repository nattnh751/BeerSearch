package com.beer.discover

class BeerFragmentModel : BaseModel() {
    var beers: List<Beer> = emptyList()
        set(value) {
            field = value
            notifyChange(ChangeEvent.BEER_LIST_UPDATED);
        }
    class ChangeEvent(type: String) : BaseModel.ChangeEvent(type) {
        companion object {
            val BEER_LIST_UPDATED = "beerListUpdated"
        }
    }
}