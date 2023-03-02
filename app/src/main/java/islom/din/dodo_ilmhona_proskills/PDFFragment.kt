package islom.din.dodo_ilmhona_proskills

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class PDFFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_p_d_f, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView = view.findViewById<WebView>(R.id.webView)
        val progressBAr = view.findViewById<ProgressBar>(R.id.progresBar)

        val back2 = view.findViewById<TextView>(R.id.backMain)
        back2.setOnClickListener {
            val navController = findNavController()
            navController.popBackStack()
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBAr.visibility = VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBAr.visibility = GONE
                super.onPageFinished(view, url)
            }
        }

        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://drive.google.com/file/d/1giBULM3K-OdoWara2FxJ78W-fWDwhQmW/view")
    }


}