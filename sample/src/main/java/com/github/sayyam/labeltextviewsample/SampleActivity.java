package com.github.sayyam.labeltextviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.sayyam.labeltextview.LabelTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SampleActivity extends AppCompatActivity {

    @InjectView(R.id.phoneLabelTextView)
    LabelTextView phoneLabelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.inject(this);

        phoneLabelTextView.addItem("+923344298222", "Zindagi Office", android.R.drawable.sym_action_chat);
        phoneLabelTextView.addItem("+923344298333", "Zindagi HQ", android.R.drawable.sym_action_chat);
        phoneLabelTextView.addItem("+923344298444", "Zindagi Helpline", android.R.drawable.sym_action_chat);
    }
}
