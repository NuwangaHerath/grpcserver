package service;

import io.grpc.stub.StreamObserver;
import org.wso2.custom.authenticator.local.grpc.AuthenticatedUserOuterClass;
import org.wso2.custom.authenticator.local.grpc.Service;
import org.wso2.custom.authenticator.local.grpc.serviceGrpc;

public class RoleNameServiceAthenticatedUser extends serviceGrpc.serviceImplBase {

    @Override
    public void getRoleName(AuthenticatedUserOuterClass.AuthenticatedUser request, StreamObserver<Service.Response> responseObserver) {

        System.out.println("getRoleName method call with authentucated user parameter");
        Service.Response.Builder response = Service.Response.newBuilder();
        response.setResponsemessage(processAuth(request));
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    public String processAuth(AuthenticatedUserOuterClass.AuthenticatedUser request){
        String response = request.getAuthenticatedSubjectIdentifier()+" "+request.getFederatedIdPName()+" ";
        System.out.println(response);
        //return  response;
        return "testimage";
    }
}
