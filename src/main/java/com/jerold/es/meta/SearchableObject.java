package com.jerold.es.meta;

import java.util.Date;

/**
 * Created by Jerold on 16/7/2.
 */
public class SearchableObject {
    private String url;
    private String title;
    private String keywords;
    private String content;
    private Date updateTime;
    private String svoName;
    private SearchAttribute searchAttribute;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSvoName() {
        return svoName;
    }

    public void setSvoName(String svoName) {
        this.svoName = svoName;
    }

    public SearchAttribute getSearchAttribute() {
        return searchAttribute;
    }

    public void setSearchAttribute(SearchAttribute searchAttribute) {
        this.searchAttribute = searchAttribute;
    }
}
