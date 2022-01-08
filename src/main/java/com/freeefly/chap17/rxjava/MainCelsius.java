//package com.freeefly.chap17.rxjava;
//
//import static com.freeefly.chap17.rxjava.TempObservable.getCelsiusTemperatures;
//
//import io.reactivex.Observable;
//import com.freeefly.chap17.TempInfo;
//
//public class MainCelsius {
//
//  public static void main(String[] args) {
//    Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
//    observable.subscribe(new TempObserver());
//
//    try {
//      Thread.sleep(10000L);
//    }
//    catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//}
