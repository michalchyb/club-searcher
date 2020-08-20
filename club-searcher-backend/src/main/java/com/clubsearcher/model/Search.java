
package com.clubsearcher.model;

public class Search {

    private Integer ns;
    private String title;
    private Integer pageid;
    private Integer size;
    private Integer wordcount;
    private String snippet;
    private String timestamp;

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWordcount() {
        return wordcount;
    }

    public void setWordcount(Integer wordcount) {
        this.wordcount = wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Search(Integer ns, String title, Integer pageid, Integer size, Integer wordcount, String snippet, String timestamp) {
        this.ns = ns;
        this.title = title;
        this.pageid = pageid;
        this.size = size;
        this.wordcount = wordcount;
        this.snippet = snippet;
        this.timestamp = timestamp;
    }

    public Search() {
    }
}
