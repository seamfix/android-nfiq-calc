package com.seamfix.calculatenfiq

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

    }

    private external fun calculateNFIQ(imageData: ByteArray, imageWidth: Int, imageHeight: Int): Int


}