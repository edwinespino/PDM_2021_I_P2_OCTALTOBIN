package hn.edu.ujcv.pdm_2021_i_p2_octaltobin

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun Binario_Is_Correcto() {
        assertEquals("111010000", convertir("720"))
    }

    fun convertir(st: String): String {
        var dicc: MutableMap<Int, String> = mutableMapOf()
        dicc.put(0, "000")
        dicc.put(1, "001")
        dicc.put(2, "010")
        dicc.put(3, "011")
        dicc.put(4, "100")
        dicc.put(5, "101")
        dicc.put(6, "110")
        dicc.put(7, "111")

        var vale = st.toCharArray()
        var tama = st.length
        var a=""

        for (k in 0..tama - 1) {

            var cont = 0
            var va = Character.getNumericValue(vale[k])


            for (i in 0..7) {
                if (cont.equals(va)) {
                     a = a.toString() + dicc[i].toString()
                }
                cont = cont + 1

            }


        }


        return a


    }





}


