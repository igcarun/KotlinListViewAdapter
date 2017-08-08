package com.kotlin

import android.view.View
import com.kotlin.dto.User

/**
 * Created by arun on 8/8/17.
 */

interface Presenter {

    fun onClick(view: View?, user: User?)

}
