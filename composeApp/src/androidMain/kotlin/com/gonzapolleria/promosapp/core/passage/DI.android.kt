package com.gonzapolleria.promosapp.core.passage

import com.gonzapolleria.promosapp.applicationContext
import com.tweener.passage.Passage
import com.tweener.passage.PassageAndroid

actual fun createPassage(): Passage = PassageAndroid(applicationContext = applicationContext)