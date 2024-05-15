package com.studentbotique;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static org.junit.Assert.assertTrue;
import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import com.studentbotique.constants.AppConstants;

public class PaymentUITest {

    public String launcherPackage = "com.studentbotique";
    public int TIME_OUT = 5000;
    UiDevice device;

    @Before
    public void setup() {
        device = UiDevice.getInstance(getInstrumentation());
        Context context = ApplicationProvider.getApplicationContext();
        Intent launcherIntent = context.getPackageManager().getLaunchIntentForPackage(launcherPackage);
        launcherIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(launcherIntent);
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), TIME_OUT);
    }

    @Test
    public void testSmartPaySuccessful() throws UiObjectNotFoundException {
        UiObject depositBox=device.findObject(new UiSelector().text("Enter a deposit"));
        depositBox.setText("200");
        UiObject proceedButton=device.findObject(new UiSelector().text("PROCEED"));
        proceedButton.clickAndWaitForNewWindow();
        UiObject shoppingButton=device.findObject(new UiSelector().text("GO SHOPPING"));
        shoppingButton.clickAndWaitForNewWindow();
        UiObject categorySpinner = device.findObject(new UiSelector().text("Select a category"));
        categorySpinner.click();
        List<UiObject2> categories = device.findObjects(By.res("android:id/text1"));
        categories.get(2).click();
        UiObject searchButton=device.findObject(new UiSelector().text("SEARCH"));
        searchButton.click();
        UiScrollable recyclerView = new UiScrollable(new UiSelector().scrollable(false));
        assertTrue(recyclerView.exists());
        recyclerView.scrollIntoView(new UiSelector().text("Sherlock Holmes"));
        UiObject sherlock = device.findObject(new UiSelector().text("Sherlock Holmes"));
        sherlock.clickAndWaitForNewWindow();
        UiObject paymentSpinner = device.findObject(new UiSelector().text("Select a method"));
        paymentSpinner.click();
        List<UiObject2> paymentOptions = device.findObjects(By.res("android:id/text1"));
        paymentOptions.get(3).click();
        UiObject showBalance=device.findObject(new UiSelector().text("SHOW BALANCE"));
        showBalance.click();
        UiObject payNowButton=device.findObject(new UiSelector().text("PAY NOW"));
        payNowButton.click();
        device.wait(Until.hasObject(By.text(AppConstants.PAYMENT_SUCCESSFUL)), TIME_OUT);
        UiObject snackBar=device.findObject(new UiSelector().text(AppConstants.PAYMENT_SUCCESSFUL));
        assertTrue(snackBar.exists());
    }

    @Test
    public void testSmartPayUnsuccessful() throws UiObjectNotFoundException {
        UiObject depositBox=device.findObject(new UiSelector().text("Enter a deposit"));
        depositBox.setText("200");
        UiObject proceedButton=device.findObject(new UiSelector().text("PROCEED"));
        proceedButton.clickAndWaitForNewWindow();
        UiObject shoppingButton=device.findObject(new UiSelector().text("GO SHOPPING"));
        shoppingButton.clickAndWaitForNewWindow();
        UiObject categorySpinner = device.findObject(new UiSelector().text("Select a category"));
        categorySpinner.click();
        List<UiObject2> categories = device.findObjects(By.res("android:id/text1"));
        categories.get(1).click();
        UiObject searchButton=device.findObject(new UiSelector().text("SEARCH"));
        searchButton.click();
        UiScrollable recyclerView = new UiScrollable(new UiSelector().scrollable(false));
        assertTrue(recyclerView.exists());
        recyclerView.scrollIntoView(new UiSelector().text("Winter Jacket"));
        UiObject jacket = device.findObject(new UiSelector().text("Winter Jacket"));
        jacket.clickAndWaitForNewWindow();
        UiObject paymentSpinner = device.findObject(new UiSelector().text("Select a method"));
        paymentSpinner.click();
        List<UiObject2> paymentOptions = device.findObjects(By.res("android:id/text1"));
        paymentOptions.get(3).click();
        UiObject showBalance=device.findObject(new UiSelector().text("SHOW BALANCE"));
        showBalance.click();
        UiObject payNowButton=device.findObject(new UiSelector().text("PAY NOW"));
        payNowButton.click();
        device.wait(Until.hasObject(By.text(AppConstants.PAYMENT_FAILED)), TIME_OUT);
        UiObject snackBar=device.findObject(new UiSelector().text(AppConstants.PAYMENT_FAILED));
        assertTrue(snackBar.exists());
    }

}
