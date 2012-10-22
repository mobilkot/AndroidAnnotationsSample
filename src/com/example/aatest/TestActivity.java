package com.example.aatest;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.InstanceState;
import com.googlecode.androidannotations.annotations.TextChange;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.StringRes;

@EActivity(R.layout.test_activity)
public class TestActivity extends Activity {

	@ViewById
	protected EditText testactivity_first_edittext;

	@ViewById(R.id.testactivity_second_edittext)
	protected TextView secondTextView;

	@InstanceState
	protected String stateToSave;

	@StringRes(R.string.hello_world)
	protected String myHelloString;

	@Extra
	protected String myMessage;

	@AfterViews
	protected void updateTextWithDate() {
		testactivity_first_edittext.setText("Date: ");
		secondTextView.setText(myMessage);
	}

	@Click(R.id.testactivity_first_button)
	protected void firstButtonWasClicked() {
		secondTextView.setText("first button was clicked");
	}

	@TextChange(R.id.testactivity_second_edittext)
	protected void onTextChangesOnSomeTextViews(TextView tv, CharSequence text) {
		Toast.makeText(this, "second textview was changed", Toast.LENGTH_SHORT).show();
	}

	@Click(R.id.testactivity_second_button)
	protected void secondButtonWasClicked() {
		backgroundWork();
	}

	@Background
	protected void backgroundWork() {
		publishProgress(0);
		publishProgress(10);
		publishProgress(100);
		onBGTaskFinish("bg task finished");
	}

	@UiThread
	void publishProgress(int progress) {
		testactivity_first_edittext.setText("Background task progress: "+ progress);
	}
	
	@UiThread
	void onBGTaskFinish(String resultText){
		secondTextView.setText(resultText);
	}

}
