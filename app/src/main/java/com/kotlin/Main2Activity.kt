package com.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.inflater_list_item.view.*
import java.util.ArrayList

class Main2Activity : AppCompatActivity(), CustomListViewAdapter.OnGetViewListener<String> {
    private var mListView : ListView? = null

    private var mListAdapter : CustomListViewAdapter<String>? = null
    private var mNameList : List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mListView = findViewById(R.id.activity_main2_lv) as ListView
        mNameList = ArrayList<String>() as List<String>?
        (mNameList as ArrayList<String>).add("Row Item 1")
        (mNameList as ArrayList<String>).add("Row Item 2")
        (mNameList as ArrayList<String>).add("Row Item 3")
        (mNameList as ArrayList<String>).add("Row Item 4")
        (mNameList as ArrayList<String>).add("Row Item 5")
        (mNameList as ArrayList<String>).add("Row Item 6")
        (mNameList as ArrayList<String>).add("Row Item 7")
        (mNameList as ArrayList<String>).add("Row Item 8")
        (mNameList as ArrayList<String>).add("Row Item 9")
        (mNameList as ArrayList<String>).add("Row Item 10")
        (mNameList as ArrayList<String>).add("Row Item 11")
        (mNameList as ArrayList<String>).add("Row Item 12")
        (mNameList as ArrayList<String>).add("Row Item 13")

        mListAdapter = CustomListViewAdapter(this, -1, this, mNameList)
        mListView!!.adapter = mListAdapter

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup, rowItem: String): View? {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val viewHolder : ViewHolder
        val view : View?
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.inflater_list_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.textview = view.inflater_list_item_tv
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
            viewHolder.textview!!.text = rowItem

        return view
    }

    class ViewHolder {
        var textview : TextView? = null
    }
}
