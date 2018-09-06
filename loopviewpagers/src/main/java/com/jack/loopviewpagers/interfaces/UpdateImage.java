package com.jack.loopviewpagers.interfaces;

import android.widget.ImageView;

public interface UpdateImage<T> {

    void loadImage(ImageView view, int position, T item);

}
