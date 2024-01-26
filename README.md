# MyUtils


> Step 1. Add the JitPack repository to your build.gradle(project) file

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


> Step 2. Add the dependency build.gradle(app)

```gradle
dependencies {
	        implementation 'com.github.vatsalleshwala2:MyUtils:1.4.4'
	}
```


> Step 3. Add this code application class

- set Context and Activity
```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ActivityAndContextSet.setContext(getApplicationContext());

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity a, @Nullable Bundle savedInstanceState) {
                ActivityAndContextSet.setActivity(a);
            }

            @Override
            public void onActivityStarted(@NonNull Activity a) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity a) {
                ActivityAndContextSet.setActivity(a);
            }

            @Override
            public void onActivityPaused(@NonNull Activity a) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity a) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity a, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity a) {

            }
        });
    }
}
```


- Shared Preferences initialize

```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SPUtilsStatic.initSessionManager("My Utils");

    }
}
```


- Toast initialize

```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ToastUtils.getInstance().initialize();

    }
}
```


- Toast initialize

```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DialogUtils.dialogUtilsParamsSet(
                5, // Dots Count
                Color.parseColor("#00ff00"), // Dots Color
                Color.parseColor("#FF0000"), // Message Color
                16, // Message Text Size
                Color.WHITE, // Background Color
                false // Cancelable
        );

    }
}
```

- Final define all utils
```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ActivityAndContextSet.setContext(getApplicationContext());
        SPUtilsStatic.initSessionManager("My Utils");
        ToastUtils.getInstance().initialize();
        DialogUtils.dialogUtilsParamsSet(5,
                Color.parseColor("#00ff00"),
                Color.parseColor("#FF0000"),
                16,
                Color.WHITE,
                false
        );

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity a, @Nullable Bundle savedInstanceState) {
                ActivityAndContextSet.setActivity(a);
            }

            @Override
            public void onActivityStarted(@NonNull Activity a) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity a) {
                ActivityAndContextSet.setActivity(a);
            }

            @Override
            public void onActivityPaused(@NonNull Activity a) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity a) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity a, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity a) {

            }
        });
    }
}
```
