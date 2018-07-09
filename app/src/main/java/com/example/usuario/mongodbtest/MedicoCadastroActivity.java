package com.example.usuario.mongodbtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class MedicoCadastroActivity extends AppCompatActivity {

    FrameLayout mainFrame;
    StepView stepView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico_cadastro);

        mainFrame = (FrameLayout)findViewById(R.id.main_frame);

        stepView = (StepView)findViewById(R.id.step_view_cadastro_cliente);

        stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.colorAccent))
                .selectedCircleRadius(getResources().getDimensionPixelSize(R.dimen.dp14))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .steps(new ArrayList<String>() {{
                    add("Dados pessoais");
                    add("Endereços");
                    add("Financeiro");
                }})
                .stepsNumber(4)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(R.dimen.dp1))
                .textSize(getResources().getDimensionPixelSize(R.dimen.sp14))
                .stepNumberTextSize(getResources().getDimensionPixelSize(R.dimen.sp16))
                .typeface(ResourcesCompat.getFont(this, R.font.roboto))
                .commit();

        ClienteCadastro1Fragment clienteCadastro1Fragment = new ClienteCadastro1Fragment();
        setFragment(clienteCadastro1Fragment);
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_medico, fragment);
        fragmentTransaction.commit();
    }
}
