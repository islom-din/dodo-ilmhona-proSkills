package islom.din.dodo_ilmhona_proskills.behruz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.genius.multiprogressbar.MultiProgressBar
import islom.din.dodo_ilmhona_proskills.databinding.FragmentStoryBinding
import islom.din.dodo_ilmhona_proskills.databinding.FragmentStoryItemBinding
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.viewmodel.MyViewModel

class StoryItemFragment : Fragment(), MultiProgressBar.ProgressStepChangeListener, MultiProgressBar.ProgressFinishListener {

    private lateinit var binding: FragmentStoryItemBinding
    private lateinit var myViewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
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

        binding.storyProgressBar.setSingleDisplayTime(10f)
        binding.storyProgressBar.setProgressStepsCount(6)
        binding.storyProgressBar.setListener(this)
        binding.storyProgressBar.setFinishListener(this)


    }

    override fun onStart() {
        super.onStart()
        binding.storyProgressBar.start()

    }


    override fun onStop() {
        binding.storyProgressBar.pause()
        super.onStop()
    }


    override fun onProgressStepChange(newStep: Int) {
        Log.d("TESTING","New step --> $newStep")

//        var image = myViewModel.getImageData()[newStep].Image
//
//        Glide.with(binding.root)
//            .load(image)
//            .into(binding.image)
    }

    override fun onProgressFinished() {
        Log.d("TESTING", "onProgressFinished: ")

    }

}