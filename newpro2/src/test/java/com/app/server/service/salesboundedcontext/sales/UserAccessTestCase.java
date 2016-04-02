package com.app.server.service.salesboundedcontext.sales;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.salesboundedcontext.sales.UserAccessRepository;
import com.app.shared.salesboundedcontext.sales.UserAccess;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.salesboundedcontext.sales.SalesRegion;
import com.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessRepository<UserAccess> useraccessRepository;

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

    private UserAccess createUserAccess(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setAllowMultipleLogin(1);
        user.setSessionTimeout(1664);
        user.setGenTempOneTimePassword(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("qD9uaHLToPCi8XSz0AFobDvGoohpXQvYFgpiMBmU17iSvCfkio");
        useraccessdomain.setDomainIcon("iu7ZAs4M1SxIhGljcuBn8CwF1K8bBidOO9a7yRUp9HSlwbh9pj");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("uUR7TTQTRqTGr7xXnwbnKjBH5Mxh91MmuCr2rxyLFrlECq2CJi");
        useraccessdomain.setDomainName("Bp7rxmIsZQ7B8fjithxlUqvF5CjBYMSjjIRealCManQAX638HQ");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("6gPrR6ldo9lopwfSOe8vm52KIM7OhtBTpkjFku54pQpzDCZ5W2");
        useraccesslevel.setLevelName("YQuPeit0wwlEbOb8jAFSH7AMnjpzMWovjGZ19vQuuIcAn3Vajv");
        useraccesslevel.setLevelDescription("MvYkyXNEekveePbOsiX5D7MROkccVIZ4IraAJv0tQzqAC5jP39");
        useraccesslevel.setLevelIcon("V1IdK6znUNBRP9GW3wnlfRgKqpllmnHEhi8khpoGpOevzcctb1");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setAllowMultipleLogin(1);
        user.setSessionTimeout(3079);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsLocked(1);
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("pv6pUiJsHdDCteuMZMqpyn51x68FH6ocH6mJxqJZ5FPvyhe1JJ");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459595970801l));
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459595970801l));
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(47691);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestion("gW3lmG2Q04WfjMnP4RqlrkdKZLQY6AHHo8c2Rsm8YXmDGvaqVQ");
        question.setQuestionIcon("ZsvJbI8xWkV5Zwub8lwXm3P6jQ7HY6uxTk4QnO81v4VVdevrXs");
        question.setLevelid(11);
        question.setQuestionDetails("qjB7KXYDmD");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("JNiedUH1jw0p3ZEcNOmKKygLDIp9WkrUINO6k1Zyiu7u5Ab4A2");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setLast5Passwords("8lSZfSq8bodiZRnKmFakH2YV6NOQcaOBuDOvGe8bwDQXer6OZZ");
        userdata.setOneTimePassword("QMNDKTcX8XLDzFSYNB5JccyVMe7ffmcY");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459595970949l));
        userdata.setPassword("Nigr0B7eimMVYsp2P3XpQ41cs0lrDWrqL8s3aH0gZPjGNzPFor");
        userdata.setLast5Passwords("CPcJeY4MRzrpXt5bDAFPWXDVIr8oqLT0WCvurWMxzsQ666mXTQ");
        userdata.setOneTimePassword("TLV8zMjuUfKYH3OcvVu1T02PaTiamJRN");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459595970955l));
        userdata.setPassword("g8Yp4FrdHq73rzK7YTaxaME42ECOoJPzYo7mBSa5bCKs2DxS4i");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(11);
        user.setUserData(userdata);
        User UserTest = new User();
        if (isSave) {
            UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        }
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("eVkGgTpZbIV0S5uCtzcM6Bdc7ScfWyWJ6sE9l6d5P87MhiQrWj");
        SalesRegion SalesRegionTest = new SalesRegion();
        if (isSave) {
            SalesRegionTest = salesregionRepository.save(salesregion);
            map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        }
        UserAccess useraccess = new UserAccess();
        useraccess.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
        useraccess.setRegion((java.lang.String) SalesRegionTest._getPrimarykey());
        useraccess.setEntityValidator(entityValidator);
        return useraccess;
    }

    @Test
    public void test1Save() {
        try {
            UserAccess useraccess = createUserAccess(true);
            useraccess.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccess.isValid();
            useraccessRepository.save(useraccess);
            map.put("UserAccessPrimaryKey", useraccess._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            UserAccess useraccess = useraccessRepository.findById((java.lang.Integer) map.get("UserAccessPrimaryKey"));
            useraccess.setVersionId(1);
            useraccess.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessRepository.update(useraccess);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            useraccessRepository.findById((java.lang.Integer) map.get("UserAccessPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserAccess> listofuserId = useraccessRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregion() {
        try {
            java.util.List<UserAccess> listofregion = useraccessRepository.findByRegion((java.lang.String) map.get("SalesRegionPrimaryKey"));
            if (listofregion.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            useraccessRepository.delete((java.lang.Integer) map.get("UserAccessPrimaryKey")); /* Deleting refrenced data */
            salesregionRepository.delete((java.lang.String) map.get("SalesRegionPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccess(EntityTestCriteria contraints, UserAccess useraccess) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessRepository.save(useraccess);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
    }
}
