package com.mkyong.core.client;

import org.springframework.stereotype.Component;

@Component
public class ReceiveClientImpl implements ReceiveClient{

  @Override
  public String getMaster() {
    return " Oliver";
  }

}
