# Rtsp client android
![MinAPI](https://img.shields.io/badge/API-23%2B-blue)
[![Release](https://jitpack.io/v/am3n/RTSP-Client-Android.svg)](https://jitpack.io/#am3n/RTSP-Client-Android)

<b>Lightweight RTSP client library for Android</b> with almost zero lag video decoding (achieved 20 msec video decoding latency on some RTSP streams). Designed for lag criticial applications (e.g. video surveillance from drones).

Unlike [AndroidX Media ExoPlayer](https://github.com/androidx/media) which also supports RTSP, this library does not make any video buffering. Video frames are shown immidiately when they arrive.

![Screenshot](docs/images/Screenshot_20221026_182823.png?raw=true "Screenshot")

## Features

- Android min API 23.
- RTSP/RTSPS over UDP-Multicast.
- Video H.264 only.
- Audio AAC LC only.
- Supports [libstreaming](https://github.com/zhonglong/libstreaming).
- Auto Decode raw frames to Media Image & YUV & Bitmap.
- Using [renderscript-intrinsics-replacement-toolkit](https://github.com/android/renderscript-intrinsics-replacement-toolkit) for YUV to Bitmap decoding.

## Permissions

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Usage

### 1) Default Android SurfaceView

Next way is default `SurfaceView` class for showing video stream.

```xml
<SurfaceView
    android:id="@+id/svVideo"
    android:layout_width="match_parent" 
    android:layout_height="match_parent" />
```

Then in code use:

```kotlin
// ################# build rtsp ########################
val url = "rtsps://10.0.1.3/test.sdp"
val username = null
val password = null
val rtsp = Rtsp()
rtsp.init(url, username, password)
rtsp.setStatusListener(object : RtspStatusListener {
    override fun onConnecting() {}
    override fun onConnected(sdpInfo: SdpInfo) {}
    override fun onFirstFrameRendered() {}
    override fun onDisconnecting() {}
    override fun onDisconnected() {}
    override fun onUnauthorized() {}
    override fun onFailed(message: String?) {}
})
// ###################################################
rtsp.setSurfaceView(binding.svVideo)
rtsp.setRequestAudioSample(true)
rtsp.start(playVideo = true, playAudio = true)
// ...
rtsp.stop()
```


---

## Credits

* https://github.com/am3n/RTSP-Client-Android
* https://github.com/alexeyvasilyev/rtsp-client-android
* https://github.com/android/renderscript-intrinsics-replacement-toolkit


 
