package no.unit.alma.user;

import no.unit.alma.generated.userresourcesharingrequests.UserResourceSharingRequest;

public interface AlmaUsersResourceSharingRequests {
    UserResourceSharingRequest postUserResourceSharingRequest(UserResourceSharingRequest userResourceSharingRequest,
            String userIdentifier);

    UserResourceSharingRequest getUserResourceSharingRequest(String userIdentifier, String requestId);
}
