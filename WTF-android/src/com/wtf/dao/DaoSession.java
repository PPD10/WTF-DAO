package com.wtf.dao;

import java.util.Map;

import android.database.sqlite.SQLiteDatabase;

import com.wtf.models.Device;
import com.wtf.models.Level;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

	private final DaoConfig deviceDaoConfig;
	private final DaoConfig levelDaoConfig;

	private final DeviceDao deviceDao;
	private final LevelDao levelDao;

	public DaoSession(SQLiteDatabase db, IdentityScopeType type,
			Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap) {
		super(db);

		deviceDaoConfig = daoConfigMap.get(DeviceDao.class).clone();
		deviceDaoConfig.initIdentityScope(type);

		levelDaoConfig = daoConfigMap.get(LevelDao.class).clone();
		levelDaoConfig.initIdentityScope(type);

		deviceDao = new DeviceDao(deviceDaoConfig, this);
		levelDao = new LevelDao(levelDaoConfig, this);

		registerDao(Device.class, deviceDao);
		registerDao(Level.class, levelDao);
	}

	public void clear() {
		deviceDaoConfig.getIdentityScope().clear();
		levelDaoConfig.getIdentityScope().clear();
	}

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	public LevelDao getLevelDao() {
		return levelDao;
	}

}
