package pl.nyczanbutan.dzwonionko


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.support.v4.app.NotificationCompat.getExtras
import android.content.Intent.getIntent
import android.content.Intent
import android.widget.TextView
import android.content.Intent.getIntent
import android.content.Intent.getIntent
import android.support.design.widget.Snackbar
import android.util.Log


class jam : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        val view: View = inflater!!.inflate(R.layout.fragment_jam, container, false)
        val button_update = view.findViewById<Button>(R.id.button_update)
        button_update.setOnClickListener {
            var map = HashMap<String, String>()
            var tekstFromView = view.findViewById<EditText>(R.id.update_login).text.toString()
            if(tekstFromView != "")
                map["login"] = tekstFromView
            tekstFromView = view.findViewById<EditText>(R.id.update_password).text.toString()
            if(tekstFromView != "")
                map["password"] = tekstFromView
            tekstFromView = view.findViewById<EditText>(R.id.update_email).text.toString()
            if(tekstFromView != "")
                map["email"] = tekstFromView
            tekstFromView = view.findViewById<EditText>(R.id.update_phone_number).text.toString()
            if(tekstFromView != "")
                map["phone_number"] = tekstFromView
            tekstFromView = view.findViewById<EditText>(R.id.update_name).text.toString()
            if(tekstFromView != "")
                map["name"] = tekstFromView
            tekstFromView = view.findViewById<EditText>(R.id.update_surname).text.toString()
            if(tekstFromView != "")
                map["surname"] = tekstFromView
            tekstFromView = view.findViewById<EditText>(R.id.update_birth_date).text.toString()
            if(tekstFromView != "")
                map["birth_date"] = tekstFromView
            if(view.findViewById<RadioGroup>(R.id.radiogroup).checkedRadioButtonId != -1)
                if(view.findViewById<RadioButton>(R.id.m).isChecked)
                    map["sex"] = "M"
                else
                    map["sex"] = "W"
            try {
                val creator = JsonHandler()
                val json = creator.convertToJson(map)
                val requestHandler = PutHttpRequestHandler()
                requestHandler.execute("http://127.0.0.1:5000/users/${TabLayoutDemoActivity.currentUser}", json)
                if(requestHandler.get() != 200){
                    Snackbar.make(view, "Something was wrong", Snackbar.LENGTH_SHORT).show()
                }
                else{
                    Snackbar.make(view, "Done", Snackbar.LENGTH_SHORT).show()
                }
            }
            catch (exception: Exception)
            {
                Log.d("exception", exception.message)
                Snackbar.make(view, "Something was wrong", Snackbar.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return view
    }

}// Required empty public constructor
