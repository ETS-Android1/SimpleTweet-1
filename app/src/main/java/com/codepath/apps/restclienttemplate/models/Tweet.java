package com.codepath.apps.restclienttemplate.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Tweet {

    public String body;
    public String createAt;
    public User user;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
            tweet.body = jsonObject.getString("text");
            tweet.createAt = jsonObject.getString("created_at");
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"));

        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i< jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
    public String getFormattedTimestamp(){
        String timeDifference = TimeFormatter.getTimeDifference(createAt);
        return timeDifference;
    }

}

