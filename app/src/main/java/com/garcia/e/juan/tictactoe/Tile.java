package com.garcia.e.juan.tictactoe;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Juan on 6/6/2016.
 */
public class Tile {
    public enum Owner{
        X, O, NEITHER, BOTH;
    }

    public static final int LEVEL_X = 0;
    public static final int LEVEL_O = 1;
    public static final int LEVEL_BLANK = 2;
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

    public void updateDrawableState() {
        if(mView == null) return;
        int level = getLevel();
        if(mView.getBackground() != null) {
            mView.getBackground().setLevel(level);
        }
        if(mView instanceof ImageButton) {
            Drawable drawable = ((ImageButton) mView).getDrawable();
            drawable.setLevel(level);
        }
    }

    private int getLevel() {
        int level = LEVEL_BLANK;
        switch (mOwner) {
            case X:
                level = LEVEL_X;
                break;
            case O:
                level = LEVEL_O;
                break;
            case BOTH:
                level = LEVEL_TIE;
                break;
            case NEITHER:
                level = mGame.isAvailable(this) ? LEVEL_AVAILABLE : LEVEL_BLANK;
                break;
        }
        return level;
    }

    public Owner findWinner() {
        // if owner has been calculated return it's value
        if(getOwner() != Owner.NEITHER)
            return getOwner();

        int totalX[] = new int[4];
        int totalO[] = new int[4];
        countCaptures(totalX, totalO);
        if(totalX[3] > 0) return Owner.X;
        if(totalO[3] > 0) return Owner.O;

        // check for a draw
        int total = 0;
    }
}
