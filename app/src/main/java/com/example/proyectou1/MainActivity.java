package com.example.proyectou1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frmPrincipal,new InicioFragment() ).commit();
        bnv=(BottomNavigationView) findViewById(R.id.btnNav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.menu_home:
                        fragment = new InicioFragment();
                        break;
                    case R.id.menu_layout_carrera:
                        fragment = new CarrerasFragment();
                        break;
                    case R.id.menu_layout_residencia:
                        fragment = new ResidenciasFragment();
                        break;
                    case R.id.menu_layout_serviosocail:
                        fragment = new ServicioSocialFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frmPrincipal,fragment).commit();
                return true;
            }
        });
    }
}