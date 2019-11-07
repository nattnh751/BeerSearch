package com.beer.discover;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Beer {
    public class apiMedia {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("tagline")
        private String tagline;
        @SerializedName("first_brewed")
        private String first_brewed;
        @SerializedName("description")
        private String description;
        @SerializedName("image_url")
        private String image_url;
        @SerializedName("abv")
        private String abv;
        @SerializedName("ibu")
        private String ibu;
        @SerializedName("food_pairing")
        private List<String> pairing;
        @SerializedName("brewers_tips")
        private String tips;
        @SerializedName("yeast")
        private String yeast;
    }
}
