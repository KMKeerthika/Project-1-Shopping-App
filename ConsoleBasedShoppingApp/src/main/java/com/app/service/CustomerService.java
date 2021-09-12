package com.app.service;

import com.app.exception.BusinessException;

public interface CustomerService
{
  public boolean orderUpdate(int custId) throws BusinessException;
}
