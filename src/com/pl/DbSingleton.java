// The singleton design pattern is used to create a single instance that may have some state that is shared accross
// multiple resources in an application.
// There will only ever be a single instance of the singleton (hence the name)
// Examples may include a runtime, a logger
// Drawbacks include that the application may be harder to test due to this pattern and it introduces a sort of
// global state that may become hard to manage

package com.pl;

public class DbSingleton {
  private static volatile DbSingleton instance = null;

  private DbSingleton() {
    if (instance !=  null)  {
      throw new RuntimeException("Use getInstance() method to create");
    }
  } // private constructor doesn't allow for external creation of instance

  public static DbSingleton getInstance() { // instance can only be returned with this method
    if (instance ==  null) {
      synchronized (DbSingleton.class) { // avoid thread race conditions
        if (instance == null) {
          instance = new DbSingleton(); //lazy loading
        }
      }
    }
    return instance;
  }
}
