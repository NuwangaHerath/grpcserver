package service;

import io.grpc.stub.StreamObserver;
import org.wso2.custom.authenticator.local.grpc.AuthenticatedUserOuterClass;
import org.wso2.custom.authenticator.local.grpc.ClaimMappingOuterClass;
import org.wso2.custom.authenticator.local.grpc.MapEntryOuterClass;
import org.wso2.custom.authenticator.local.grpc.Service;
import org.wso2.custom.authenticator.local.grpc.serviceGrpc;

import java.util.Map;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        String response = request.getAuthenticatedSubjectIdentifier()+" "+request.getFederatedIdPName()+" ";
        System.out.println(response);
        for (MapEntryOuterClass.MapEntry mapEntry : request.getUserAttributesList()) {
            System.out.println(mapEntry.getKey()+" "+mapEntry.getValue());
        }
        //return  response;
        return "testimage";
    }
}
