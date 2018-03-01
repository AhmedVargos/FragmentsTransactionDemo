package fallenleafapps.com.fragmentslabadvanced.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fallenleafapps.com.fragmentslabadvanced.R;
import fallenleafapps.com.fragmentslabadvanced.fargments.Fragment1;
import fallenleafapps.com.fragmentslabadvanced.fargments.Fragment2;
import fallenleafapps.com.fragmentslabadvanced.fargments.Fragment3;
import fallenleafapps.com.fragmentslabadvanced.fargments.Fragment4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAddF1,btnAddF3,btnAddF2,btnReplaceF4,btnRemoveF;
    FragmentManager fragmentManager;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddF1 = findViewById(R.id.btn_add_fragment1);
        btnAddF2 = findViewById(R.id.btn_add_fragment2);
        btnAddF3 = findViewById(R.id.btn_add_fragment3);
        btnReplaceF4 = findViewById(R.id.btn_replace_fragment4);
        btnRemoveF = findViewById(R.id.btn_remove_fragment);

        fragmentManager = getSupportFragmentManager();

        btnAddF1.setOnClickListener(this);
        btnAddF2.setOnClickListener(this);
        btnAddF3.setOnClickListener(this);
        btnReplaceF4.setOnClickListener(this);
        btnRemoveF.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_add_fragment1){
            Fragment1 fragment1 = new Fragment1();
            ++counter;
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment1,String.valueOf(counter)).addToBackStack(null).commit();
        }else if(id == R.id.btn_add_fragment2){
            Fragment2 fragment2 = new Fragment2();
            //ADD TAG FOR THE SECOND FRAGMENT
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment2,"second").addToBackStack(null).commit();
        }else if(id == R.id.btn_add_fragment3){
            Fragment3 fragment3 = new Fragment3();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment3,String.valueOf(++counter)).addToBackStack(null).commit();
        }else if (id == R.id.btn_replace_fragment4){
            Fragment4 fragment4 = new Fragment4();
            //FIXED TAG FOR SECOND FRAGMENT
            fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment4,"second").addToBackStack(null).commit();
        }else if(id == R.id.btn_remove_fragment){
            counter--;
            fragmentManager.popBackStack();
        }
    }

    @Override
    public void onBackPressed() {
        int size = fragmentManager.getBackStackEntryCount();

        if(fragmentManager.getBackStackEntryCount() > 0){
            counter--;
            fragmentManager.popBackStack();
        }else{
            finish();
        }
    }
}
