package com.gonzapolleria.promosapp.features.onboarding

import org.jetbrains.compose.resources.DrawableResource
import promosapp.composeapp.generated.resources.Res
import promosapp.composeapp.generated.resources.img_into_1
import promosapp.composeapp.generated.resources.img_into_2
import promosapp.composeapp.generated.resources.img_into_3


sealed class OnboardingModel(
    val image: DrawableResource,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnboardingModel(
        image = Res.drawable.img_into_1,
        title = "Your Reading Partner",
        description = "Read as many book as you want, anywhere you want"
    )

    data object SecondPage : OnboardingModel(
        image = Res.drawable.img_into_2,
        title = "Your Personal Library",
        description = "Organize books in different ways, make your own library"
    )

    data object ThirdPages : OnboardingModel(
        image = Res.drawable.img_into_3,
        title = "Search and Filter",
        description = "Get any book you want within a simple search across your device"
    )


}