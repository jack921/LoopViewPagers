package com.jack.loopviewpager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewPageFragment extends Fragment {
    public TextView viewText;
    public String name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.view_pager1,container,false);
        viewText=view.findViewById(R.id.view_text);
        Bundle bundle=getArguments();
        name=bundle.getString("name");
        viewText.setText(name);
        Log.e("ViewPageFragment_onCreate",name);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("ViewPageFragment_onDestroy",name);
    }

}
