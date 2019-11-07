package com.beer.discover;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Beer {
        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("tagline")
        String tagline;
        @SerializedName("first_brewed")
        String first_brewed;
        @SerializedName("description")
        String description;
        @SerializedName("image_url")
        String image_url;
        @SerializedName("abv")
        String abv;
        @SerializedName("ibu")
        String ibu;
        @SerializedName("food_pairing")
        List<String> pairing;
        @SerializedName("brewers_tips")
        String tips;
        @SerializedName("yeast")
        String yeast;
}
