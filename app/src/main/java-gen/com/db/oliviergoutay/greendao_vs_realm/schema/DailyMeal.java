package com.db.oliviergoutay.greendao_vs_realm.schema;

import java.util.List;
import com.db.oliviergoutay.greendao_vs_realm.schema.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "DAILY_MEAL".
 */
public class DailyMeal {

    private Long id;
    private long eatenOn;
    private Integer glassesWater;
    private Long updatedAt;
    private String reflection;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient DailyMealDao myDao;

    private List<Meal> meals;

    public DailyMeal() {
    }

    public DailyMeal(Long id) {
        this.id = id;
    }

    public DailyMeal(Long id, long eatenOn, Integer glassesWater, Long updatedAt, String reflection) {
        this.id = id;
        this.eatenOn = eatenOn;
        this.glassesWater = glassesWater;
        this.updatedAt = updatedAt;
        this.reflection = reflection;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDailyMealDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEatenOn() {
        return eatenOn;
    }

    public void setEatenOn(long eatenOn) {
        this.eatenOn = eatenOn;
    }

    public Integer getGlassesWater() {
        return glassesWater;
    }

    public void setGlassesWater(Integer glassesWater) {
        this.glassesWater = glassesWater;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReflection() {
        return reflection;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Meal> getMeals() {
        if (meals == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MealDao targetDao = daoSession.getMealDao();
            List<Meal> mealsNew = targetDao._queryDailyMeal_Meals(eatenOn);
            synchronized (this) {
                if(meals == null) {
                    meals = mealsNew;
                }
            }
        }
        return meals;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMeals() {
        meals = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
