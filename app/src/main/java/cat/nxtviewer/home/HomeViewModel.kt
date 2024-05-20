package cat.nxtviewer.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val isSelected = mutableStateOf(false)
    fun toggleSelection() {
        isSelected.value = !isSelected.value
    }
}