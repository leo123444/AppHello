package es.ulpgc.eite.clean.mvp.dummy.bye;

import es.ulpgc.eite.clean.mvp.GenericModel;


public class ByeModel extends GenericModel<Bye.ModelToPresenter>
    implements Bye.PresenterToModel {

  private String ByeText;
  private String sayByeLabel;
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
  public void onCreate(Bye.ModelToPresenter presenter) {
    super.onCreate(presenter);

    sayByeLabel = "Say Bye";
    goToHelloLabel = "Go to Hello";
    ByeText = "Bye World!";
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
    msgText = ByeText;
  }

  @Override
  public String getText() {
    return msgText;
  }

  @Override
  public String getSayByeLabel() {
    return sayByeLabel;
  }

  @Override
  public String getGoToHelloLabel() {
    return goToHelloLabel;
  }
}
