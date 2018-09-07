package com.jack.loopviewpagers.adapter;

import android.view.ViewGroup;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author Jack
 */
public class LoopFragmentPagerAdapter extends FragmentPagerAdapter {
    public List<Fragment> listFragment;

    public LoopFragmentPagerAdapter(FragmentManager fm, List<Fragment> listData) {
        super(fm);
        this.listFragment=listData;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % listFragment.size();
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int i) {
        return this.listFragment.get(i);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

}
