package es.ulpgc.eite.clean.mvp.dummy.hello;

import es.ulpgc.eite.clean.mvp.GenericModel;


public class HelloModel  extends GenericModel<Hello.ModelToPresenter>
    implements Hello.PresenterToModel {

  private String helloText;
  private String ByeText;
  private String sayHelloLabel;
  private String goToByeLabel;
  private String SayByeLabel;
  private String goToHelloLabel;
  private int numOfTimes;
  private String msgText;

  /**
   * Method that recovers a reference to the PRESENTER
   * You must ALWAYS call {@link super#onCreate(Object)} here
   *
   * @param presenter Presenter interface
   */
  @Override
  public void onCreate(Hello.ModelToPresenter presenter) {
    super.onCreate(presenter);

    sayHelloLabel = "Say Hello";
    goToByeLabel = "Go to Bye";
    SayByeLabel="Say Bye";
    goToHelloLabel="goToHello";
    helloText = "Hello World!";
    ByeText="Bye World!";
  }

  /**
   * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
   * Usefull for kill/stop activities that could be running on the background Threads
   *
   * @param isChangingConfiguration Informs that a change is occurring on the configuration
   */
  @Override
  public void onDestroy(boolean isChangingConfiguration) {

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To Model ////////////////////////////////////////////////////////////


  @Override
  public void onChangeMsgByBtnClicked() {

  }

  @Override
  public void onChangeMsgByHelloBtnClicked() {
    msgText = helloText;
  }
  @Override
  public void onChangeMsgByByeBtnClicked() {
    msgText = ByeText;
  }
  @Override
  public String getText() {
    return null;
  }

  @Override
  public String getTextofHello() {
    return helloText;
  }
  @Override
  public String getTextofBye() {
    return ByeText;
  }
  @Override
  public String getSayHelloLabel() {
    return sayHelloLabel;
  }

  @Override
  public String getGoToByeLabel() {
    return goToByeLabel;
  }
  @Override
  public String getGoToHelloLabel() {
    return goToHelloLabel;
  }

  @Override
  public String getSayByeLabel() {
    return SayByeLabel;
  }

}
