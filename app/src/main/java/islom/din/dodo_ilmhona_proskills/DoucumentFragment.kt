package islom.din.dodo_ilmhona_proskills

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class DoucumentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doucument, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val back = view.findNavController()
        back.popBackStack()
        val PDFFragment = view.findViewById<LinearLayout>(R.id.lin3)
        PDFFragment.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_doucumentFragment_to_PDFFragment)
        }
    }
}
