package com.example.choonket.fyp;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Mr.Tsang Wai Yong on 1/11/2017.
 */

public class rateAndReviewClass {
    @SerializedName("reviewID")
    public String reviewIDr;

    @SerializedName("rating")
    public int ratingr;

    @SerializedName("review")
    public String reviewr;

    @SerializedName("rrDate")
    public Date dater;

    @SerializedName("locationID")
    public String locationIDr;

}
