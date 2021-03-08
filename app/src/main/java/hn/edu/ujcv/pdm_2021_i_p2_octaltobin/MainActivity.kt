package hn.edu.ujcv.pdm_2021_i_p2_octaltobin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArrayMap
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dicc.put(0,"000")
        dicc.put(1,"001")
        dicc.put(2,"010")
        dicc.put(3,"011")
        dicc.put(4,"100")
        dicc.put(5,"101")
        dicc.put(6,"110")
        dicc.put(7,"111")


        btnConvertir.setOnClickListener {
            convertir()
        }


    }
    var status:Boolean = false
    var dicc:MutableMap<Int,String> = mutableMapOf()



    fun convertir(){
        validar()

        if(status==true){
            var tama = txtNumOctal.text.length
            var num:String = txtNumOctal.text.toString()
            var cal = num.toCharArray()


            try {
                for (k in 0..tama-1){

                    var cont = 0
                    var va =Character.getNumericValue(cal[k])


                    for (i in 0..7){
                            if(cont.equals(va)){
                                txvValorBin.text=txvValorBin.text.toString()+dicc[i].toString()
                            }
                        cont=cont+1

                        }
                    if(va>7){
                        Toast.makeText(this, "Este numero no es un octal, ingrese otro valor", Toast.LENGTH_SHORT).show()
                        txvValorBin.text=""
                        break
                        }


                    }







            }catch (e:Exception){
                println(e.toString())

            }



        }


    }

    fun validar(){
        val name = txtNombre.text.toString()
        val value = txtNumOctal.text.toString()
        if(name == "" || name !="Edwin"){
            Toast.makeText(this,"El usuario esta vacio o esta incorrecto", Toast.LENGTH_SHORT).show()
            status=false
            txvValorBin.text=""


        }else{
            if(value==""){
                Toast.makeText(this,"Debe ingresar el numero octal", Toast.LENGTH_SHORT).show()
                status=false
                txvValorBin.text=""

            }else{
                if(txtNumOctal.text.length>=1){
                    if(txtNumOctal.text.length<=7){
                        status=true
                        txvValorBin.text=""
                    }else{
                        Toast.makeText(this,"Valor Maximo 7 Numeros", Toast.LENGTH_SHORT).show()
                        status=false
                        txvValorBin.text=""
                    }
                }


            }


        }
    }
}