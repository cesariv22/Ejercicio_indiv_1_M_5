package com.example.ejercicio_indiv_1_m_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicio_indiv_1_m_5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private EditText urlInput;
    public Button btnUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        urlInput =binding.txtInput;
        btnUrl = binding.btnVer;

        btnUrl.setOnClickListener(view -> showFragment());
    }

    private void showFragment() {
        //crar instancia del fragmento
        FragmentViewLink fragment = FragmentViewLink.newInstance(urlInput.getText().toString(), "");
        // OBTENER EL ADMINISTRADOR DE LOS FRAGMENTOS
        FragmentManager fragmentManager = getSupportFragmentManager();
        // iniciar transacción del fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // reemplazar el contenido del contendor con el fragmento
        transaction.replace(binding.container.getId(), fragment);
        // opcional : añadir la transacciona la pila de retroceso
        transaction.addToBackStack(null);
        transaction.commit();
        urlInput.setText("");
    }
}
