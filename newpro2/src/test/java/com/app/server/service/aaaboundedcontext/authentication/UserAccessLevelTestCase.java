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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("iTNjp8wFsxyqT8ejaTnEu063uuYfpWWhXmyZazS8r5sTUCu3oi");
        useraccesslevel.setLevelName("MITAHzhmtlx2K7HDcZIayzAU0CmUhmdWhH2ikmFXZEWXEgWoag");
        useraccesslevel.setLevelDescription("MDOEEN7OJmHKuI771xkpviVM9qWiBuRF4So6SOVwYpi9uYiuh5");
        useraccesslevel.setLevelIcon("2EngvG8BenWo35DMzVb62x0ZY3CYCvQ00hED6Qf8fbE8v3XZLA");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelHelp("4vC26gnwbTSg8yF1L0PmymLYy9UHmy4kIUYSzseKyy9X5Uye1b");
            useraccesslevel.setLevelName("jheDASDXgMAcytr68LrFULNWsjJLjZhIQtb7zvIYKaiKaDiDIu");
            useraccesslevel.setLevelDescription("JRXZ91QbzZSSdPt2FUShlIt04pTU6cdv9G7Gv9Z0Zc59AKFBi2");
            useraccesslevel.setLevelIcon("F0L50SvOGcjhA5DQCQtC2rvi68PLk9q5ASXjRh4ltrUTeeeFiH");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setUserAccessLevel(5595);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 134221));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "0G2xD4UZdqbOMKl9KRf7A0ElRfHdEZCh9NjtnPLMNR9A0V1XTMDpwb9MOYIx60yqZgaJgXMhMie4QQV9gIBP2qxIsvCdV35pDXK5KwdVkQHgU4f3YroYhZNmQeft5ILgEt98jZQYWbxs81NcNWKxlIalOVGr4FQEBPGoxZ8T3EI1a7pjdcQpSazDEcoQ3jlOsxa90QZOqa1rCJpyQiRZl1EtwyKJibqGqfLoymDJM5HZdis0YIuCO9dnQl2yv19ao"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "m2PklYJHBf1nwDEaq2rG9s0kodl0DQEdPu1s2nacRZfqXO0WrJKqZV69bb7RXgrkafxsIStGe6G7upGPY09rZCyIXzfSGPgBOEQ2VPJWOCSJ266iXI9qL5CDnGiGlnMJeavGjh8xQoL4vhOVBjWxHr2LTGQ3wrybIvDdJq4PTbINn7FJUL4proiFGXKsVnMkA6z944hxx9O4r861PZGkUvKXGrgyP16XToOoioDUCaw77M5QBTSYIMEVisN6xdGuc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "v9omHYsu6nMUpU36EpNR2lMKDj6dnyk23AfxcuItdEZo20SKjtQFCb0I9b1Y80Nq9wkY0NbyTi5y6aZz1AdGaBKc5jlwb7hEFjnCqouUUPYhVyPaRVcIweHyjruPncNXuEzbHIJKVtURwpE2QoTFabm5wDE9OpMnGAUEX0KesRXQFWsbbl6fAG8mALKcsZDwG8Btdp3pi27nlKNeZNf5pK4VZsjJmonr0sbmMVyE5UR8uw7oxse8n0GlNoYLeODCT"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
