package com.fushuang.assassinnews.model;

import java.util.List;

/**
 * Created by fushuang on 2017/4/28.
 */

public class GeekFuliBean {
    private boolean error;
    private List<GankItemBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<GankItemBean> getResults() {
        return results;
    }

    public void setResults(List<GankItemBean> results) {
        this.results = results;
    }
}
