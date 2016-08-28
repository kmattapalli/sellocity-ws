/*
Educational Online Test Delivery System Copyright (c) 2013 American Institutes for Research

Distributed under the AIR Open Source License, Version 1.0 See accompanying file AIR-License-1_0.txt or at
https://bitbucket.org/sbacoss/eotds/wiki/AIR_Open_Source_License
 */

package com.sales.module.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileUploadResponse implements Serializable {

    private int statusCode;
    private String fileName;
    private String message;
    

    private static final long serialVersionUID = -6913478273842169850L;

    public String getMessage() {
        return message;
    }

    public void setMessage(final String inMessage) {
        this.message = inMessage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String inFileName) {
        this.fileName = inFileName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final int inStatusCode) {
        this.statusCode = inStatusCode;
    }


}
