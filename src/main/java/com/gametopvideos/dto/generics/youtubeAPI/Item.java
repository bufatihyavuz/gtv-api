package com.gametopvideos.dto.generics.youtubeAPI;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "etag",
    "id",
    "snippet",
    "statistics"
})
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("snippet")
    private Snippet snippet;
    @JsonProperty("statistics")
    private Statistics statistics;
    @JsonProperty("contentDetails")
    private ContentDetails contentDetails;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public Snippet getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    @JsonProperty("statistics")
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @JsonProperty("duration")
    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    @JsonProperty("duration")
    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }
}
