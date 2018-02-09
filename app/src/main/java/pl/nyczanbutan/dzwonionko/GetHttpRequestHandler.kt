package pl.nyczanbutan.dzwonionko

import android.os.AsyncTask
import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class GetHttpRequestHandler : AsyncTask<String, Void, String>(){
    override fun doInBackground(vararg params: String): String {
        var code = 500
        var response = ""
        try {
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpURLConnection
            code = urlConnection.responseCode
            if(code == 200){
                val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                var line = ""
                do {
                    line = reader.readLine()
                    response = "$response$line"
                }while (line != "")

            }
           urlConnection.disconnect()
        }
        catch (exception : Exception){
            Log.d("Exception", exception.message)
        }
        return response
    }
}