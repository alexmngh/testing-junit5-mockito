package com.mkyong.core.services;

import com.mkyong.core.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloRepository helloRepository;

    @Override
    public String get() {
        return helloRepository.get();
    }

  @Override
  public String getName() {
    return helloRepository.getName();
  }

  @Override
  public String getNameCity() {
    return helloRepository.getNameCity();
  }


}
