package mx.udg.cuvalles.sqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNotaActivity : AppCompatActivity() {
    var myNotasDBHelper:NotasDBHelper?= null
    val DB_NAME = "notas.db"
    val DB_VERSION = 1

    var etTitulo:EditText?=null
    var etContenido:EditText?=null
    var btnAddNota:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)
        myNotasDBHelper = NotasDBHelper(this,DB_NAME,null,DB_VERSION)
        myNotasDBHelper!!.open()


        etTitulo = findViewById(R.id.etTitulo)
        etContenido = findViewById(R.id.etContenido)
        btnAddNota = findViewById(R.id.btnGuardarNota)

        btnAddNota!!.setOnClickListener(){
            val titulo = etTitulo!!.text.toString()
            val contenido = etContenido!!.text.toString()

            myNotasDBHelper!!.addNota(titulo,contenido)

            etTitulo!!.setText("")
            etContenido!!.setText("")
        }
    }
}