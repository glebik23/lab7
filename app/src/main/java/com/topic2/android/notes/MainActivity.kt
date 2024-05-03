package com.topic2.android.notes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import com.topic2.android.notes.theme.NotesTheme
import com.topic2.android.notes.viewmodel.MainViewModel
import com.topic2.android.notes.viewmodel.MainViewModelFactory
import com.topic2.android.notes.ui.components.screen.NoteScreen

/**
 * Main activity приложения.
 */
class MainActivity : AppCompatActivity() {

  private val viewModel: MainViewModel by viewModels(factoryProducer = {
    MainViewModelFactory(
      this,
      (application as NotesApplication).dependencyInjector.repository
    )
  })

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      NotesTheme {
        NoteScreen(viewModel = viewModel)
      }
    }
  }
}
