
package com.amrrabbie.mvpmarvelltask.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail implements Serializable
{

    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("extension")
    @Expose
    private String extension;
    private final static long serialVersionUID = -1963303666501653962L;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
