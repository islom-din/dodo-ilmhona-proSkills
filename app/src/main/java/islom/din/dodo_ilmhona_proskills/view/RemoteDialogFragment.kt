package islom.din.dodo_ilmhona_proskills.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import islom.din.dodo_ilmhona_proskills.databinding.GialogLayoutBinding


  class RemoteDialogFragment : DialogFragment() {
    private var _binding :GialogLayoutBinding? =null
    private val binging get() = _binding!!
    private val showFragment= ShowFragment()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding =GialogLayoutBinding.inflate(inflater,container,false)
        return binging.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binging.done.setOnClickListener {
dialog?.dismiss()
        }
        binging.textView1.setOnClickListener {


    }}

    companion object {
        const val TAG = "PurchaseConfirmationDialog"

            // binding.descriptionShowder.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG


    }
}