package Bai10_Annotation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ParentClass {
    @BeforeSuite
    public void beforeSuiteParent() {
        System.out.println("Before Suite Parent");
    }

    @AfterSuite
    public void afterSuiteParent() {
        System.out.println("After Suite Parent");
    }

    @BeforeTest
    public void beforeTestParent() {
        System.out.println("Before Test Parent");
    }

    @AfterTest
    public void afterTestParent() {
        System.out.println("After Test Parent");
    }
}
