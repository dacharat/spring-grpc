package com.jack.user;

import com.jack.grpc.UserGrpc.UserImplBase;
import com.jack.grpc.UserOuterClass.AuthResponse;
import com.jack.grpc.UserOuterClass.AuthResponse.Builder;
import com.jack.grpc.UserOuterClass.Empty;
import com.jack.grpc.UserOuterClass.LoginRequest;

import io.grpc.stub.StreamObserver;

public class UserService extends UserImplBase {
	@Override
	public void login(LoginRequest request, StreamObserver<AuthResponse> responseObserver) {
		System.out.println("Login");

		String username = request.getUsername();
		String password = request.getPassword();

		Builder response = AuthResponse.newBuilder();

		if (username.equalsIgnoreCase(password)) {
			response.setResponseCode(0).setResponseMessage("Success");
		} else {
			response.setResponseCode(100).setResponseMessage("Invalid Password");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<AuthResponse> responseObserver) {
		Builder response = AuthResponse.newBuilder();
		response.setResponseCode(0).setResponseMessage("Success");
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
