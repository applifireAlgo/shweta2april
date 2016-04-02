package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
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
public class CommunicationGroupTestCase extends EntityTestCriteria {

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

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

    private CommunicationGroup createCommunicationGroup(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("ElyYdr9DGYPRsxVY6wR3uaTaNnIgnryOKHc6TLxkEZv1NQ9NCX");
        communicationgroup.setCommGroupDescription("LI2IySrA1TJhWQzf9OdJPYkQYo8MeYu3LXwwLyg8YrQrcZ2RrJ");
        communicationgroup.setEntityValidator(entityValidator);
        return communicationgroup;
    }

    @Test
    public void test1Save() {
        try {
            CommunicationGroup communicationgroup = createCommunicationGroup(true);
            communicationgroup.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            communicationgroup.isValid();
            communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CommunicationGroupPrimaryKey"));
            CommunicationGroup communicationgroup = communicationgroupRepository.findById((java.lang.String) map.get("CommunicationGroupPrimaryKey"));
            communicationgroup.setVersionId(1);
            communicationgroup.setCommGroupName("pQM1ARfAbZ6vFwLsFtBmnb5IQ4Ty4BaoFprC5Xt1UifH7kejqn");
            communicationgroup.setCommGroupDescription("6vJJgfROTZ61juFZyTji467LJn7nHuPACBbkbMfAJbXDVR8NGK");
            communicationgroup.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            communicationgroupRepository.update(communicationgroup);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CommunicationGroupPrimaryKey"));
            communicationgroupRepository.findById((java.lang.String) map.get("CommunicationGroupPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CommunicationGroupPrimaryKey"));
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCommunicationGroup(EntityTestCriteria contraints, CommunicationGroup communicationgroup) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            communicationgroup.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            communicationgroup.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            communicationgroup.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            communicationgroupRepository.save(communicationgroup);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "commGroupName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "commGroupName", "s5uTYPfVG4UEv4NVCkIncNU3igEUSiGLzgKg5OSwpJrgd0RELLdnj327RSAas7guGi2uCTDFAC0FvVsFRuIMB38MsJClwmNbZaW3DNU4n7MzQHtinlAK6i9B656Rjc1wB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "commGroupDescription", "WCbMiL89k2o0oCwbAsVr5p0RKfkVKjuxYIT7VYczHYiHdEsuSRWbnKYYbW66EMwgXYnZHl3GXQY20sQ60wFElzqZ6bABpXZ9QqPcfcDbe1TjIwnJqS2VLZgr3Iha9jiXFaSLCcEEe5Q9snS0NlMKQAFc2dFI1lDHx2mNl72hbWjOOu693aNTxDeJVjTP3MSHOOF2H863fnugxfJuOdpOHIYxDOUxRH9ePqlq6uqNjjxXMw3CZipO5fJBa2Xgacv46"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CommunicationGroup communicationgroup = createCommunicationGroup(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = communicationgroup.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(communicationgroup, null);
                        validateCommunicationGroup(contraints, communicationgroup);
                        failureCount++;
                        break;
                    case 2:
                        communicationgroup.setCommGroupName(contraints.getNegativeValue().toString());
                        validateCommunicationGroup(contraints, communicationgroup);
                        failureCount++;
                        break;
                    case 3:
                        communicationgroup.setCommGroupDescription(contraints.getNegativeValue().toString());
                        validateCommunicationGroup(contraints, communicationgroup);
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
