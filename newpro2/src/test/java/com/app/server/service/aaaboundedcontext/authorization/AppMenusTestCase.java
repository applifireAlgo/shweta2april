package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAction("vPxyzJpkYGUCuqjaggGrbARQCROUflAuuU8FFMuUhEagrmSdZV");
        appmenus.setMenuCommands("eDefgtmY0idPVTmB0HANqpEc69pgDgRovNyIoBKWZfQHCKL22R");
        appmenus.setMenuAccessRights(6);
        appmenus.setMenuHead(true);
        appmenus.setUiType("CS8");
        appmenus.setAppType(2);
        appmenus.setAppId("2gwjE0Zk8FhgXG2JFHvxPgZfCRmyYm4TqlDLXgzNC1kJJFrCQD");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuTreeId("LzAZ7RbVFMcFkv5MiyZNwvxIb6ZlOfLKqVeRQcL1pD3rfXWxR8");
        appmenus.setMenuLabel("yhpT0fY2N9eJTvaKklsdsT7DNJ7FlxsFMZLiy1LxTq9nhzkooI");
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("KnPoA8WjwUGiQwFHZQUrt1V000POaLrYvNYdk0Jzlh6L3HxmtW");
        appmenus.setMenuIcon("39G13aDVnnqVhXHD9yHAxcFPHBhPhpF5TEizXMEmkWHyyunsZk");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuAction("nCe147nzpetP6B2qovb2TRPXVFxNJhnhful2GhhAuGUtffRJVm");
            appmenus.setMenuCommands("YzETzPoHKCJoM1AxbDkkc6mUZdyOCVlICcZMs8jUnVwUPbsdk4");
            appmenus.setMenuAccessRights(3);
            appmenus.setUiType("XVt");
            appmenus.setAppType(1);
            appmenus.setAppId("21SmIFo2haHuHRGz172eFbMVrxKdNFS3uWAHR3udHsxy8vvdf4");
            appmenus.setMenuTreeId("R20vsXCI2y8xnGabSUwbPZSkM3PosVqiNMjihU5UcFicLsKRBC");
            appmenus.setMenuLabel("k3PFLPt7fyM96OdI7QI5md9FocQ4KOziRwBDlzBMJJ8U0vhwtt");
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("bgVzugEBOOnAe2yVSfxIscDXe2eLEYf7dUVQZPxkdcx6pMJ400");
            appmenus.setMenuIcon("ttkybTb4eMwUCuLXUxwIa0iZSTUXUfWl0EnX2uwNujvnWtYwkn");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "vNHDil6ZpmDLvRAjdTgLZ8OKsglsoJ1O9k86kfToTTrrizvCvWZO3IyV15GUSFfUdluyqPI1YzU96zV74HKZN19vunY0tZskAqFHj3bQ0pluBPZGkPd2RqrRllJcTaxIoiFpIYIgep5LLG379QPloXC7w9ym9K0M9Hgzd67BSIdiJeZZhJei95Ajm4ADYd7OVoFgxNSfmeZDKz1tSrr8q9R9cewWgGOIqpeY7itZerEVjGnQKkH7MZ0I5bp0CyZK7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "QkfoiXov3PdlduZkXkKiW15mlklHKt6fsWambqqfffnuF8xv8HkqeGeycbB5nM0HD7m5heNSxdEK1nU3C4hx33pwYjTlNY2lqRgrFPUjQXyoybhqPd4qgqpJ77c6c5ubwFi9hZL0qW0vG6AqA8W68oBZ3esgBtW5FbMrrV0ThMzk7QnaFr3JqXpGIbzeakn3RfvBOBIBUlPS0NVmIndEDoNzsiD9olnloAKkodeYXKOl6mw0vax2est0TKK8nGMJs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "vsfKBeoXo7OqV3DWTP9GWSuBk812HnSpGj5wFuKUDVwdO8Z3RIUUFRhsLwktwLaLKbSP6jCgIc514bOIltNZBQ7gMjJ7zObuK1fXGninYl8UeD89C6VYP102bDLyPoYalin3aco4yewJ83kQ6yocjFO0paimKn7gUqOG7Vhj5gzbtzne0PUl7bQ9782mgmQ5sBp3ojDZmC0PrhGLnETWEDlSoNcZPA4DZA3XjWePTgwPlOzA22gL49FxTbFyNrhHa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "qFHH83v7MvAvEV5EjIDKpodXL8GpftBylx2uk6YHH0MG0znRZqK5AcdcPstRRbycs"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "FBneUXQyqPlkNKC9YP6HTr7Edf5Qhax0GRxtlu1g7qSmV1EeAHW0g7t98JxwFOTfcgcbptw1qlJLapq8JV91tJNWCYnHqmHXhZdKmMkLMC1wbYtKBdywRT8Wlf8LgyYrFUBZQ9yTR2mH7kVxyjjsghQod8c5lQtkwW2tCvh6yyZStZf3KvAkCnMsfOjyXidcgNWUlnwWWVsO0v0QZlbgKA3ObJ7w9024VQCCnRDDuYXDp8lRNMCTt7S1ZccddkVF9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "rVyo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "u5jKjEgKQ3riLURkQ0IxXsA7QWdazf0wxv6V68zR38iSjlSQcAB8xZqs2n0mEzthGOqkI0CZRzfHJP9S5cKPtAo4w8HhlFzuyJiRPeMGfz53SCUt8LM5gRLfPJBjbIEV3OUzLi57GpowsoMeBcYQFUGCLhmoJ8dRFAnvLwsUAQWQ60Zm5VorBOxDtEEGKw6UZiERfYwxqLoKwArWGRvJpZKsDn6ZjTYMdnzAOHdD07p3dMOp6WuJQXcKAvhMjj4PK"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "a7XdbZm8kjDxsK8NU7fxcCroGOoWkojM0H2XI2IdbkpjKaMbe2j4olFMrhzxnu5LX1G2YbJ1Dhxu7pDKfs32jymjgWWYggwRgh0EFd7TSdmVbqp6p03Nta79h4XCKDOkiijMesjTtSDRLtTZWCiobPEA8ihOWYJFOTVnZUu333h3QTj56XRjhDBwfrV45VHSrovAmbWpHDwSfIsm4AwxZdfLHbmtAKoaLx4whctdIwZvoGUrPz6EzWgNMWLHbjDPD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
