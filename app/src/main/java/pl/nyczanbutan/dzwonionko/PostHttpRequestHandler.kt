package pl.nyczanbutan.dzwonionko

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedOutputStream
import java.io.BufferedWriter
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class PostHttpRequestHandler : AsyncTask<String, Void, Int>(){
    override fun doInBackground(vararg params: String): Int {
        var code = 500
        try {
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "POST"
            urlConnection.doOutput = true
            urlConnection.doInput = true
            Log.d("JESTEM", "elo")
            urlConnection.setRequestProperty("content-type", "application/json")
            Log.d("JESTEM", "elo")
            val output = BufferedOutputStream(urlConnection.outputStream)
            val writer = BufferedWriter(OutputStreamWriter(output, "UTF-8"))
            writer.write(params[1])
            writer.flush()
            writer.close()
            output.close()
            Log.d("JESTEM", "elo")
            urlConnection.connect()
            Log.d("JESTEM", "elo")
            code = urlConnection.responseCode
            Log.d("Response", urlConnection.responseMessage)
            urlConnection.disconnect()
        }
        catch (exception : Exception){
            Log.d("Exception", exception.message)
        }
        return code
    }
}