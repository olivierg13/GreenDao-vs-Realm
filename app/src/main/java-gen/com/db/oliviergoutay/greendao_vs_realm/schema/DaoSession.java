package com.db.oliviergoutay.greendao_vs_realm.schema;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.db.oliviergoutay.greendao_vs_realm.schema.DailyMeal;
import com.db.oliviergoutay.greendao_vs_realm.schema.Meal;
import com.db.oliviergoutay.greendao_vs_realm.schema.MealPhoto;
import com.db.oliviergoutay.greendao_vs_realm.schema.MealItem;

import com.db.oliviergoutay.greendao_vs_realm.schema.DailyMealDao;
import com.db.oliviergoutay.greendao_vs_realm.schema.MealDao;
import com.db.oliviergoutay.greendao_vs_realm.schema.MealPhotoDao;
import com.db.oliviergoutay.greendao_vs_realm.schema.MealItemDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dailyMealDaoConfig;
    private final DaoConfig mealDaoConfig;
    private final DaoConfig mealPhotoDaoConfig;
    private final DaoConfig mealItemDaoConfig;

    private final DailyMealDao dailyMealDao;
    private final MealDao mealDao;
    private final MealPhotoDao mealPhotoDao;
    private final MealItemDao mealItemDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dailyMealDaoConfig = daoConfigMap.get(DailyMealDao.class).clone();
        dailyMealDaoConfig.initIdentityScope(type);

        mealDaoConfig = daoConfigMap.get(MealDao.class).clone();
        mealDaoConfig.initIdentityScope(type);

        mealPhotoDaoConfig = daoConfigMap.get(MealPhotoDao.class).clone();
        mealPhotoDaoConfig.initIdentityScope(type);

        mealItemDaoConfig = daoConfigMap.get(MealItemDao.class).clone();
        mealItemDaoConfig.initIdentityScope(type);

        dailyMealDao = new DailyMealDao(dailyMealDaoConfig, this);
        mealDao = new MealDao(mealDaoConfig, this);
        mealPhotoDao = new MealPhotoDao(mealPhotoDaoConfig, this);
        mealItemDao = new MealItemDao(mealItemDaoConfig, this);

        registerDao(DailyMeal.class, dailyMealDao);
        registerDao(Meal.class, mealDao);
        registerDao(MealPhoto.class, mealPhotoDao);
        registerDao(MealItem.class, mealItemDao);
    }
    
    public void clear() {
        dailyMealDaoConfig.getIdentityScope().clear();
        mealDaoConfig.getIdentityScope().clear();
        mealPhotoDaoConfig.getIdentityScope().clear();
        mealItemDaoConfig.getIdentityScope().clear();
    }

    public DailyMealDao getDailyMealDao() {
        return dailyMealDao;
    }

    public MealDao getMealDao() {
        return mealDao;
    }

    public MealPhotoDao getMealPhotoDao() {
        return mealPhotoDao;
    }

    public MealItemDao getMealItemDao() {
        return mealItemDao;
    }

}
