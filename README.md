AdbToggleAccessLib
==================

Access USB debug settings using the ***ADB Toggle*** app.

In order to use the functionality in your app you need to have ***ADB Toggle*** installed as system application on your phone!
If ***ADB Toggle*** is not available or not properly installed then then functions in AdbToggleAccessLib will not succeed!

Here are the required steps to add AdbToggleAccessLib into your own app:

1. Clone the AdbToggleAccessLib project and import it into your Eclipse workspace.

2. In Eclipse go to Properties --> Android and add the AdbToggleAccessLib library project

3. Add the ***ADB Toggle*** permission to your AndroidManifest.xml

	`<uses-permission android:name="ramdroid.permission.ADB_TOGGLE" />`
	
4. That's it! Now you can check if USB debug settings are enabled...

	`boolean isEnabled = AdbToggleAccess.isEnabled(this);`
	
5. ...or you can enable USB debug settings by creating an instance of AdbToggleAccess class:

	`AdbToggleAccess adbToggle = new AdbToggleAccess();
	boolean result = adbToggle.enable(this, new OnAdbToggleListener() {

		public void onFinished(boolean successful) {
			// TO DO: Now call some function that needs USB debug settings enabled
		}
		
	});`
	
6. When finished with your work don't forget to disable USB debug settings:

	`AdbToggleAccess adbToggle = new AdbToggleAccess();
	boolean result = adbToggle.disable(this, new OnAdbToggleListener() {

		public void onFinished(boolean successful) {
			// Now USB debug settings are disabled again			
		}
		
	});`
	
7. Hint: When the `adbToggle.enable()` or `adbToggle.disable()` functions are returning false then either ***ADB Toggle*** is not properly installed or your did forget to add the ***ADB Toggle*** permission to your project.
