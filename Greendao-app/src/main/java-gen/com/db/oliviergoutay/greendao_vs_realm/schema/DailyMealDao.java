package com.db.oliviergoutay.greendao_vs_realm.schema;

import android.database.Cursor;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;

import com.db.oliviergoutay.greendao_vs_realm.schema.DailyMeal;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAILY_MEAL".
*/
public class DailyMealDao extends AbstractDao<DailyMeal, Long> {

    public static final String TABLENAME = "DAILY_MEAL";

    /**
     * Properties of entity DailyMeal.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EatenOn = new Property(1, long.class, "eatenOn", false, "EATEN_ON");
        public final static Property GlassesWater = new Property(2, Integer.class, "glassesWater", false, "GLASSES_WATER");
        public final static Property UpdatedAt = new Property(3, Long.class, "updatedAt", false, "UPDATED_AT");
        public final static Property Reflection = new Property(4, String.class, "reflection", false, "REFLECTION");
    };

    private DaoSession daoSession;


    public DailyMealDao(DaoConfig config) {
        super(config);
    }
    
    public DailyMealDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAILY_MEAL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"EATEN_ON\" INTEGER NOT NULL UNIQUE ," + // 1: eatenOn
                "\"GLASSES_WATER\" INTEGER," + // 2: glassesWater
                "\"UPDATED_AT\" INTEGER," + // 3: updatedAt
                "\"REFLECTION\" TEXT);"); // 4: reflection
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_DAILY_MEAL_EATEN_ON ON DAILY_MEAL" +
                " (\"EATEN_ON\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAILY_MEAL\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, DailyMeal entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getEatenOn());
 
        Integer glassesWater = entity.getGlassesWater();
        if (glassesWater != null) {
            stmt.bindLong(3, glassesWater);
        }
 
        Long updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindLong(4, updatedAt);
        }
 
        String reflection = entity.getReflection();
        if (reflection != null) {
            stmt.bindString(5, reflection);
        }
    }

    @Override
    protected void attachEntity(DailyMeal entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DailyMeal readEntity(Cursor cursor, int offset) {
        DailyMeal entity = new DailyMeal( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // eatenOn
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // glassesWater
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // updatedAt
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // reflection
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DailyMeal entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEatenOn(cursor.getLong(offset + 1));
        entity.setGlassesWater(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setUpdatedAt(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setReflection(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DailyMeal entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DailyMeal entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}