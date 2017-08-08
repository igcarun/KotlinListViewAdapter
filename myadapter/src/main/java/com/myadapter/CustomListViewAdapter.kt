package com.myadapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class CustomListViewAdapter<T> : ArrayAdapter<T> {

    var mOnGetViewListener: OnGetViewListener<T>?
    var mListItem : List<T>?

    constructor(context: Context, resource: Int, onGetViewListener: OnGetViewListener<T>, mListItem: List<T>?) : super(context, resource, mListItem) {
        mOnGetViewListener = onGetViewListener
        this.mListItem = mListItem
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return mOnGetViewListener!!.getView(position, convertView, parent, mListItem!!.get(position))
    }


    interface OnGetViewListener<T> {
        fun getView(position: Int, convertView: View?, parent: ViewGroup, rowItem: T): View?
    }
}