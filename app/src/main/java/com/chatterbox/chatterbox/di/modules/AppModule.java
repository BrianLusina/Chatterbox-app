package com.chatterbox.chatterbox.di.modules;

import android.app.Application;
import android.content.Context;

import com.chatterbox.chatterbox.BuildConfig;
import com.chatterbox.chatterbox.data.DataManager;
import com.chatterbox.chatterbox.data.DataManagerImpl;
import com.chatterbox.chatterbox.data.api.ApiHelper;
import com.chatterbox.chatterbox.data.api.ApiHelperImpl;
import com.chatterbox.chatterbox.data.db.DbHelper;
import com.chatterbox.chatterbox.data.db.DbHelperImpl;
import com.chatterbox.chatterbox.data.prefs.PrefsHelper;
import com.chatterbox.chatterbox.data.prefs.PrefsHelperImpl;
import com.chatterbox.chatterbox.di.ApiInfo;
import com.chatterbox.chatterbox.di.ApplicationContext;
import com.chatterbox.chatterbox.di.DatabaseInfo;
import com.chatterbox.chatterbox.di.PreferenceInfo;
import com.chatterbox.chatterbox.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author lusinabrian on 02/06/17.
 * @Notes Application Module to provide application specific dependencies. This will be used
 * to provide objects that will be available for injection in requesting classes
 * {@link com.chatterbox.chatterbox.di.components.AppComponent} will handle injecting them
 * into requesting classes. The methods annotated with {@link dagger.Provides} will be used
 * for injection
 */

@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicatonContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @ApiInfo
    String provideFacebookAppId(){
        return BuildConfig.FACEBOOK_APP_ID;
    }

    @Provides
    @ApiInfo
    String provideTwitterConsumerSecret(){
        return BuildConfig.TWITTER_SECRET;
    }

    @Provides
    @ApiInfo
    String provideTwitterConsumerKey(){
        return BuildConfig.TWITTER_CONSUMER_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceFileName(){
        return Constants.CHATTERBOX_PREF_KEY;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return Constants.CHATTERBOX_DB_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImpl dataManager){
        return dataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImpl apiHelper){
        return apiHelper;
    }

    @Provides
    @Singleton
    PrefsHelper providePrefsHelper(PrefsHelperImpl prefsHelper){
        return prefsHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl dbHelper){
        return dbHelper;
    }
}
