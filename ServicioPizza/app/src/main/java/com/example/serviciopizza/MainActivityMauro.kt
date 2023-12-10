package com.example.serviciopizza

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.serviciopizza.databinding.ActivityMainMauroBinding
import java.lang.NumberFormatException

class MainActivityMauro : AppCompatActivity() {

    private lateinit var binding: ActivityMainMauroBinding
    private val datosSeleccionados = mutableSetOf<String>()

    enum class EnumAlimentos {
        Jamon, Champinhones, Aceitunas, Domicilio, Local
    }

    // Funcionalidad de los CheckBoxes:
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainMauroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.cbJamon.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                actualizarDatos(EnumAlimentos.Jamon.toString(), true)
                actualizarTextView(textView = binding.datosPedido)
            } else {
                datosSeleccionados.remove(EnumAlimentos.Jamon.toString())
            }
        }
        binding.cbChampi.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                actualizarDatos(EnumAlimentos.Champinhones.toString(), true)
                actualizarTextView(textView = binding.datosPedido)
            } else {
                datosSeleccionados.remove(EnumAlimentos.Champinhones.toString())
            }
        }
        binding.cbAceitunas.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                actualizarDatos(EnumAlimentos.Aceitunas.toString(), true)
                actualizarTextView(textView = binding.datosPedido)
            } else {
                datosSeleccionados.remove(EnumAlimentos.Aceitunas.toString())
            }
        }
        binding.cbTodasOpciones.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                actualizarDatos(EnumAlimentos.Jamon.toString(), true)
                actualizarDatos(EnumAlimentos.Champinhones.toString(), true)
                actualizarDatos(EnumAlimentos.Aceitunas.toString(), true)
                actualizarTextView(textView = binding.datosPedido)
            } else {
                datosSeleccionados.clear()
            }
        }

        // Funcionalidad de los RadioButtons:
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.aDomicilio -> {
                    try {
                        actualizarDatos(EnumAlimentos.Domicilio.toString(), true)
                        actualizarDatos(EnumAlimentos.Local.toString(), false)
                        actualizarTextView(textView = binding.datosPedido)
                    }catch (e: NumberFormatException){
                        e.stackTrace
                    }
                }

                R.id.enLocal -> {
                    try {
                        actualizarDatos(EnumAlimentos.Local.toString(), true)
                        actualizarDatos(EnumAlimentos.Domicilio.toString(), false)
                        actualizarTextView(textView = binding.datosPedido)
                    } catch (e: NumberFormatException){
                        e.stackTrace
                    }
                }
            }
        }

        binding.btnConfirmar.setOnClickListener { OnClickListener ->
            // Creación del Toast
            Toast.makeText(this, "Generando confirmación del pedido", Toast.LENGTH_SHORT).show()

            // Creación del AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ventana de confirmación:")
            builder.setMessage("¿Está seguro de que desea continuar?")
            builder.setCancelable(false)
            builder.setPositiveButton("Continuar", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Has aceptado el pedido", Toast.LENGTH_LONG).show()
            })
            builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
            builder.show()
        }
    }

    private fun actualizarDatos(dato: String, isChecked: Boolean) {
        if (isChecked) {
            datosSeleccionados.add(dato)
        } else {
            datosSeleccionados.remove(dato)
        }
    }

    private fun actualizarTextView(textView: TextView) {
        if (datosSeleccionados.isEmpty()) {
            textView.text = "Comprobación de que no está vacío"
        } else {
            val texto = datosSeleccionados.joinToString(", ")
            textView.text = "Ingredientes seleccionados: $texto"
        }
    }

    // Métodos para implementar el menú

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itmOpciones -> {
                Toast.makeText(this, "Opciones", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.itmAyuda -> {
                Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.itmSalir -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}