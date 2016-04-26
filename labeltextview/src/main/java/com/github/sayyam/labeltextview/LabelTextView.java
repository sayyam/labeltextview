package com.github.sayyam.labeltextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sayyam on 4/26/16.
 */
public class LabelTextView extends LinearLayout {


    private String title;
    private Drawable icon;

    public LabelTextView(Context context) {
        super(context);
        initView(context, null, 0, 0);
    }

    public LabelTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0, 0);
    }

    public LabelTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LabelTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (isInEditMode()) {
            return;
        } else {

            LayoutInflater.from(context).inflate(R.layout.view_label_textview, this, true);

            //Retrieve styles attributes
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LabelTextView, defStyleRes, 0);
            try {

                int padding = getResources().getDimensionPixelSize(R.dimen.padding_default);

                title = a.getString(R.styleable.LabelTextView_titleText);
                icon = a.getDrawable(R.styleable.LabelTextView_leftIcon);

                setOrientation(LinearLayout.VERTICAL);
                setPadding(padding, padding, padding, padding);

                updateView();

            } finally {
                //    a.recycle();
            }

        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        updateView();
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
        updateView();
    }

    private void updateView() {

        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setText(title);

        ImageView drawableLeftImageView = (ImageView) findViewById(R.id.drawableLeftImageView);
        drawableLeftImageView.setImageDrawable(icon);


    }

    public void addItem(String value, String footer, @DrawableRes int rightDrawable) {

        LinearLayout valuesLinearLayout = (LinearLayout) findViewById(R.id.valuesLinearLayout);

        View viewTextView = LayoutInflater.from(getContext()).inflate(R.layout.view_textview_item, this, false);

        TextView valueTextView = (TextView) viewTextView.findViewById(R.id.valueTextView);
        TextView footerTextView = (TextView) viewTextView.findViewById(R.id.footerTextView);
        ImageButton actionImageButton = (ImageButton) viewTextView.findViewById(R.id.actionImageButton);
        LinearLayout valueLinearLayout = (LinearLayout) viewTextView.findViewById(R.id.valueLinearLayout);


        valueTextView.setText(value);

        if (null != footer && !footer.isEmpty()) {
            footerTextView.setText(footer);
        } else {
            footerTextView.setVisibility(View.GONE);
        }

        actionImageButton.setImageResource(rightDrawable);

        if (valuesLinearLayout.getChildCount() > 0) {
            valueLinearLayout.setBackgroundResource(R.drawable.accent_bottom_border_bg);
        }

        valuesLinearLayout.addView(viewTextView);

    }

}
