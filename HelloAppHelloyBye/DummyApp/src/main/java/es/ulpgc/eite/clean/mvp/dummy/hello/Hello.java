package es.ulpgc.eite.clean.mvp.dummy.hello;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by Luis on 12/11/16.
 */

public interface Hello  {


  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  interface ToHello {
    void onScreenStarted() throws InterruptedException;
    void setToolbarVisibility(boolean visible);
    void setTextVisibility(boolean visible);
  }

  interface HelloTo {
    Context getManagedContext();
    void destroyView();
    boolean isToolbarVisible();
    boolean isTextVisible();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Screen ////////////////////////////////////////////////////////////////////////

  /**
   * Methods offered to VIEW to communicate with PRESENTER
   */
  interface ViewToPresenter extends Presenter<PresenterToView> {
    void onSayHelloBtnClicked() throws InterruptedException;
    void onGoToByeBtnClicked() throws InterruptedException;

    String getHelloText();
  }

  /**
   * Required VIEW methods available to PRESENTER
   */
  interface PresenterToView extends ContextView {
    void finishScreen();
    void hideToolbar();
    void hideProgressBar();
    void showProgressBar();
    void hideText();
    void showText();
    void setText(String txt);
    void setSayHelloLabel(String txt);
    void setGoToByeLabel(String txt);

    void setSayByeLabel(String txt);

    void setGoToHelloLabel(String txt);
  }

  /**
   * Methods offered to MODEL to communicate with PRESENTER
   */
  interface PresenterToModel extends Model<ModelToPresenter> {
    void onChangeMsgByBtnClicked();

    void onChangeMsgByHelloBtnClicked();

    void onChangeMsgByByeBtnClicked();

    String getText();

    String getTextofHello();

    String getTextofBye();

    String getSayHelloLabel();
    String getGoToByeLabel();

    String getGoToHelloLabel();

    String getSayByeLabel();
  }

  /**
   * Required PRESENTER methods available to MODEL
   */
  interface ModelToPresenter {

  }
}
