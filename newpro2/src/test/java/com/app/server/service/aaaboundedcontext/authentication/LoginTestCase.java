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
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("jklLk0qdFQUKwTYz8Ev5i9mmlcXQRnf0YJmu02czrMXsHKwVqG");
        corecontacts.setNativeFirstName("bRU0pQjbZUJPjaxrkwomObyrxcJQ7GLVHOf8BH29ad2mx4DFsw");
        corecontacts.setNativeMiddleName("bo7bsvFIay6VZJJNFVvWumbDe7IX24GYgZ2wHc3kb2BvJLuugL");
        corecontacts.setAge(1);
        Gender gender = new Gender();
        gender.setGender("4gl1bAjpQbjhQ7cP0ottp3vKfiYRXuLmSQJpyR2MSkIezJHkGU");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("4kffMHoSpqqvyXdn3k5uT2cFCsw3QDf50nszCqKaI0U3ottHCX");
        timezone.setCities("o50H75XQIyvpPRsZ3JdExXgqMwUp2lgxLW07bMl7xNkUQbGeHJ");
        timezone.setCountry("vOVWhGED41YCDMHI4HK3k5jWBhtbekvhvx9gYAGbtZITVFfSWf");
        timezone.setGmtLabel("gp9eBYi5Am0zqUa6Vfp8Xu8MzsrAn4AEI634mCwSlpFzfxoaMd");
        timezone.setUtcdifference(6);
        Language language = new Language();
        language.setLanguageType("VwYDPg3wekjC4nc2eQSgc6lOlNV2MGEU");
        language.setLanguageIcon("xyXlqgsqIOms9W4Hl1moM4lLmG2wRO2YbnhTcxhHzNjsTTBn2q");
        language.setAlpha2("RF");
        language.setAlpha4parentid(3);
        language.setLanguageDescription("tPVde71lGWpD6vNv1Mu3pjxRCg8CTtQgtSah8rrG2ju20ifAO4");
        language.setAlpha4("FHFG");
        language.setLanguage("4rrWYZpTaxkjzMaBJVhprSKT1x9z2NrMJRSOrXqOTcnsUQXtFJ");
        language.setAlpha3("JN4");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("LBNBxFE7Boome1hCgkJbYkAif08iX4dUu1KPC1j1djKnSXy6pZ");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setMiddleName("xYDhvsI1HQ9EQtjyYx7JRdXfR1R3oklc7mBidYSSQ4R5OkVFxZ");
        corecontacts.setNativeFirstName("V3qvdYp8rUL3x69JPb7gXpAXceU1swQozOsjk3pv3w42QuQQPF");
        corecontacts.setNativeMiddleName("fdZSSiM55XwOswRgFvYvskfbbLgYWTNFFb3wP1oH48BIHgfJSp");
        corecontacts.setAge(51);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setPhoneNumber("8EJwkBxNyGqKawe82Vep");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setEmailId("qYLfjDToZYmL2aYpzF9l6n2MsSv4YqPqee1VvdsgybnIRimSRR");
        corecontacts.setLastName("1jBTt3SKfNUZntZGQ69hr5KfdPpO5HMuAa7L2EPgZfZ6bhjWLt");
        corecontacts.setFirstName("KRs2fq9kutmxdkL5B5smDActWO3cooJIpDHmwLaOf7DwSX50WM");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("7kc7eMVb6WoO406YPIeTTE6kFAF3KHWE1PUQliiExZvDMv6Sz8");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459595957470l));
        corecontacts.setNativeTitle("M1saogG50FTbg57jxE4ROAhzJwyuCsTXoJBUal8yEru0FXLhbD");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459595957503l));
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("lH6HqSUxEIcE2DRYSNny9vaGXU5T5ryMMJnlOpbxjPan6mt2Kc");
        communicationgroup.setCommGroupDescription("F4Kr22M7voUwIWMu3sXSSZa5g3vMXXPUlDQBXCVnE2RpMqvJ3A");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("1uI8iDBZjHgLzGlsmt96VTlwqi54MvhRuR6Bn36rqFPF2BA5Rw");
        communicationtype.setCommTypeName("fdwaMyNt73XeeJouhShjuQbXcKR9Tg778kTxCpJF5vu7sdCyQ6");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("fqRpRVhwYz");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        City city = new City();
        State state = new State();
        state.setStateName("fFlEDMnpZ2NKHtV1pSleqOMYAsALsbE3f51UwNvsuP3GThwyxJ");
        state.setStateCodeChar2("hvHxiq0YulzaPx8vb0R9sQbHMu4AvN4A");
        state.setStateCapitalLongitude(3);
        state.setStateDescription("vyY39PPpI6nxx3oy5EuFlkCG5mABTU7KwpKPIjYBT6ofKyfE3l");
        state.setStateCapital("qybGqJOcFsvfjrYUNe8xUKoT21mHyjSgvqqtJsTenQniP3nUqL");
        Country country = new Country();
        country.setIsoNumeric(69);
        country.setCapital("Sl2lFMy7ljVQfwbBYx2M0aV86Lt40nh1");
        country.setCountryCode1("4ou");
        country.setCurrencyName("QTtur0CvYKKVp2eMWw0mMR1GWJDO78ZkRRQFsqz9c6qIHigJA6");
        country.setCurrencyCode("GIk");
        country.setCountryName("OK1t6LnFnyZCxMRcyppks9hVEwBAaYrijc3CyH7WN6e6MJhWdB");
        country.setCapitalLongitude(3);
        country.setCapitalLatitude(11);
        country.setCurrencySymbol("6lTaU2hyKKlZogkEksRtEjNKRg3vvfNp");
        country.setCountryCode2("9OC");
        country.setCountryFlag("INdu1iqTxX28jRZylshrx1UtMdT1vOUQRp5VVWgwhAnBUbMdvT");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateName("4qCYvWFZFj3RJY4mjs8efLeCxoV2T5i3Yc8ekjReqgQ84ilnlw");
        state.setStateCodeChar2("CbNFWTIiI8favC4YajrUSDjxqAXpsfWA");
        state.setStateCapitalLongitude(9);
        state.setStateDescription("MmhM1CH2mr4DqBLETN9Ycdbr41ZSLpY0zAlHtFAleW8QUrMPZJ");
        state.setStateCapital("FnjdloFoziUQOusnnGohOP2J8OzcMqbqBxp2fyydfCHjkVaFu0");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("NI4a9VQmGLBkqM2vCv7hoVJNpAGIUner");
        state.setStateCode(2);
        state.setStateCapitalLatitude(6);
        state.setStateFlag("wRhdmUOVg8ylctVvURJWCm4Ow41siI8C8CJlzn8Uv2HihE075Z");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCityCodeChar2("pPimffJR4sopJY99ReHiAP6IaQa4TXkL");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("0OiSMNme8lfpe6M40Rd3KzDinFxJMWarM8qJP8jOsNyLjznXNy");
        city.setCityLongitude(11);
        city.setCityDescription("lHgGEYunIMMTA1DPxElkZB9t5a1IPoH5wIZB0OsfWzLOH7GAmQ");
        city.setCityLatitude(5);
        city.setCityName("M6uW5YeXc00TdNVSrex6wyBhlV8xG8XmV6Mwh4O7riIutpfW0p");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("aEc6dx4lvriCCQNvucZHZChk1Lw59GY3HvWWnHUfRbu4QjAxpW");
        addresstype.setAddressTypeDesc("5dqYL2ScUOT4W9cZbUvuGv47zASTEVIhno78iH6pinubsQL6eA");
        addresstype.setAddressType("KJuyNoQiEGIG91icAjsLXpDoWAAgV2GWlWBOlI54QKX3jyicso");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("wUUqfu");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("0j8gnrB5sqyc8VhH3w6pULQOehZWOuW9AR497WgqdYMrpEJu68");
        address.setAddressLabel("0Tx2DjrL6yH");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("lxXwKnhKRK61Sq2OHAO1zEsgDGH7yirnLGsHWpGixX4lTl3dek");
        address.setLatitude("TgDimMlBdA0lZQdo4NoIueX2o7cDP7KHMk2ZH4plsTm5xZF03Y");
        address.setAddress2("v01w8yvPC4UvDirQC1nj6K4v76QCOR8rY1pLsYepPOqcdNRvWA");
        address.setAddress1("wNelZXjsimGqaVYrvy2oJMQhHTizX3SU1zOTuD6aJVbQ0s6e5X");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setAllowMultipleLogin(1);
        user.setSessionTimeout(1167);
        user.setGenTempOneTimePassword(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("Z7rD5l0YCRZSGP86kAc2O8Xlb0cjaNOMkvRqLHVv3V5sL4qSxk");
        useraccessdomain.setDomainIcon("RpTy6HS1CoAhwlurgoC2KaDH7MoMdsbBi0PvS76yBF4CWxvTjb");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("ciQgqtRwNZXbQuywOCf9wBaEMQsnI1xqclR0KDc4LJSAndxdwq");
        useraccessdomain.setDomainName("UkImTwvOS3peaf97HNgKTlyF0UE00xg7rH8HrxioZpwr5K5YjF");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("oqpZvLfiAwoGUof3XvYNjGTPLXKLU1jbMd32VVcLSc0uOqf0Ur");
        useraccesslevel.setLevelName("P8MZ9FgJoEFVgyMMWqnWjrmD9YRULrVyLsSJrztZFeisXA3ADT");
        useraccesslevel.setLevelDescription("MYffzMEykyEmGvEj7YXmjla1dUotkgzkJvoePLwxFs7XSi5GmW");
        useraccesslevel.setLevelIcon("ikhABfJDTuGbzTfD7x1nIWaiCYc9WpFoIepKPQBviLZxuN33QF");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setAllowMultipleLogin(1);
        user.setSessionTimeout(1600);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsLocked(1);
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("MZzIxRz0k6B4w6IhtdUo9vZVftBros9YmdDIpnctPvdJEq5WfT");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459595957881l));
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459595957881l));
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(40529);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestion("hWfpSli2DIMRUH7M0cnErOO4HakJLK771eiodvYaV0waGri3Pt");
        question.setQuestionIcon("F5ortDOkwF4KLWf22mGkTbZYsPDlsQoJDW9SCjdRic0847YehL");
        question.setLevelid(9);
        question.setQuestionDetails("vsCM2Amkek");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("lZHaot3KuGLdzN5dZkZssUGxLvZHZEn1it2R7VjvsyXUdGPYi4");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setLast5Passwords("PcgrDPncj4Wcb8rcmDgCfcEgYcDJGxPefsVMfmvfkDrTq6P2dW");
        userdata.setOneTimePassword("DACDZvNhFfSyY8EnHj6FPnNlQNF2rBNV");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459595958086l));
        userdata.setPassword("4SHK4ieKpKtevL4z5eBg3DUz2SMCLtL6omADZ9UTIUa7oMAoC0");
        userdata.setLast5Passwords("EgGKmd1KlcWl6UoEQHytp6AJUkmOyVuQWGFkKrzLuZiTT3i6zs");
        userdata.setOneTimePassword("IdYAgiBed15UzCNLFK5mBMSZnNBIkXLz");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459595958113l));
        userdata.setPassword("0tPCHTADujBb68NIGHOf0yzPw0v2PPm9OOFs5Ax2mAP6fICnmM");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(7);
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setLoginId("57cTXiJdKFq1991XswS090uXz8MNWeVnJj2KFxyZfCivIAUNAB");
        login.setFailedLoginAttempts(6);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthImage("Ne0jOuUFS5j409tVWHaa6Wvoq7aCU987");
        login.setIsAuthenticated(true);
        login.setServerAuthText("E67NgAQKctgHV7P5");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("tPWzdauejciBZdnKalGq9q0ATPTwROoy4wWxXFGDMf333SHNl8");
            login.setFailedLoginAttempts(7);
            login.setServerAuthImage("PGUIGsgZ31OaM4iZOjusB31ZT68h0qjt");
            login.setServerAuthText("miooNhdVCPKXCeqa");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "pHl6xPdwUFCuq2ZdeyhgqhqNywjblK3moHkHz33uWUraRi9LGCH6k5SFm8jieo8koAV4RaaDrq7QPwQTKPU5ralDrKcZoMud2WouoDtBW3IRFjAXYvoJf0Wv9UA0XbAGzLT3hzw5nFvayF1cnYnzFuuAiKOIsUsD5n3YiZjxG6WniZ6uZ3jO7l0ijA2MTYN34nCVeLvnx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "2A7x2zddu7X43hVg9lTFv72vupHf15Vpy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "t9bDErCdUlbjGxN6v"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
