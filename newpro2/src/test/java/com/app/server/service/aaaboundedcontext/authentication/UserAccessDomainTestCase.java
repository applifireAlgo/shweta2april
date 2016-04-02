package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("RvsObAjNYLm3tTsmMdayWBNh5ODwXOZSCIMgcogmHDfHjy51oL");
        useraccessdomain.setDomainIcon("3PmihO0SGAo73FP34rIuP9BlDsX1MogJkNzWTCo9VrWhMBjaR3");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("3KpNPKnYKXqtkLRndlJNEys36utWm7KtNkaADJWn3i6oEUrWo9");
        useraccessdomain.setDomainName("X7lMCyLm4vp5pF46eOz6G6FaP39iXlrX5V9Dep62mdD0n4t3eg");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("9z0IH86VbjDv4nkJxTGOTEEqYZjcuqmcQjDgJPTU7QIDkIo6um");
            useraccessdomain.setDomainIcon("x8HyZRNJJ219w3k2GLuV8RkKPOVlZSmiqSCOFWgGyIGOA1rd13");
            useraccessdomain.setUserAccessDomain(56973);
            useraccessdomain.setDomainDescription("wISnG6NnhiyJvxmxeoqz1BTHR69uwBMOZ1mk6sNz1PDLuQXzf5");
            useraccessdomain.setDomainName("eTI8NNGkI2sGrtVwq9KEz0pqHgVPlepWzQJGaD2EohFhsYrNTD");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 123031));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "ab19zyeWFzzJZcmVrac2pWDJPsmC178Up6sMRixxV5FJpyMAY75hvS5P02epYPAW4ajAxod2HzhjFINlN82zAd0RnuaiDh7r9NV5zudlGUrOXYfQpR9KQytWRcRpJPrj7DKopU5RkU2EH1gfts4Og1V6EwRhhao5thrk0jDynB9P2pYvM9WeeeFLQpviTCjAi7JEuUqIMjjMy6mUEZYcs0FYO4KyISWeNi2Ml5I4ISY6dbcjY2dwAofPoPxGAqBKd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "F7CW8FSpkHeHJ2UxNcVkXT7Cz73xCHvKEJlWMSrgEdkS4RdtNzrn87Jym8EYJUBf8xQhQb4Ojqj0OvJZgX1Lsq3DoasZq8V5XVyocCLiUTdGLBaZ2hjyF3ZX1U3ZbPpRMhG9cJc5BNK6W1X2M3mYSxnd4nLBwYikOWC67kz2SL3UCvJidTk1le3QoYdWy82AbueUbc6len0QJLWT1i66AGDJimQXjouiZ3dbwY1hZnFM1tFh9ShvVTFyjfbWgYUzT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "aeRPQ56rW7ISx6pBNsIUqhFPlucCUgoKAH2zB4XLfJVu7jDnRdM4iMTKT5OmyWqkLz2t0pXRZ05ly1slZKK6YypibNhkgDuFyBIZ0w65PHWaG5BUUBMcqIwC0gEosUmfLgAEcWVICw2gzpvTvhxmbNgQIoaEUEx2oKKIMnXiCOuxHdiKVQQS7ncKgxUHG20sIYSdRvj77TbzjMhCEwjlhJXoyGzX2hfhbUxunUhUyG7AkaIg0dKvBQJs5b7OcVRpv"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
