package islom.din.dodo_ilmhona_proskills.QA.fragment.screens

import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import islom.din.dodo_ilmhona_proskills.R
import islom.din.dodo_ilmhona_proskills.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.openMap.setOnClickListener {
             val navController = findNavController()
            navController.navigate(R.id.action_navigation_contact_to_mapsFragment)
        }

        binding.call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:918282909")
            startActivity(intent)
        }

        val aboutFragment = view.findViewById<LinearLayout>(R.id.goToAboutFragment)
        aboutFragment.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_contact_to_aboutFragment)
        }

        val DocumentFragment = view.findViewById<LinearLayout>(R.id.linear1)
        DocumentFragment.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_contact_to_doucumentFragment)
        }

        val instagram = view.findViewById<ImageView>(R.id.instagram)
        instagram.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/dodopizza.tj?igshid=YmMyMTA2M2Y="))
            startActivity(intent)
        }

        val facebook = view.findViewById<ImageView>(R.id.facebook)
        facebook.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dodopizza/?locale=ru_RU"))
            startActivity(intent)
        }
    }
}