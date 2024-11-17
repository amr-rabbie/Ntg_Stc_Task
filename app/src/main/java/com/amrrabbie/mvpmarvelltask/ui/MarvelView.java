package com.amrrabbie.mvpmarvelltask.ui;

import com.amrrabbie.mvpmarvelltask.model.Marvell;
import com.amrrabbie.mvpmarvelltask.model.Result;

import java.util.List;

public interface MarvelView {
    public void getMovies(List<Result> results);
}
