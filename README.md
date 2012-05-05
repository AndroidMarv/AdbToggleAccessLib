ADB Toggle
==================

***ADB Toggle*** is a small security app to enable/disable USB debug settings. If you are an Android developer
yourself or if you're playing around with Custom ROMs or root apps then you typically have this setting enabled.
However you compromise your private data when you lose your phone as the thief could easily by-pass any existing
security mechanisms.

There's a free version that will allow you to toggle USB debug settings from a widget, and also allows third party
root apps to temporary enable USB debug settings, and disable it again once they are finished with their job.

In the paid version of ***ADB Toggle*** there's also an automatic mode that enables USB debug settings when you
have unlocked your phone and connect it to your PC, and disables it when you leave.

Read more about ***ADB Toggle*** on http://ramdroid.wordpress.com

AdbToggleAccessLib
==================

This is an Android library project to access USB debug settings using the ***ADB Toggle*** app.

In this repository you'll find a library project so you can add support for ***ADB Toggle*** into your own apps.
There's also a simple example project that demonstrates the functionality.

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
	When the `adbToggle.enable()` or `adbToggle.disable()` functions are returning false then either ***ADB Toggle*** is not properly installed or you did forget to add the ***ADB Toggle*** permission to your project.
