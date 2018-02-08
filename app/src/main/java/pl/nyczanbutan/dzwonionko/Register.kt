package pl.nyczanbutan.dzwonionko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button_create = findViewById<Button>(R.id.button_create)

        button_create.setOnClickListener {
            var jsonMap = HashMap<String, String>()
            val login = (findViewById<EditText>(R.id.login)).text.toString()
            val password = (findViewById<EditText>(R.id.password)).text.toString()
            val email = (findViewById<EditText>(R.id.email)).text.toString()
            val phone_number = (findViewById<EditText>(R.id.phone_number)).text.toString()

            jsonMap["login"] = login
            jsonMap["password"] = password
            jsonMap["email"] = email
            jsonMap["phone_number"] = phone_number

            val creator = JsonHandler()
            val json = creator.convertToJson(jsonMap, "POST")
            Log.d("json", json)
            val requestHandler = PostHttpRequestHandler().execute("http://88.156.94.28:5000/users", json)
            val responseCode = requestHandler.get()
            Log.d("ResponseCode", responseCode.toString())
            if (responseCode == 201){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
