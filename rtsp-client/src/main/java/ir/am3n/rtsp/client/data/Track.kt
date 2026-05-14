package ir.am3n.rtsp.client.data

abstract class Track {
    var request: String? = null
    var payloadType = 0
    var host: String? = null
    var port: Int = 0
}