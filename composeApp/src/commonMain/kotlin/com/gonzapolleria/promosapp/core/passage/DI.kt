package com.gonzapolleria.promosapp.core.passage

import com.tweener.passage.Passage

private val passage: Passage = createPassage()

expect fun createPassage(): Passage

fun providePassage(): Passage = passage