AdbToggleAccessLib
==================

Access USB debug settings using the ***ADB Toggle*** app.

In order to use the functionality in your app you need to have ***ADB Toggle*** installed as system application on your phone!
If ***ADB Toggle*** is not available or not properly installed then then functions in AdbToggleAccessLib will not succeed!

Here are the required steps to add AdbToggleAccessLib into your own app:

1. Import the AdbToggleAccessLib library project into your project

2. Add the ***ADB Toggle*** permission to your AndroidManifest.xml

	```java
	<uses-permission android:name="ramdroid.permission.ADB_TOGGLE" />
	```
	
3. Before you toggle USB debug settings you need to check if ADB Toggle is installed:

	```java
	boolean isInstalled = AdbToggleAccess.isInstalled(this);
	```
	
	If this function returns false then guide the user to the Google Play download page for ADB Toggle:

	```java
	AdbToggleAccess.install(this);
	```
	
	*Hint:*
	Currently there is not check if ADB Toggle is really installed as system app. At this point
	we just assume that the user is doing this on his own! ;)
	
4. Now you can check if USB debug settings are enabled...

	```java
	boolean isEnabled = AdbToggleAccess.isEnabled(this);
	```
	
5. ...or you can enable/disable USB debug settings by creating an instance of AdbToggleAccess class:

	```java
	AdbToggleAccess adbToggle = new AdbToggleAccess();
	boolean result = adbToggle.enable(this, new OnAdbToggleListener() {
		public void onFinished(boolean successful) {
			// TO DO: Now call some function that needs USB debug settings enabled
		}
	});
	```
	
	When finished with your work don't forget to disable USB debug settings:

	```java
	AdbToggleAccess adbToggle = new AdbToggleAccess();
	boolean result = adbToggle.disable(this, new OnAdbToggleListener() {
		public void onFinished(boolean successful) {
			// Now USB debug settings are disabled again
		}
	});
	```
	
	*Hint:*
	When the `adbToggle.enable()` or `adbToggle.disable()` functions are returning false then either ***ADB Toggle*** is not properly installed or your did forget to add the ***ADB Toggle*** permission to your project.
