package com.example.protobuftest.grpc

import com.ifantastic.helloworld.GreeterGrpc
import com.ifantastic.helloworld.HelloReply
import com.ifantastic.helloworld.HelloRequest
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class HelloService : GreeterGrpc.GreeterImplBase() {
    override fun sayHello(request: HelloRequest?, responseObserver: StreamObserver<HelloReply>?) {
        val reply = HelloReply.newBuilder().setMessage("Hello" + request?.name).build()
        responseObserver?.onNext(reply)
        responseObserver?.onCompleted()
    }
}