package com.example.protobuftest.grpc

import io.grpc.*

class HeaderServerInterceptor : ServerInterceptor {
    override fun <ReqT : Any?, RespT : Any?> interceptCall(call: ServerCall<ReqT, RespT>?, headers: Metadata?, next: ServerCallHandler<ReqT, RespT>?): ServerCall.Listener<ReqT> {
        println(headers)

        return next!!.startCall(object : ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
            override fun sendMessage(message: RespT) {
                super.sendMessage(message)
                println("sendMessage: $message")
            }

            override fun sendHeaders(headers: Metadata?) {
                headers?.put(Metadata.Key.of("custom_server_header_key", Metadata.ASCII_STRING_MARSHALLER), "From_Server")
                super.sendHeaders(headers)
                println("sendHeaders: $headers")
            }
        },headers)
    }
}