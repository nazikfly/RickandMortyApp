package com.geektech.rickandmortyapp.extensions

import android.provider.MediaStore
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


fun ChipGroup.getTextChipChecked():String{
    val selectedId: Int= this.checkedChipId
    return  if (selectedId>-1)findViewById<Chip>(selectedId).text.toString() else " "
}
fun ChipGroup.setChipChecked(selectedId: Int){
    return  if (selectedId>0)this.findViewById<Chip>(selectedId).isChecked=true
}
fun RadioGroup.getTextButtonChecked():String{
    val selectedId:Int=this.checkedRadioButtonId
    return  if (selectedId>-1)findViewById<RadioButton>(selectedId).text.toString() else " "
}
fun RadioGroup.setChipChecked(selectedId: Int){
    return  if (selectedId>-1)findViewById<RadioButton>(selectedId).isChecked=true
}
