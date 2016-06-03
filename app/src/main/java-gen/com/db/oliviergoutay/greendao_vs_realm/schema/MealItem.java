package com.db.oliviergoutay.greendao_vs_realm.schema;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "MEAL_ITEM".
 */
public class MealItem {

    private Long id;
    /** Not-null value. */
    private String item;
    private long mealId;

    public MealItem() {
    }

    public MealItem(Long id) {
        this.id = id;
    }

    public MealItem(Long id, String item, long mealId) {
        this.id = id;
        this.item = item;
        this.mealId = mealId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getItem() {
        return item;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setItem(String item) {
        this.item = item;
    }

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

}
