package com.wtf;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.wtf.dao.DaoMaster;
import com.wtf.dao.DaoMaster.DevOpenHelper;
import com.wtf.dao.DaoSession;

public class WTFActivity extends AndroidApplication {

	private SQLiteDatabase db;

	private DaoMaster daoMaster;
	private DaoSession daoSession;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useAccelerometer = false;
		cfg.useCompass = false;

		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "wtf-db", null);
		db = helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();

		initialize(new WTF(daoSession), cfg);
	}

}