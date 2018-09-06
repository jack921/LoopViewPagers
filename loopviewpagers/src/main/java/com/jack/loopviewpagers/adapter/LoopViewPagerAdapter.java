package com.jack.loopviewpagers.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;


import com.jack.loopviewpagers.interfaces.CreateView;
import com.jack.loopviewpagers.interfaces.OnPageClickListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class LoopViewPagerAdapter<T> extends PagerAdapter {
    private SparseArray<View> views = new SparseArray();
    private OnPageClickListener onClickListener;
    private CreateView mCreateView;
    private Context context;
    private List<T> mData;

    public LoopViewPagerAdapter(Context context, List<T> list, CreateView createView,
                                OnPageClickListener onClickListener){
        this.onClickListener=onClickListener;
        this.mCreateView=createView;
        this.context=context;
        this.mData=list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position=position%mData.size();
        if(mCreateView==null){
            return new View(context);
        }
        View view=mCreateView.createView(position);
        final int finalPosition = position;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(onClickListener!=null){
                   onClickListener.onClick(view, finalPosition);
               }
            }
        });
        views.put(position,view);
        ViewParent vp = view.getParent();
        if (vp != null) {
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(view);
        }
        mCreateView.updateView(view,position,mData.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
        views.remove(position);
        mCreateView.deleteView(position);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0==arg1;
    }

}
