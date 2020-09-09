package com.example.gadsleaderboard.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Retrofit.ApiClient2;
import com.example.gadsleaderboard.Retrofit.ApiInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button submitBtn;
    private Dialog saveExitDialog;



    private ApiInterface apiInterface;
    private ImageView closeDialog;
    private  Button yesBtn;
    EditText editTextFname,editLname,editTextemail,editTextgit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        mToolbar =findViewById(R.id.toolbarsubmit);
        editTextFname = findViewById(R.id.editTextlname);
        editLname = findViewById(R.id.editTextfname);
        editTextemail = findViewById(R.id.editTextemail);
        editTextgit = findViewById(R.id.editText3);
        setSupportActionBar(mToolbar);
        mToolbar.setLogo(R.drawable.gads_header);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        submitBtn = findViewById(R.id.submitsend);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAlertDialog();
            }
        });

        saveExitDialog = new Dialog(this);



    }

    private void callAlertDialog() {
        saveExitDialog.setContentView(R.layout.positive_popup_menu);
        closeDialog = saveExitDialog.findViewById(R.id.imageViewCancel);
        yesBtn = saveExitDialog.findViewById(R.id.btnYes);

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExitDialog.dismiss();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String fname = editTextFname.getText().toString();
                String lname = editLname.getText().toString();
                String email = editTextemail.getText().toString();
                String gitLink = editTextgit.getText().toString();

                if(fname.trim().isEmpty() || lname.trim().isEmpty() || email.trim().isEmpty() || gitLink.trim().isEmpty()){
                    Toast.makeText(SubmitActivity.this, "Insert all the field values!!", Toast.LENGTH_SHORT).show();

                }else{
                    submit(fname,lname,email,gitLink);
                    saveExitDialog.dismiss();


                }







            }
        });

        if(saveExitDialog.getWindow()!=null){
            saveExitDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        saveExitDialog.show();




    }

    private void submit(String name,String lastName,String email,String gitUrl) {
        apiInterface = ApiClient2.getApiClient().create(ApiInterface.class);


        Call<Void>  call = apiInterface.submitProject(

                name,
               lastName,
               email, gitUrl

        );

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                SuccessDialog successDialog = new SuccessDialog();
                successDialog.show(getSupportFragmentManager(),"success dialog");






            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                FailureDialog failureDialog = new FailureDialog();
                failureDialog.show(getSupportFragmentManager(),"failure dialog");



            }
        });
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return super.onSupportNavigateUp();
    }
}
