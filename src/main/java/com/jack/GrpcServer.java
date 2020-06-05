package com.jack;

import java.io.IOException;

import com.jack.user.UserService;

import io.grpc.ServerBuilder;
import io.grpc.Server;

public class GrpcServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
		server.start();
		System.out.println("Server start at " + server.getPort());
		server.awaitTermination();
	}
}
