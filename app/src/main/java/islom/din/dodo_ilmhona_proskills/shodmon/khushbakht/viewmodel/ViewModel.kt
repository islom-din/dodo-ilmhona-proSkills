package islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.viewmodel


import androidx.lifecycle.ViewModel
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.ImageData
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData

class MyViewModel : ViewModel() {

    private val storyData : MutableList<StoryData> = mutableListOf()
    private val imageData : MutableList<ImageData> = mutableListOf()

    fun getStoryData () : MutableList<StoryData>{
        val item = mutableListOf<StoryData>()
        item.add(StoryData(1,getImageData() ))
        return item

    }

    fun getImageData() : MutableList<ImageData>{
        val item = mutableListOf<ImageData>()
        item.add(ImageData(1,"https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.ctfassets.net%2Fhrltx12pl8hq%2F3j5RylRv1ZdswxcBaMi0y7%2Fb84fa97296bd2350db6ea194c0dce7db%2FMusic_Icon.jpg&imgrefurl=https%3A%2F%2Fwww.shutterstock.com%2F&tbnid=22LfYBs93BDCLM&vet=12ahUKEwjVr6Shh_f8AhVbk_0HHQxzCmwQMygnegUIARCAAg..i&docid=7T8fKkixbRnWvM&w=500&h=334&q=image&client=safari&ved=2ahUKEwjVr6Shh_f8AhVbk_0HHQxzCmwQMygnegUIARCAAg"))
        item.add(ImageData(2,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZbXxo5smd56BGOvIKRCj83mnR_jF1SWWw6Q&usqp=CAU"))
        item.add(ImageData(3,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZbXxo5smd56BGOvIKRCj83mnR_jF1SWWw6Q&usqp=CAU"))













        return item

    }

}