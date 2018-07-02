package com.cot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PlacementNotContainCampaignException extends RuntimeException {

    public PlacementNotContainCampaignException(Long objectId) {
        super(String.format("Placement with id %s doesn't contain Campaign", objectId));
    }
}