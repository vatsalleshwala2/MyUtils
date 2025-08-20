# MyUtils

&#10240; <!-- line space -->
&#10240; <!-- line space -->

- Dialog
  |Application class define dialog | Customize dialog |
  |-------- | ---|
  | ![dialog1](https://github.com/vatsalleshwala2/MyUtils/assets/114224740/2b2d44d2-b87a-4ba2-8873-9d99afa49632) | ![dialog2](https://github.com/vatsalleshwala2/MyUtils/assets/114224740/13801cea-f120-4b0b-a79f-b67565ff7a8e) |

&#10240; <!-- line space -->
&#10240; <!-- line space -->

- Toast
  |Toast Success | Toast Error|
  |-------- | ---|
  |![toast_success](https://github.com/vatsalleshwala2/MyUtils/assets/114224740/c2cee76a-3c97-4185-aa2e-0a61362f5848) | ![toast_error](https://github.com/vatsalleshwala2/MyUtils/assets/114224740/88b254b5-d479-4cf3-968c-aa007081439e) |

  |Toast Info | Toast Warning|
  |-------- | ---|
  |![toast_info](https://github.com/vatsalleshwala2/MyUtils/assets/114224740/ff03aa5f-c62c-4b40-97ef-6772a9694f3a) | ![toast_warning](https://github.com/vatsalleshwala2/MyUtils/assets/114224740/ffec3bad-b4b7-471d-a4ac-0a45e7fa74bb) |
  
&#10240; <!-- line space -->
&#10240; <!-- line space -->

> Step 1. Add the JitPack repository to your build.gradle(project) file
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

&#10240; <!-- line space -->
&#10240; <!-- line space -->

> Step 2. Add the dependency build.gradle(app)
```gradle
dependencies {
	        implementation 'com.github.vatsalleshwala2:MyUtils:1.4.4'
	}
```

&#10240; <!-- line space -->
&#10240; <!-- line space -->

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


- Dialog initialize

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
