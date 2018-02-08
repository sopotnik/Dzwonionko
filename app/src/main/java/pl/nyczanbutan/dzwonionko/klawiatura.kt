package pl.nyczanbutan.dzwonionko


import android.Manifest
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R.attr.fragment
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 */
class klawiatura : Fragment() {

    val REQUEST_PHONE_CALL = 1

    var numb: String = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        super.onCreate(savedInstanceState)
        val view: View = inflater!!.inflate(R.layout.fragment_klawiatura, container, false)


        val number = view.findViewById<TextView>(R.id.number)
        val btn1 = view.findViewById<Button>(R.id.btn1)
        val btn2 = view.findViewById<Button>(R.id.btn2)
        val btn3 = view.findViewById<Button>(R.id.btn3)
        val btn4 = view.findViewById<Button>(R.id.btn4)
        val btn5 = view.findViewById<Button>(R.id.btn5)
        val btn6 = view.findViewById<Button>(R.id.btn6)
        val btn7 = view.findViewById<Button>(R.id.btn7)
        val btn8 = view.findViewById<Button>(R.id.btn8)
        val btn9 = view.findViewById<Button>(R.id.btn9)
        val btndel = view.findViewById<Button>(R.id.btndel)
        val btn0 = view.findViewById<Button>(R.id.btn0)
        val btncall = view.findViewById<FloatingActionButton>(R.id.btncall)
        val btnhash = view.findViewById<Button>(R.id.btnhash)
        val btnstar = view.findViewById<Button>(R.id.btnstar)

        btn1.setOnClickListener {
            numb += "1"
            number.setText(numb)
        }
        btn2.setOnClickListener {
            numb += "2"
            number.setText(numb)
        }
        btn3.setOnClickListener {
            numb += "3"
            number.setText(numb)
        }
        btn4.setOnClickListener {
            numb += "4"
            number.setText(numb)
        }
        btn5.setOnClickListener  {
            numb += "5"
            number.setText(numb)
        }
        btn6.setOnClickListener {
            numb += "6"
            number.setText(numb)
        }
        btn7.setOnClickListener {
            numb += "7"
            number.setText(numb)
        }
        btn8.setOnClickListener {
            numb += "8"
            number.setText(numb)
        }
        btn9.setOnClickListener {
            numb += "9"
            number.setText(numb)
        }
        btndel.setOnClickListener  {
            numb = ""
            number.setText(numb)
        }
        btn0.setOnClickListener {
            numb += "0"
            number.setText(numb)
        }
        btnhash.setOnClickListener {
            numb += "#"
            number.setText(numb)
        }
        btnstar.setOnClickListener {
            numb += "*"
            number.setText(numb)
        }
        btncall.setOnClickListener{

            if(ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)

            }else{

                startCall()
            }

    }
        // Inflate the layout for this fragment
        return view
    }

    @SuppressLint("MissingPermission")
    private fun startCall() {
        val callintent = Intent(Intent.ACTION_CALL)
        callintent.data = Uri.parse("tel:" + numb)
        startActivity(callintent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == REQUEST_PHONE_CALL)startCall()
    }

}
// Required empty public constructor
