package com.seamfix.calculatenfiq

/**
 * @author Ben Daniel.
 * Util class that is used to calculate the NFIQ of a captured fingerprint.
 */
class NFIQUtil {

    companion object {

        @JvmStatic
        val nfiqUtil = NFIQUtil()

        /**
         * This method calculates the nfiq of a fingerprint.
         *
         * @param rawBytes The byte array that contains the captured fingerprint.
         * @param imageWidth The width of the captured finger print image.
         * @param imageHeight The height of the captured finger print image.
         *
         */
        @JvmStatic
        fun calculateNFIQUsingRawBytes(rawBytes: ByteArray, imageWidth: Int, imageHeight: Int): Int {

            return nfiqUtil.calculateNFIQ(rawBytes, imageWidth, imageHeight)

        }

    }

    private external fun calculateNFIQ(imageData: ByteArray, imageWidth: Int, imageHeight: Int): Int


}