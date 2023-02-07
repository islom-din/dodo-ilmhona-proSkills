package islom.din.dodo_ilmhona_proskills.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.viewmodel.HomeViewModel

class SplashFragment : Fragment() {

    private val viewModel : HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_navigation_home)
        },3000)

        var bottomNavView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        bottomNavView.visibility = View.GONE

        viewModel.hideBottomNavView = false
    }
}