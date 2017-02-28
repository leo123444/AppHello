package es.ulpgc.eite.clean.mvp.dummy.hello;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Thing;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.dummy.R;
import es.ulpgc.eite.clean.mvp.dummy.bye.ByeView;

public class HelloView
        extends GenericActivity<Hello.PresenterToView, Hello.ViewToPresenter, HelloPresenter>
        implements Hello.PresenterToView {

    private Toolbar toolbar;
    private Button sayHelloBtn;
    private Button goToHelloBtn;
    private Button goToByeButton;
    private ProgressBar progressBar;
    private TextView text;

    public ByeView bv;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        bv = new ByeView();
        text = (TextView) findViewById(R.id.helloMsg);
        if (savedInstanceState != null) {
            String textSaved = getPresenter().getHelloText();
            text.setText(textSaved);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progressHello);

        sayHelloBtn = (Button) findViewById(R.id.sayHelloBtn);
        sayHelloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getPresenter().onSayHelloBtnClicked();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        goToByeButton = (Button) findViewById(R.id.goToByeBtn);
        goToByeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayHelloBtn.setText("say Bye");
                goToByeButton.setText("go to Hello");
                sayHelloBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            getPresenter().onGoToByeBtnClicked();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                });


            }


        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }


    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(getPresenter().getHelloText(), (String) text.getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String txt = savedInstanceState.getString("message");
        text.setText(String.valueOf(txt));
    }

    @Override
    protected void onResume() {
        super.onResume(HelloPresenter.class, this);
    }

  /*
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_hello, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  */


    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideText() {
        text.setVisibility(View.GONE);
    }

    @Override
    public void showText() {
        text.setVisibility(View.VISIBLE);
    }

    @Override
    public void setText(String txt) {
        text.setText(txt);
    }

    @Override
    public void setSayHelloLabel(String txt) {
        sayHelloBtn.setText(txt);
    }

    @Override
    public void setGoToByeLabel(String txt) {
        goToByeButton.setText(txt);
    }

    @Override
    public void setSayByeLabel(String txt) {
        sayHelloBtn.setText(txt);
    }

    @Override
    public void setGoToHelloLabel(String txt) {
        goToByeButton.setText(txt);
    }

    public Button getHelloBtn() {
        return this.sayHelloBtn;
    }

    public Button getByeBtn() {
        return this.goToByeButton;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("HelloView Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


}
