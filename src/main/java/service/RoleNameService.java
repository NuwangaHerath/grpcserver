package service;
import org.wso2.custom.authenticator.local.grpc.UserOuterClass;
import org.wso2.custom.authenticator.local.grpc.userGrpc;

import io.grpc.stub.StreamObserver;

public class RoleNameService extends userGrpc.userImplBase{

    @Override
    public void getRoleName(UserOuterClass.User request, StreamObserver<UserOuterClass.Response> responseObserver) {

        System.out.println("getRoleName method called");
        UserOuterClass.Response.Builder response = UserOuterClass.Response.newBuilder();
        response.setRole(process(request));
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public String process(UserOuterClass.User request) {

        //System.out.println(request.getUserName());
        System.out.println(request.getTenantDomain());
        System.out.println(request.getUserStoreDomain()+request.getUserName());
        String response = request.getUserStoreDomain()+request.getUserName();
        return response;
    }

}