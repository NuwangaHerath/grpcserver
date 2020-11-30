package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.RoleNameServiceAthenticatedUser;

import java.io.IOException;

public class ServiceServerAuth {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(8010).addService(new RoleNameServiceAthenticatedUser()).build();

        server.start();
        System.out.println("Server started at "+ server.getPort());

        server.awaitTermination();
        server.shutdown();
    }

}
