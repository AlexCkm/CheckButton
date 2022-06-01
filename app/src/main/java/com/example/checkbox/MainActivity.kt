package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked){
                binding.tvTexto.text = "ActivadoCheckbox1"
            }else {
                binding.tvTexto.text = "No activadoCheckbox1"
            }
        }
        binding.checkBox2.setOnClickListener {
            if (binding.checkBox2.isChecked){
                binding.tvTexto.text = "ActivadoCheckbox2"
            }else {
                binding.tvTexto.text = "No activadoCheckbox2"
            }
        }
        var select:String
        binding.radioButton.setOnClickListener {
            select = "Opcion 1"
            binding.tvSeleccion.text = select //este comando sirve para llamar a la variable
        }
        binding.radioButton2.setOnClickListener {
            select = "Opcion 2"
            binding.tvSeleccion.text = select
        }
        binding.radioButton3.setOnClickListener {
            select = "Opcion 3"
            binding.tvSeleccion.text = select
        }
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.Ciudades, android.R.layout.simple_spinner_item
        )
        binding.spinner.adapter = adaptador
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Selección: ".plus(position.toString()),Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Sin Seleccion", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
