package com.example.cancerpredictor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class predictions extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictions);

        Bundle pred = this.getIntent().getExtras();

        int RiskScore;
        double[] distribution,distribution4,distribution5,distribution1,distribution2,distribution3;

        distribution = pred.getDoubleArray("logistic");


        distribution4 = pred.getDoubleArray("RandomForest");

        distribution3 = pred.getDoubleArray("SVM");

        int ck = (int) distribution3[0];


        distribution5 = pred.getDoubleArray("J48");



        distribution1 = pred.getDoubleArray("NaiveBayes");

        distribution2 = pred.getDoubleArray("LMT");


        int chk=0;



        if(distribution[0]>0.5  ) chk++;

        if(distribution1[0]>0.5 ) chk++;

        if( distribution2[0]>0.5) chk++;

        if((distribution3[0] * 100)>50 ) chk++;

        if(distribution4[0]>0.5 )chk++;
        if((distribution5[0]*100)>50)chk++;



      Button j48 =  (Button) findViewById(R.id.j48);

        Button rft =  (Button) findViewById(R.id.rf);

       Button logres =  (Button) findViewById(R.id.logres);

        Button nbb =  (Button) findViewById(R.id.nb);
        Button lmt =  (Button) findViewById(R.id.lmt);

        Button svm =  (Button) findViewById(R.id.svm);



        logres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(predictions.this, "predicted probability(yes): " + String.valueOf(distribution[0] * 100) + "%", Toast.LENGTH_LONG).show();

                Toast.makeText(predictions.this, "predicted probability(no): " + String.valueOf(distribution[1] *100 ) + "%", Toast.LENGTH_LONG).show();



            }
        });


        j48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Toast.makeText(predictions.this, "predicted probability(yes): " + String.valueOf(distribution5[0]*100) + "%", Toast.LENGTH_LONG).show();

                Toast.makeText(predictions.this, "predicted probability(no): " + String.valueOf(distribution5[1]*100) + "%", Toast.LENGTH_LONG).show();



            }
        });





        rft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(predictions.this, "predicted probability(yes): " + String.valueOf(distribution4[0] * 100) + "%", Toast.LENGTH_LONG).show();

                Toast.makeText(predictions.this, "predicted probability(no): " + String.valueOf(distribution4[1] * 100) + "%", Toast.LENGTH_LONG).show();



            }
        });


        nbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(predictions.this, "predicted probability(yes): " + String.valueOf(distribution1[0] * 100) + "%", Toast.LENGTH_LONG).show();

                Toast.makeText(predictions.this, "predicted probability(no): " + String.valueOf(distribution1[1] * 100) + "%", Toast.LENGTH_LONG).show();



            }
        });



        lmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(predictions.this, "predicted probability(yes): " + String.valueOf(distribution2[0] * 100) + "%", Toast.LENGTH_LONG).show();

                Toast.makeText(predictions.this, "predicted probability(no): " + String.valueOf(distribution2[1] * 100) + "%", Toast.LENGTH_LONG).show();



            }
        });


        svm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ck == 1){
                    Toast.makeText(predictions.this, "SVM predicts you're DEVELOPING OVARIAN CANCER " , Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(predictions.this, "SVM predicts you're NOT DEVELOPING OVARIAN CANCER " , Toast.LENGTH_LONG).show();

                }



            }
        });



        RiskScore = pred.getInt("score");


        TextView predScore = (TextView) findViewById(R.id.score);

        TextView predLevel = (TextView) findViewById(R.id.risklevel);


        if(RiskScore <= 17){
            predLevel.setText("YOUR RISK LEVEL IS LOW");

        }else if(RiskScore > 17 && RiskScore <=24){
            predLevel.setText("YOUR RISK LEVEL IS Medium");

        }else {
            predLevel.setText("YOUR RISK LEVEL IS HIGH");
        }

        predScore.setText("YOUR RISK SCORE IS : "+ RiskScore);


        if(chk>2){
            Toast.makeText(predictions.this, "Please Consult a Doctor As Soon as Possible ", Toast.LENGTH_LONG).show();


        }



    }
}
