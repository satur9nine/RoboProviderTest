package com.example.roboprovidertest;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.UserDictionary;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {

  private static final Uri USER_DICT_URI = Uri.parse("content://com.example.user_dictionary/words");

  ContentResolver cr;

  @Before
  public void setUp() {
    cr = ApplicationProvider.getApplicationContext().getContentResolver();
  }

  @Test
  public void testUsingProvider1() {
    ContentValues values = new ContentValues();
    values.put(UserDictionary.Words.WORD, "robolectric");
    cr.insert(USER_DICT_URI, values);

    try (Cursor c = cr.query(USER_DICT_URI, null, null, null, null)) {
      assertEquals(1, c.getCount());

      while (!c.moveToNext()) {
        System.out.println("word: " + c.getString(c.getColumnIndex(UserDictionary.Words.WORD)));
      }
    }
  }

  @Test
  public void testUsingProvider2() {
    ContentValues values = new ContentValues();
    values.put(UserDictionary.Words.WORD, "robolectric");
    cr.insert(USER_DICT_URI, values);

    try (Cursor c = cr.query(USER_DICT_URI, null, null, null, null)) {
      assertEquals(1, c.getCount());

      while (!c.moveToNext()) {
        System.out.println("word: " + c.getString(c.getColumnIndex(UserDictionary.Words.WORD)));
      }
    }
  }

}