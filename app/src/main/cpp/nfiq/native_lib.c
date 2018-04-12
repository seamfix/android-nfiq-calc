#include <jni.h>
#include <nfiq.h>
/**
 * @author Ben Daniel.
 *
 * This is the JNI bridge that computes the NFIQ of a given image using the open source C library: https://github.com/lessandro/nbis
 */


unsigned char *as_unsigned_char_array(JNIEnv *env, jbyteArray array) {
    int len = (*env)->GetArrayLength(env, array);
    unsigned char *buf[len];
    (*env)->GetByteArrayRegion(env, array, 0, len, (jbyte *) (buf));
    return buf;
}

JNIEXPORT int JNICALL
Java_com_seamfix_calculatenfiq_NFIQUtil_calculateNFIQ(
        JNIEnv *env,
        jobject callingObject,
        jbyteArray data, jint imageWidth,
        jint imageHeight) {


    unsigned char *idata = as_unsigned_char_array(env, data);
    int computedNfiq = -2;
    float oConfig = 1;
    int optFlag = 1;

    comp_nfiq(&computedNfiq, &oConfig, idata, (int) imageWidth, (int) imageHeight, 8, -1, &optFlag);

    return computedNfiq;
}

