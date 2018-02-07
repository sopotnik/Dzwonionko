package pl.nyczanbutan.dzwonionko

import android.os.AsyncTask
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL

class NetworkHelper : AsyncTask<URL, Void, String>(){
    override fun doInBackground(vararg url: URL?): String {

        var data: String = ""
        try {
            val urlConnection = url[0]?.openConnection() as HttpURLConnection
            data = urlConnection.inputStream.bufferedReader().readText()
        }
        catch (exception: Exception)
        {
            val TAG:String = LoginActivity::class.java.getSimpleName()
            Log.d(TAG, "wyjątek", exception)
        }
        return data
    }
}