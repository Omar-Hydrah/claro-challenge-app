package com.claroclient.response;

public enum ApiResult{
  // Must match the api response enum
  SUCCESS("success"),
  FAILURE("failure"),
  MAX_DEVICE("maxDevice"),
  TIME_RESTRATIN("timerestrain");

  private final String text;

  ApiResult(final String text){
    this.text = text;
  }

  @Override
  public String toString(){
    return this.text;
  }
}

