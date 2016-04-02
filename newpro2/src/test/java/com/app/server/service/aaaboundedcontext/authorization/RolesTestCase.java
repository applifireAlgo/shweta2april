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
import com.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleHelp("5uKsHWyIMOdUZYr2VNp24gryAQnOhEYBHs9mTO5Xm4SoOQrWdq");
        roles.setRoleDescription("7UJ4jGm1B2rkmy3T3pZBrZhjIjWzyMWVhSgjxzr7dMtlytahWp");
        roles.setRoleIcon("x1m2qFDEZgjX26viMyOYykDUhyyCYt2Mc3UJU4xBFM1Ayxic0j");
        roles.setRoleName("VehRTk5Wpg2NBA49htgfHMt5c5gvvicDaJ9sHDnay0Fx3Jwcr1");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAction("U0qO8OpfwK8E14XW7HI1snrCI5AqCj9vpPqw2AEX5ad5ZWXicE");
        appmenus.setMenuCommands("YoWYvN6jvhvmvk7CD28Gm7RQayaEP9nPOpeKkiU6Mbbi4hLt9T");
        appmenus.setMenuAccessRights(3);
        appmenus.setMenuHead(true);
        appmenus.setUiType("3xs");
        appmenus.setAppType(1);
        appmenus.setAppId("GBMWpZzpqJa60mxCTt6dsUATgBfjaBfgrTqoeU3G6BZG1LYGPm");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuTreeId("GcU0FIwMSimhrZEwkqNokrP8R9Bjo3LerUrHgeUGy8VnFraEae");
        appmenus.setMenuLabel("AR2uQFgp6flGtCMAttduHodMNBlOcKud0Z0Di9gDUKqHMjwqym");
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("DQV252IpOffhKsJOv9DZBudOcOxVJRo040CfC6g1LnHEDzHiJh");
        appmenus.setMenuIcon("wTmnyQgSJ1uxi1ybJ663CYEu94ZyxLi1cSpjH75Mlf30Jrvo58");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleHelp("qH3MeTqySbxU60hk4vADG9PAextOXjZcSFz8kvU7EXSzcTsWf5");
            roles.setVersionId(1);
            roles.setRoleDescription("q2GPzGyeEu7YsLwC2V3OOolL2PJOeoIZdTTO0OVEzbTWC4JZm7");
            roles.setRoleIcon("OZp2W9P0bPiXEJULo1LPWwPUyOgzOjHREsNq5fvcapjSbZ5W8m");
            roles.setRoleName("jMIyo3JZR1HncDjbdNweaMxh1CujQESiZb7yVPrjla7RFtaKa5");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "zPFGGFImPTVD7A5Q16FITwnPCnmVORGDSU5r7ehfkQm0pQLGBDzXpNeePfUaooinOjQMBzbKp8e7jJwoN9X4YVY2GZZgLqxgJMk9ucpuR9gRKlT6ZkTnVoeNs7wclAkAtathDfesLqmEPDXcxqb206xAe9XgLBDgc0njoz6TNLRddsfr9f2LMTbRGZeHY5t7EoH5OD9GXiaca4hORVcMxLZdqMTZfi8wUWzPeJIXJlSZ3DAYfzBv6gizpreqrspMi"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "W6u48lbB0RMvA7duvu69BrmntAW4O72MZYpVcM8u1hdRsqesNXdMTo1x5AxZzqnUURoXxjTW9m2kTAprQ48KHw7tc4B5W26SBiLiFRila3f8uWTsOcpjpqzfCs2f7XCOt7icCRo3i06WriUzHL3w9i0PMOMKwFQhYQGVYElZtZtL9RJo1XGpHXZwamrCTgvbWv5uEcZ9aFiyFMlV8JdbsBUDeHhQWESeGE2FHo3gk4hYv77aSfYjPFmm7tmm9R0Ek"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "EJleVzFhel9Onsb1ZKdryXfoTxqfF3xVY3hjFhf6wmSaN38kpvq0PAmVZm22PkGNo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "g0iPx5jw1pLXFDE83x4DZZSxA8DLvl0uMzcwfRyKSsacthK80hDgdxYlndlbyi7k3cIQYSExuD4lS1rVCxBh2ot7GVcaMXXspsuwiKPLZ6SNrOG277wu2g5kn9vz76kxSeiT5rmm4s2cteDb74J2Ut9t2ODUDDQrabzeAXAl8RUAgA7SgkgsG1s4NeYsN1QeDgEZ6jdsVkVP6CkKS5qIan0P6WyqEQmHXbxaM1JrbwEQmykRnlUhjFpaDCy1nG564"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
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
