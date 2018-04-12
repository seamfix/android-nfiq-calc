package com.seamfix.calculatenfiq

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import org.jnbis.api.Jnbis
import java.io.ByteArrayOutputStream


/**
 * @author Ben Daniel.
 * Util class that is used to calculate the NFIQ of a captured fingerprint.
 */
class NFIQUtil {

    companion object {

        //Loads the required native libraries.
        init {
            System.loadLibrary("log")
            System.loadLibrary("nativelib")
        }

        @JvmStatic
        private val nfiqUtil = NFIQUtil()

        /**
         * This method calculates the nfiq of a fingerprint. <br/>
         *
         * This method should be called in an async manner since it might take a few seconds to return
         *
         * @param rawBytes The byte array that contains the captured fingerprint.
         * @param imageWidth The width of the captured finger print image.
         * @param imageHeight The height of the captured finger print image.
         *
         * @return the NFIQ for the supplied fingerprint.
         */
        @JvmStatic
        fun calculateNFIQUsingRawBytes(rawBytes: ByteArray, imageWidth: Int, imageHeight: Int): Int {

            return nfiqUtil.calculateNFIQ(rawBytes, imageWidth, imageHeight)

        }

        /**
         * This method calculates the nfiq of a fingerprint. <br/>
         *
         * This method should be called in an async manner since it might take a few seconds to return
         *
         * @param wsqBytes The byte array that contains the captured fingerprint.
         * @param context Android context.
         * @return the NFIQ for the supplied fingerprint.
         */
        @JvmStatic
        @Deprecated(message = "Deprecated until the an alternative to converting wsq to byte array is found. The current implementation makes use of a class in the java.awt package which is not available on Android.")
        fun calculateNFIQUsingWSQ(context: Context, wsqBytes: ByteArray): Int {

            val pngByteArray = Jnbis.wsq()
                    .decode(wsqBytes.inputStream())
                    .toPng()
                    .asByteArray()

            //Convert byte array to bitmap drawable to get dimensions.
            val image = BitmapDrawable(context.resources, BitmapFactory.decodeByteArray(pngByteArray, 0, pngByteArray.size))
            val width = image.intrinsicWidth
            val height = image.intrinsicHeight

            //Convert to grayscale
            val grayScaleImage = convertToGrayscale(image) as BitmapDrawable

            //convert grayscale image to byte array to feed to nfiq algorithm
            val grayScaleBytes = convertBitmapToByteArray(grayScaleImage.bitmap)

            return nfiqUtil.calculateNFIQ(grayScaleBytes, width, height)

        }

        /**
         * This method calculates the nfiq of a fingerprint. <br/>
         *
         * This method should be called in an async manner since it might take a few seconds to return
         *
         * @param bitmap The bitmap image of the fingerprint.
         * @param context Android context.
         * @return the NFIQ for the supplied fingerprint.
         */
        @JvmStatic
        fun calculateNFIQUsingBitmap(context: Context, bitmap: Bitmap): Int {

            //Convert bitmap to bitmap drawable to get dimensions.
            val image = BitmapDrawable(context.resources, bitmap)
            val width = image.intrinsicWidth
            val height = image.intrinsicHeight

            //Convert to grayscale
            val grayScaleImage = convertToGrayscale(image) as BitmapDrawable

            //convert grayscale image to byte array to feed to nfiq algorithm
            val grayScaleBytes = convertBitmapToByteArray(grayScaleImage.bitmap)

            return nfiqUtil.calculateNFIQ(grayScaleBytes, width, height)

        }

        @JvmStatic
        private fun convertToGrayscale(drawable: Drawable): Drawable {
            val matrix = ColorMatrix()
            matrix.setSaturation(0f)

            val filter = ColorMatrixColorFilter(matrix)

            drawable.colorFilter = filter

            return drawable
        }

        @JvmStatic
        private fun convertBitmapToByteArray(bitmap: Bitmap): ByteArray {

            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

            return stream.toByteArray()

        }

    }

    private external fun calculateNFIQ(imageData: ByteArray, imageWidth: Int, imageHeight: Int): Int


}