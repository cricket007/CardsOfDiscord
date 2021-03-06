package edu.rosehulman.csse.cardsofdiscord;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import edu.rosehulman.csse.cardsofdiscord.model.GameController;
import edu.rosehulman.csse.cardsofdiscord.util.ApplicationController;
import edu.rosehulman.csse.cardsofdiscord.util.BluetoothChatService;
import edu.rosehulman.csse.cardsofdiscord.util.SessionManager;

public abstract class BaseFragmentActivity extends FragmentActivity {

    protected final SessionManager mPrefs;
	protected GameController mGameController;
    protected BluetoothChatService mBtChatService;

    public BaseFragmentActivity() {
        this.mPrefs = SessionManager.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameController = ApplicationController.getGameController();
        final View v = this.getWindow().getDecorView();
        Resources r = getResources();
        if (mPrefs.isDiscordMode()) {
            v.setBackgroundColor(r.getColor(R.color.black));
        	this.setTheme(R.style.Theme_Discord);
        } else {
			this.setTheme(R.style.Theme_Harmony);
            v.setBackgroundColor(r.getColor(R.color.green));
        }
    }
}
