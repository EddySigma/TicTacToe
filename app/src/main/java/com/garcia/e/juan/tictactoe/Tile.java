package com.garcia.e.juan.tictactoe;

import android.view.View;

/**
 * Created by Juan on 6/6/2016.
 */
public class Tile {
    public enum Owner{
        X, O, NEITHER, BOTH;
    }

    public static final int LEVEL_X = 0;
    public static final int LEVEL_O = 1;
    public static final int LEVEK_BLANK = 2;
    public static final int LEVEL_AVAILABLE = 3;
    public static final int LEVEL_TIE = 3;

    private final GameFragment mGame;
    private Owner mOwner = Owner.NEITHER;
    private View mView;
    private Tile mSubTiles[];

    public Tile (GameFragment) {
        this.mGame = game;
    }

    public View getView() {
        return mView;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public setOwner(Owner owner) {
        this.mOwner = owner;
    }

    public Tile[] getSubTiles() {
        return mSubTiles;
    }

    public void setSubTiles(Tile[] subTiles) {
        this.mSubTiles = subTiles;
    }
}
