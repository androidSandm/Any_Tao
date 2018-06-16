package com.example.boylucky.anytao.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.boylucky.anytao.R;
import com.example.boylucky.anytao.view.frag.ClassfyFrag;
import com.example.boylucky.anytao.view.frag.FindFrag;
import com.example.boylucky.anytao.view.frag.HomeFrag;
import com.example.boylucky.anytao.view.frag.MeFrag;
import com.example.boylucky.anytao.view.frag.ShopFrag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragActivity extends AppCompatActivity {

    @BindView(R.id.frag)
    FrameLayout mFrag;
    @BindView(R.id.but1)
    RadioButton mBut1;
    @BindView(R.id.but2)
    RadioButton mBut2;
    @BindView(R.id.but3)
    RadioButton mBut3;
    @BindView(R.id.but4)
    RadioButton mBut4;
    @BindView(R.id.but5)
    RadioButton mBut5;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frag, new HomeFrag()).commit();
    }

    @OnClick({R.id.but1, R.id.but2, R.id.but3, R.id.but4, R.id.but5})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but1:
                fragmentManager.beginTransaction().replace(R.id.frag, new HomeFrag()).commit();
                break;
            case R.id.but2:
                fragmentManager.beginTransaction().replace(R.id.frag, new ClassfyFrag()).commit();
                break;
            case R.id.but3:
                fragmentManager.beginTransaction().replace(R.id.frag, new FindFrag()).commit();
                break;
            case R.id.but4:
                fragmentManager.beginTransaction().replace(R.id.frag, new ShopFrag()).commit();
                break;
            case R.id.but5:
                fragmentManager.beginTransaction().replace(R.id.frag, new MeFrag()).commit();
                break;
        }
    }
}
