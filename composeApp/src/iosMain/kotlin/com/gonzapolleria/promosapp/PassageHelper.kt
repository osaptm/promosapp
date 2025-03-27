package com.gonzapolleria.promosapp

import com.gonzapolleria.promosapp.core.passage.providePassage
import com.tweener.passage.Passage

class PassageHelper {

    private val passage: Passage = providePassage()

    fun handle(url: String): Boolean =
        passage.handleLink(url = url)

}