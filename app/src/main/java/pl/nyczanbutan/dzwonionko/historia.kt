package pl.nyczanbutan.dzwonionko


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * A simple [Fragment] subclass.
 */
class historia : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        super.onCreate(savedInstanceState)
        return inflater!!.inflate(R.layout.fragment_historia, container, false)
    }
}

