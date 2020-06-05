package com.jack;

import com.jack.grpc.UserGrpc;
import com.jack.grpc.UserGrpc.UserBlockingStub;
import com.jack.grpc.UserOuterClass.LoginRequest;
import com.jack.grpc.UserOuterClass.AuthResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

		UserBlockingStub userBlockingStub = UserGrpc.newBlockingStub(channel);

		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("Jack").setPassword("jack").build();

		AuthResponse response = userBlockingStub.login(loginrequest);

		System.out.println(response.getResponseMessage());
	}
}
