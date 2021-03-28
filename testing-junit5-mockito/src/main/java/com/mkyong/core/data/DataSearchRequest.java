package com.mkyong.core.data;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class DataSearchRequest {
  String id;

  Date updatedBefore;

  int length;
}
