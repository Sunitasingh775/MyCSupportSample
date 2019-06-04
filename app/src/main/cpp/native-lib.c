#include <jni.h>
#include "PrimeNumber.h"

/* This is a trivial JNI example where we use a native method
 * to return a new VM String. See the corresponding Java source
 * file located at: MainActivity.java
 */
JNIEXPORT jstring JNICALL
Java_com_coppermobile_mycsupportsample_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz) {

    return (*env)->NewStringUTF(env, "Hello from JNI");
}

/*function name : Java_+_{package name}_+{class name}_+{function name}  */
JNIEXPORT jboolean JNICALL
Java_com_coppermobile_mycsupportsample_MainActivity_isPrime(JNIEnv *env, jobject thiz, jint num) {
    return isPrime(num);
}