//
// Created by lx on 2020/11/7.
//
#define LOG_TAG "jni_darkwood_dkplayer"

#include "LogUtil.h"

#include <jni.h>

extern "C" {
#include "libavformat/avformat.h"
};

extern "C"
JNIEXPORT jint JNICALL
Java_com_darkwood_dkplayer_DKPlayer__1init(JNIEnv *env, jobject thiz) {
    LOGD("init");
    avformat_network_init();
    //av_register_all();
    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_darkwood_dkplayer_DKPlayer__1setDataSource(JNIEnv *env, jobject thiz, jstring file_path) {
    LOGD("setDataSource");
    return 0;
}