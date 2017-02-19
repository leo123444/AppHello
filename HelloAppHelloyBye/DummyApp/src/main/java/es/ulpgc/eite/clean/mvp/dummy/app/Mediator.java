package es.ulpgc.eite.clean.mvp.dummy.app;

import es.ulpgc.eite.clean.mvp.dummy.bye.Bye;
import es.ulpgc.eite.clean.mvp.dummy.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.dummy.hello.Hello;

public interface Mediator {
  void startingDummyScreen(Dummy.ToDummy presenter);

  void startingHelloScreen(Hello.ToHello presenter) throws InterruptedException;

  void startingByeScreen(Bye.ToBye presenter) throws InterruptedException;
}
