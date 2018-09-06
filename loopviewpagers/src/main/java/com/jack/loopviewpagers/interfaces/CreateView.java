package com.jack.loopviewpagers.interfaces;

import android.view.View;

public interface CreateView<T> {

     View createView(int position);

     void updateView(View view, int position, T item);

     void deleteView(int position);

}
