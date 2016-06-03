package com.db.oliviergoutay.greendao_vs_realm.schema;

import android.database.Cursor;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;

import com.db.oliviergoutay.greendao_vs_realm.schema.MealPhoto;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEAL_PHOTO".
*/
public class MealPhotoDao extends AbstractDao<MealPhoto, Long> {

    public static final String TABLENAME = "MEAL_PHOTO";

    /**
     * Properties of entity MealPhoto.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Filename = new Property(1, String.class, "filename", false, "FILENAME");
        public final static Property DownloadUrl = new Property(2, String.class, "downloadUrl", false, "DOWNLOAD_URL");
        public final static Property PhotoType = new Property(3, String.class, "photoType", false, "PHOTO_TYPE");
    };


    public MealPhotoDao(DaoConfig config) {
        super(config);
    }
    
    public MealPhotoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEAL_PHOTO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"FILENAME\" TEXT UNIQUE ," + // 1: filename
                "\"DOWNLOAD_URL\" TEXT UNIQUE ," + // 2: downloadUrl
                "\"PHOTO_TYPE\" TEXT);"); // 3: photoType
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEAL_PHOTO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, MealPhoto entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String filename = entity.getFilename();
        if (filename != null) {
            stmt.bindString(2, filename);
        }
 
        String downloadUrl = entity.getDownloadUrl();
        if (downloadUrl != null) {
            stmt.bindString(3, downloadUrl);
        }
 
        String photoType = entity.getPhotoType();
        if (photoType != null) {
            stmt.bindString(4, photoType);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MealPhoto readEntity(Cursor cursor, int offset) {
        MealPhoto entity = new MealPhoto( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // filename
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // downloadUrl
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // photoType
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MealPhoto entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFilename(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDownloadUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPhotoType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MealPhoto entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MealPhoto entity) {
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
