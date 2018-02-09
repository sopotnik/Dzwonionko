package pl.nyczanbutan.dzwonionko

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedOutputStream
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by romk on 09.02.2018.
 */
class PutHttpRequestHandler : AsyncTask<String, Void, Int>(){
    override fun doInBackground(vararg params: String): Int {
        var code = 500
        try {
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "PUT"
            urlConnection.doOutput = true
            urlConnection.doInput = true
            urlConnection.setRequestProperty("content-type", "application/json")
            val output = BufferedOutputStream(urlConnection.outputStream)
            val writer = BufferedWriter(OutputStreamWriter(output, "UTF-8"))
            writer.write(params[1])
            writer.flush()
            writer.close()
            output.close()
            urlConnection.connect()
            code = urlConnection.responseCode
            urlConnection.disconnect()
        }
        catch (exception : Exception){
            Log.d("Exception", exception.message)
        }
        return code
    }
}