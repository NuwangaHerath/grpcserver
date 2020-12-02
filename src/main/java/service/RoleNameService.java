package service;

import io.grpc.stub.StreamObserver;
import org.wso2.custom.authenticator.local.grpc.UserOuterClass;
import org.wso2.custom.authenticator.local.grpc.userGrpc;

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
        System.out.println("AuthenticatedSubjectIdentifier - "+request.getAuthenticatedSubjectIdentifier());
        System.out.println("FederatedIdPName - "+request.getFederatedIdPName());
        System.out.println("isFederatedUser - "+request.getIsFederatedUser());
        System.out.println("TenantDomain - "+request.getTenantDomain());
        System.out.println("UserStoreDomain - "+request.getUserStoreDomain());
        System.out.println("Username - "+request.getUserName());
        String response = request.getUserStoreDomain()+request.getUserName();
        return response;
    }

}