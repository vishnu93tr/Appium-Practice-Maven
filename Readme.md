appium java maven testng project
1.started appium server programatically
2.completed automation of ecommerce app in Android platform
3.completed integration in jenkins


scrolling code in ios:
Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);
        driver.swipe(x, starty, x, endy, 2000);
        driver.findElementByAccessibilityId("Steppers").click();
