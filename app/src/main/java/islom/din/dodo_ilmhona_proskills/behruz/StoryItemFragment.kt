package islom.din.dodo_ilmhona_proskills.behruz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import islom.din.dodo_ilmhona_proskills.databinding.FragmentStoryBinding
import islom.din.dodo_ilmhona_proskills.databinding.FragmentStoryItemBinding

class StoryItemFragment : Fragment() {

    private lateinit var binding: FragmentStoryItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoryItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO:
        // 1) Load image into ImageView by using Glide

    }

    override fun onStart() {
        super.onStart()
        //TODO:
        // resume progress line
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        //TODO:
        // pause progress line
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Warning!!! DO NOT DO THIS
        //binding.root
    }

}