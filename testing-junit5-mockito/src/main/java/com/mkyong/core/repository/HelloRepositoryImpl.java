package com.mkyong.core.repository;

import com.mkyong.core.client.ReceiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

  @Autowired
  private ReceiveClient receiveClient;

    @Override
    public String get() {
        return "Hello JUnit 5";
    }

  @Override
  public String getName() {
    return "Name Bars";
  }

  @Override
  public String getNameCity() {
    return getCity();
  }

  private String getCity() {
    return "Bern " + getCat() + receiveClient.getMaster();
  }

  @Override
  public String getCat() {
      return "Rex";
  }

}
