package com.android.customizedappbar
import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette

class TViewModel: ViewModel(){

    fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

}