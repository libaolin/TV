# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("jni_dkplayer")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

include_directories(include)
include_directories(./)

add_library( # Sets the name of the library.
        jni_dkplayer

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        src/jni_darkwood_dkplayer.cpp
        src/MediaPlayer.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

####
add_library(avcodec-lib SHARED IMPORTED)
set_target_properties(avcodec-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libavcodec.so)

add_library(avdevice-lib SHARED IMPORTED)
set_target_properties(avdevice-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libavdevice.so)

add_library(avfilter-lib SHARED IMPORTED)
set_target_properties(avfilter-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libavfilter.so)

add_library(avformat-lib SHARED IMPORTED)
set_target_properties(avformat-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libavformat.so)

add_library(avutil-lib SHARED IMPORTED)
set_target_properties(avutil-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libavutil.so)

add_library(postproc-lib SHARED IMPORTED)
set_target_properties(postproc-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libpostproc.so)

add_library(swresample-lib SHARED IMPORTED)
set_target_properties(swresample-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libswresample.so)

add_library(swscale-lib SHARED IMPORTED)
set_target_properties(swscale-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libswscale.so)

add_library(x264-lib SHARED IMPORTED)
set_target_properties(x264-lib PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libx264.so)
####

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        jni_dkplayer

        avcodec-lib
        avdevice-lib
        avfilter-lib
        avformat-lib
        avutil-lib
        postproc-lib
        swresample-lib
        swscale-lib
        x264-lib
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})