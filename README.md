# Palette API Usage Guide

The Palette API is a powerful tool that allows developers to extract color palettes from images. The API provides methods for extracting prominent colors, generating complementary colors, and more. This guide will show you how to use the Palette API to extract color palettes from images in your Android app.

## Screenshot
![alt text](https://github.com/moemaair/CustomizedAppBar/blob/main/screenshoots/flower.png?raw=true)


## Getting Started
To use the Palette API in your Android app, you need to add the following dependency to your app's build.gradle file:

``` implementation 'androidx.palette:palette:1.0.0'```

After adding the dependency, you can start using the Palette API in your code.


## Basic Usage

#### viewModel

```  fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate() ```

#### Composable

``` 
        // getting instance of VM
        val vm = TViewModel()

        // getting context
        val context = LocalContext.current.applicationContext


        val image = (R.drawable.image_on_appbar)

        // decoding image to bitmap

        val myLogo = BitmapFactory.decodeResource(context.resources, image)

        // Text version of the colors from the bitmap image

        val dominantColorTextColor = vm.createPaletteSync(myLogo).dominantSwatch?.titleTextColor
        val variantColorTextColor = vm.createPaletteSync(myLogo).vibrantSwatch?.titleTextColor
        val mutedColorTextColor = vm.createPaletteSync(myLogo).mutedSwatch?.titleTextColor

         // colors from the bitmap image

        val dominantColor = vm.createPaletteSync(myLogo).dominantSwatch?.rgb
        val variantColor = vm.createPaletteSync(myLogo).vibrantSwatch?.rgb
        val mutedColor = vm.createPaletteSync(myLogo).mutedSwatch?.rgb
```


## Official Documentations
- Official Google Documentation
    - [Google developer site](https://developer.android.com/develop/ui/views/graphics/palette-colors)
  
