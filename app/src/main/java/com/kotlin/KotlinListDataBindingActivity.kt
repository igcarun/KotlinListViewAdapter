package com.kotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.kotlin.databinding.ActivityMain2Binding
import com.kotlin.databinding.InflaterListItemBinding
import com.kotlin.dto.ProfileDto
import com.myadapter.CustomListViewAdapter
import java.util.ArrayList

class KotlinListDataBindingActivity : AppCompatActivity(), CustomListViewAdapter.OnGetViewListener<ProfileDto> {
    private var mListView : ListView? = null

    private var mListAdapter : CustomListViewAdapter<ProfileDto>? = null
    private var mNameList : List<ProfileDto>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity_binding: ActivityMain2Binding = DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2)
        activity_binding.executePendingBindings()
        mListView = findViewById(R.id.activity_main2_lv) as ListView
        mNameList = ArrayList<ProfileDto>() as List<ProfileDto>?
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://www.hdwallpapers.in/walls/nature_call-wide.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://3.bp.blogspot.com/-Q8sLtkm5ZwE/Vg54WPxWx1I/AAAAAAAAdsI/eCCkiZg7uMU/s1600/attractive-scenery-free-wallpaper-world.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("https://static.pexels.com/photos/20974/pexels-photo.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://www.hdwallpapers.in/walls/nature_call-wide.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://3.bp.blogspot.com/-Q8sLtkm5ZwE/Vg54WPxWx1I/AAAAAAAAdsI/eCCkiZg7uMU/s1600/attractive-scenery-free-wallpaper-world.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("https://static.pexels.com/photos/20974/pexels-photo.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://www.hdwallpapers.in/walls/nature_call-wide.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://3.bp.blogspot.com/-Q8sLtkm5ZwE/Vg54WPxWx1I/AAAAAAAAdsI/eCCkiZg7uMU/s1600/attractive-scenery-free-wallpaper-world.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("https://static.pexels.com/photos/20974/pexels-photo.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://www.hdwallpapers.in/walls/nature_call-wide.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("http://3.bp.blogspot.com/-Q8sLtkm5ZwE/Vg54WPxWx1I/AAAAAAAAdsI/eCCkiZg7uMU/s1600/attractive-scenery-free-wallpaper-world.jpg", "Row Item 1"))
        (mNameList as ArrayList<ProfileDto>).add(ProfileDto("https://static.pexels.com/photos/20974/pexels-photo.jpg", "Row Item 1"))

        mListAdapter = CustomListViewAdapter(this, -1, this, mNameList)
        mListView!!.adapter = mListAdapter

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup, rowItem: ProfileDto): View? {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val viewDataBinding : InflaterListItemBinding
        if (convertView == null) {
            viewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.inflater_list_item, parent, false)
        } else {
            viewDataBinding = DataBindingUtil.getBinding(convertView)
        }
        viewDataBinding.setVariable(BR.profile, rowItem)
        viewDataBinding.executePendingBindings()

        return viewDataBinding.root
    }

}
