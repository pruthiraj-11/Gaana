package com.app.gaana.views.panels;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.app.extensions.bottomsheet.CustomBottomSheetBehavior;
import com.app.gaana.R;
import com.realgear.multislidinguppanel.BasePanelView;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;

public class RootMediaPlayerPanel extends BasePanelView {

    public RootMediaPlayerPanel(@NonNull Context context, MultiSlidingUpPanelLayout panelLayout) {
        super(context, panelLayout);

        getContext().setTheme(R.style.Theme_Gaana);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_root_mediaplayer,this,true);
    }

    @Override
    public void onCreateView() {
        this.setPanelState(MultiSlidingUpPanelLayout.COLLAPSED);
        this.setSlideDirection(MultiSlidingUpPanelLayout.SLIDE_VERTICAL);
        this.setPeakHeight(getResources().getDimensionPixelSize(R.dimen.mediaplayerbar_height));
    }

    @Override
    public void onBindView() {
        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        FrameLayout layout=findViewById(R.id.media_player_bottom_sheet);

        ViewGroup.LayoutParams params=layout.getLayoutParams();
        params.height=displayMetrics.heightPixels-(mPeakHeight);
        layout.setLayoutParams(params);

        CustomBottomSheetBehavior<FrameLayout> bottomSheetBehavior=CustomBottomSheetBehavior.from(layout);
        bottomSheetBehavior.setSkipAnchored(false);
        bottomSheetBehavior.setAllowUserDragging(true);

        bottomSheetBehavior.setAnchorOffset((int)(displayMetrics.heightPixels*0.75F));
        bottomSheetBehavior.setPeekHeight(getPeakHeight());
        bottomSheetBehavior.setMediaPlayerBarHeight(getPeakHeight());
        bottomSheetBehavior.setState(CustomBottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.addBottomSheetCallback(new CustomBottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int oldState, int newState) {
                switch (newState){
                    case CustomBottomSheetBehavior.STATE_ANCHORED:
                    case CustomBottomSheetBehavior.STATE_EXPANDED:
                    case CustomBottomSheetBehavior.STATE_DRAGGING:
                        mParentSlidingPanel.setSlidingEnabled(false);
                        break;

                    default:
                        mParentSlidingPanel.setSlidingEnabled(true);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onPanelStateChanged(int panelSate) {

    }
}
