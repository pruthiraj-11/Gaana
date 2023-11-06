package com.app.gaana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;

import com.app.extensions.bottomsheet.CustomBottomSheetBehavior;
import com.app.gaana.databinding.ActivityMainBinding;
import com.app.gaana.views.panels.RootMediaPlayerPanel;
import com.app.gaana.views.panels.RootNavigationBarPanel;
import com.realgear.multislidinguppanel.Adapter;
import com.realgear.multislidinguppanel.PanelStateListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Class<?>> list=new ArrayList<>();
        list.add(RootMediaPlayerPanel.class);
        list.add(RootNavigationBarPanel.class);

        binding.rootMultiSlidingUpPanel.setPanelStateListener(new PanelStateListener(binding.rootMultiSlidingUpPanel));
        binding.rootMultiSlidingUpPanel.setAdapter(new Adapter(getBaseContext(),list));

       /* CustomBottomSheetBehavior customBottomSheetBehavior;*/
    }
}