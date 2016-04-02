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
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Gender gender = new Gender();
        gender.setGender("j1kt2g9vuEH3U4VrQUvFNLuZbC7cwFAn0s8no9Lsi6vTXk1LYx");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("uU9ApqTzbZg7n0cwnMhFMmvDMPKQDvObyqwAg2YAH4tlv7S4SF");
        timezone.setCities("NOasr05h96ZdQnNZvkj1Sze39ZJt0wesEx7fKcrBwGtUFSpkAb");
        timezone.setCountry("brsmUElo4oIwruP84ZVCtvhxEqhQMYOSHaoDfuCtkJyGHkh9fx");
        timezone.setGmtLabel("rYN9VzXG868gWDjOojTMILuCzlIbwGu5gQ1YSODzo4jke7kkxz");
        timezone.setUtcdifference(2);
        Language language = new Language();
        language.setLanguageType("58iJiDm3RV60qpfndXuKVUPiO7ldHi2g");
        language.setLanguageIcon("QtXT8ksHivJ9JqU91gxRycK4nXqqGEAb2QrPOP841xYOCXLDuY");
        language.setAlpha2("AN");
        language.setAlpha4parentid(11);
        language.setLanguageDescription("HirFCcY0PSWyz5TeV2HkQe0bePDMIrKGeJKXUaMYoUy1mJNGvs");
        language.setAlpha4("mtCM");
        language.setLanguage("lzDADEDRKdOZSAbNyz2FTbiq5zZE6kGdUcZr98cEOSJNhzYhrt");
        language.setAlpha3("M0z");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("BWXxKFezpHyTdOm4m3xvPEKGlsjpTEcN7i5Foz5EN6pSwUBeIe");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("Ul6suGmov9EezmgaYxe7EUl6tloGoiJihfiKmqs1VLMjbw2CAd");
        corecontacts.setNativeFirstName("6UFZMvLrClW2D8xxwx4oSjqNpIwSKfuhGsPkyZfg7dcZSqHrZj");
        corecontacts.setNativeMiddleName("EXI2JvX3QP22BnOd3uOjGULQMvKya3xesKytv1Y2bfgmvh2F4C");
        corecontacts.setAge(15);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setPhoneNumber("8ZtzP10nVh2GeP3pY9cq");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setEmailId("mpwoWdeDQq24ew8MFeRQz1tMbHPKaoquGy8Ld0TCrAGMmtuAHe");
        corecontacts.setLastName("JAuUtoAcIxemJ6ZWUvpR2Jk8BjeLK5vzyC3nJfEeVryWubfV48");
        corecontacts.setFirstName("76c2zILTY3Ke1a4A7qbNSAEzlCW5qykBOCN7rv9bpPjzjiKTXH");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("IFqlEa0glYs1onHBIrcAnFoAc1B3XoTlMjkAB6T90GtUQpNucB");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459595951566l));
        corecontacts.setNativeTitle("qqhkCvjSrB6k822zifNSA2zvUfycHndQ3q6SqX58TstyMxfu8q");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459595951608l));
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("8u98upeovf7T9DyVRuHT9DtkeJo3Qm9ilfMmtPTTsGFQLRYGIJ");
        communicationgroup.setCommGroupDescription("v56gWjYixn3YpdIhm3Akrem5yRK5bMsuGar12hao1OI52f7XfN");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("7PugqB22odsDWVcWjgrAbIyfewVd2W8Hk7LxRkbiJujQpa1ZYw");
        communicationtype.setCommTypeName("cBxJExgua65wIwnxZnuLZzoPEIioVf1BwUdZLgoeyxPS3uEgzP");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("9kdx9BeAZm");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        City city = new City();
        State state = new State();
        state.setStateName("ZBQgwKhKXZbi4GsmrwfBNNxLieTTEVmXI4g179ZJUjjjCRVl5y");
        state.setStateCodeChar2("6rsrF6BCcwsCOvNkAm2IZuAnse73i0Ly");
        state.setStateCapitalLongitude(5);
        state.setStateDescription("ZKKioNJ1cjHrQRQCCkxnr6LCu8AnMXgNmhIhQ8maw9mcbHglkh");
        state.setStateCapital("ouSGvYLz2bjxYs3OrXLTZJ40jyXILxTChc5XIXcrAwFWo0TjrM");
        Country country = new Country();
        country.setIsoNumeric(691);
        country.setCapital("pBloJsL8mijgtxkcsz9pIb3WmIguug9E");
        country.setCountryCode1("A5V");
        country.setCurrencyName("p4UblMw1UvMYfF2HSNNpq7xWpsAruJAyAuPMMqOcrPrp7KmLIw");
        country.setCurrencyCode("Ibd");
        country.setCountryName("VAS6gnShPlZigDNzlhqpjct6BlhBU8fPKRZBDiMnHf3NYgEHF7");
        country.setCapitalLongitude(3);
        country.setCapitalLatitude(1);
        country.setCurrencySymbol("YpBgn3nyiNl69dyBeRMHnLkMGbjZvMrU");
        country.setCountryCode2("Nth");
        country.setCountryFlag("SloRjKnT3lSAPBkyt3vkqbfnvbf8XjSdmnw8IKquKFkEguALqo");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateName("ujkKNGTtpufQTRevs0kM14UhpirasJD39QSQDTRtEDoJGvuCYQ");
        state.setStateCodeChar2("AjykFa4YOIGGYg2Ar8SBmkkyA4QQlSaJ");
        state.setStateCapitalLongitude(9);
        state.setStateDescription("9qrTd9HaCaGtoRIuwAzyL10YHPAkSLzq1YW5cBTif6eYOUYdS0");
        state.setStateCapital("0maMZiUpgX0Ie9RQ6UwruLO48vwnnUnipZCiKU7LoBtPXNtWUW");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("ckqTTH4S4z2hAXoQUhGJB4SAo8iGZcyZ");
        state.setStateCode(1);
        state.setStateCapitalLatitude(9);
        state.setStateFlag("vuhYIh4qQPQKQwY04YguXG68IdBAXtciwWmX0ovN9AMEg8FBVe");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCityCodeChar2("54XYHE3E65328PZWHNAJELA5cippMOYn");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("5NAeq673N8d9hNwrsge4c1Cv1bx4DzJ1CMUSaMNs3Vxuzkv1RP");
        city.setCityLongitude(6);
        city.setCityDescription("xHdY17VuJkeQmomC7IPBhVn5MakKmjn5UVBQOsbrwP5npmNFsb");
        city.setCityLatitude(10);
        city.setCityName("0XV1pHVvV6xLbE8lndkKdL5yPXqeVbxTso3rEztT1ayr05mpAX");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("UAmMymkILb1ywlgqCZMW1hG36kMfN2m0XDtWUvjxb8L66fcgct");
        addresstype.setAddressTypeDesc("wQATCiqC8vxgeXEZJZJR1kEayGbt0Y2r8N7Ok43ituxRK7668E");
        addresstype.setAddressType("TT8gzi5hNIl8OTiv0iqWIPMYdTzdWvENQxwvLNS5QcjsBUc4ha");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("dAanXN");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("jUEaRvXWeazjkqqu0WPKnlTWiC1jZldJfKefTNoca8PtzhzyUB");
        address.setAddressLabel("BqybGVFd2M8");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setLongitude("n1YD6vBJUKmU6do02z00d9pabeuJCzuGptmTkXoQtZfCJytqNk");
        address.setLatitude("3o15SeugFLXAItxSXnsfFUs2aF5ier7qnUEbp3xGnLDkfxGk9M");
        address.setAddress2("Fq3CEl2qzQxJAhz5N4jdTFfv2sDO5147BGSE1mdXKXDAUOlaiY");
        address.setAddress1("cvVbijIsdCQtlNSg0cEHJQqbsWG0Bn5IEw0xeQtUNv8hbGgqZ2");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setMiddleName("EeUoAQsDfH7awalEMmPnGCvTNlV0hYMlu6D0IdU3pbBwmyAkye");
            corecontacts.setNativeFirstName("lpvB4i5sWakXBdQr2vFKO6G6ixZo8rhYPEem4sUT4RfTsFhABI");
            corecontacts.setNativeMiddleName("PA0g02lXO8ED9gbNlD77SI8Sc3cXTiJq6P8V6tIk1umwzknuk6");
            corecontacts.setAge(56);
            corecontacts.setPhoneNumber("WGQoJ29OrVE7hI5PzLH0");
            corecontacts.setVersionId(1);
            corecontacts.setEmailId("S1oebBFae5u9BjiXZhe9rMYboA033unGpSYGcVB2DNXVqJRuxB");
            corecontacts.setLastName("45qeSjNGjssPqRm9dSdeloNqvTVa8Y8h7Vvs0UyBysNy6N4zxK");
            corecontacts.setFirstName("eWHp94GpttewaIhwSI0JxaZvG6gsIFOIJ9OypUuRjuuLyZwnLw");
            corecontacts.setNativeLastName("9Sx82Cty5Qd00R4m0OfZmSIss3rIGHbwoRfPq1zM3pNbhHWl4v");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459595952033l));
            corecontacts.setNativeTitle("EEF5qgTQra3CwzffQavfKt0GyDbcGV5Li6nWD0WUtzexlHu9p0");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459595952055l));
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
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

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "uiwkNfhxx5wguVlHZhxrxoAtbnuRzR6KeCCToLnOrk4zENvPQHL4jG01Svp0TpkmWWcg4jNVBDmC1C1p2EWhArOLhgwkzZu7m0WVmpiCe2UJuB4jIqDIvgdvEFpjL9mHrDO0wSI03XHQcQ5DtEMCUtXyEpvF35x7f27WL7EVKmVl4aMyNBb6LSbP5RBDXSieyOfgfyV4E9yibbWI2rsuNU057YjiC1NKog2eKHhzZ19x61YcTKD5EuVtIs5rzyQ3U"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "9bmQt510DPI1n427JH6lmoFcA5peXf82dIgBDohf4plDGh20kyzgHQVXU9IpzZlVIeh8L4Y3bFk3hwfpJGzyxc20suyXR2aDydZddGExZuxvGnrS5uMUhsutrKVcMr0mH1mTGhvb6LOFN7cCvyHiCZLUcuUjaINfZstlXZwbReYsSlFt9t2Tw4meN2xxDMeC8WoUu1OcQHHqv9zclv2Wk3nIoMnGwcPqnOorqGQRl82o2wEA6GJcmHPwkbyP66LJo"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "cLMagreD5qTg1GV9XjCCfT7f3DjZ3ctRX9wMCJEknFvrTgVxvqILZMfhogV6stWVfeSoheNFAazOEErrlOfGekkDWXwDlhxbqoRrLBAPryPGDKP6WHb0lhv0xm7ITvupdLOW5mpAWHp1R5UolP4LRgwEqP3dveET6JxWS0VAFN5AgxjVxsy9aEUhwm8gsT0Jl8lX2Bj3H499rrtBLA5vTGev4LbhXzjempRXOSZacGmeKz7i4RQWD7VdaWB72ZD5c"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "ooTpZ5dK1gZO8Hq0ARhIFK8Yf5Vtax8h0bBQpwsph8gCQaVpVRgtcf2SmqQZxx9bN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "Kiu1yZFyfzduempHnBrxZYwzianj1Z7fWlvwx0P0cteZNJHiYjuJIgaSu3yOZMDl8e3MZvkWqHVoR2APjj8h6cybHkT9tUdBTABRKbQsxoReyWPY09nFx3lVzpwo21AIKIqSg0rFyacSDis7ARo0pv7cVjUgy1uVBUbIDgbhOPv7iKXImGpbFnsbXp13NsB0D0Xr2SmLY4V6bOauobZRJrZbQb4stqA74r0ZH2dNnfmaAWYAbUcWrVaicmKiunRaI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "Y4bUSqFZbYhbbRKBEHPKWdV9sL2d9CZvhQMOQpxLbXo5u1kbA9AfiDBYUp50A9yTLAViMlqmnbr2ltfNyaeqcCanFMShEV1t4oG2So6JOvtYUpenUv0S5qsPVakyYIFV28SnRza9WUQJ8pdc9jJ35UvmSuql2q3OTLbTNsEupr1LOiWGmVQXssdlJR1KIiNtJGxmyX5NE00NGyXm7hx0a8qFXk2P1kwjScNvFzNr4I6NiV96r5XvmV2ySjq1WTfqo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "FDKWsrvu271YUY7xPEuHTsluB8INboT5YDwXepeSksrrBv0rWDPnoHP2brKWE6QV284P9N7632JwqCR1UNK60jNJiVGMiRd9xbBTZXXoW6DhVUx8XVHZeX4YAtiDL9CBifmflOcGkRKGzFLVsN7yAnnR1N4vs6WuuTRHxMVotGQgel6Y98wpMCQmHJwrhqvLzcvyvKzFxy9HairI4p5VVWmHFcAivZJy8tcBYnQfkFiLIy0pPH1zDqY8D8WA2rX1K"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 210));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "Ocyj9hBlICPqFCwLsFrnS1DTdc3iYWXQ6RvaptEILXwmF5SDocPNwS3ywTUi6OHG3YpGQFSzzYaDYrFMI4obC10LaXTML5Zqi3KE4gs9gPbh6ESgNkP1EfrQMAPCTvckxW4JTXCrHsEYJyX28Q85kLLCtcGeeFnXNxG1D1AceRAbdsgYAItoC8k8aVQPoAk7AqVeweeuQ9haBiuZD7D4A16D0oQbl6FSJGt2chaEj03xR5QmhquWgHy2JL2o6zjxQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "GgWhZ67sGlO6Qql7NsEIQ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
