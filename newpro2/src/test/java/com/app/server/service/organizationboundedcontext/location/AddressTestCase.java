package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        City city = new City();
        State state = new State();
        state.setStateName("KJ9FUC8x0ItUNtcM5eBf4DI6UA9Rh2ug8axXGDCJJnf5QSrjVs");
        state.setStateCodeChar2("DGvclhwlAwqjvvfTPXoHpzKaPjLTGo6N");
        state.setStateCapitalLongitude(7);
        state.setStateDescription("OWgEeB2uFkDXgIvnR3QsR7qMJJ9C6q3oWNWn4jJ7jozeqL7m5m");
        state.setStateCapital("YQTcdIvSsHeErhM2tbRKS5dZZQs0xGsMuZZNE7EwZ0r3hu8hfn");
        Country country = new Country();
        country.setIsoNumeric(55);
        country.setCapital("bbsSxe68bWElNFppiyY7gGV3SrQWwuo1");
        country.setCountryCode1("89p");
        country.setCurrencyName("ILPaHA4Sdglp9PWxJxMGc9eNCb2ABFwFRAgRyD6v6OBp7sqr4K");
        country.setCurrencyCode("OqC");
        country.setCountryName("3tafGdokIpnHZBivI422o5rY7aDBUF33uzuniBk2svCj2RdJDU");
        country.setCapitalLongitude(2);
        country.setCapitalLatitude(11);
        country.setCurrencySymbol("WHGIQnBseJKxCUs1KT38L6hMCVsZQmbB");
        country.setCountryCode2("xJs");
        country.setCountryFlag("q2ViN3aqxWYUnrMUNdFjiMw8Cpo5IQ74oz5u3FGTDUPgf0tYTM");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateName("BNwH7CftjNVAS5okV122OxojL3LscRpnbO3awxz12zA5XoDfX4");
        state.setStateCodeChar2("tBReTUVYbkeT7cH1bXEIz7cNkisoPHYs");
        state.setStateCapitalLongitude(11);
        state.setStateDescription("gxfiLtqlwJGLVzUa3txqb5NGvgmjyRKeYo25yTPoyh5jA6DUgn");
        state.setStateCapital("81oyosd6XxH1nZP3ShsqdiB1VBQs8GhGVzpCkz7RQpk3d1YwmS");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("fN79d0v4SWHoRjADIs2IvSpn7pxvAOCA");
        state.setStateCode(2);
        state.setStateCapitalLatitude(4);
        state.setStateFlag("0lRAOfj75eQuGqNQPFa30VwzxZyplgWFALmiOcHhVqtJXkLyTW");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(3);
        city.setCityCodeChar2("6MqbczxEfEwcQ9EK83JPxi6Nx9GvmEzN");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("kL0B7NITycQO3NFgOcttT4VdehtQvu8dgg2FU7wmidcxGrXtXa");
        city.setCityLongitude(5);
        city.setCityDescription("Np2zCuuUp03O6bkXwsIRf9FxZ7t7a9FIKBIxSIqjRNvUknajWv");
        city.setCityLatitude(10);
        city.setCityName("G6mgNV70hiVTNHPQ03gtmvGi6o0vHYS01eFGaRAlCzE1L2gvuj");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("QGG2KlMGWNYqmzDwIVmALRyEgxwNzmWs7gGE0hM8XJPtYhP9Ih");
        addresstype.setAddressTypeDesc("m03bNQAsZQ5r63ZnsQRyseEO2rpbGl4v45nnk0XKfhQ2MHD38R");
        addresstype.setAddressType("VdIF5e4t6euLT8hqVA5I0jbleza4pWe6zz2dkufXJ9B787TYcs");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("TCHpQE");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("NrwTbpuK2G777Zket85jqKRGz9a4nrRT1nzbjVHEMHhjGL9bOw");
        address.setAddressLabel("FwwP18n3YLW");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setLongitude("6qkca7RhKKo4c93rdcJoAissf0qE5SfEoeyyKavh2KRTD7rTZC");
        address.setLatitude("busIWBMyLiMfR75KrdKzGS3QZAVBfHCLWQtSt0XJkFqsP0Tgq3");
        address.setAddress2("WF3qV3fwyqHlE852MDiwc7VZVONgES013hqFC913neYlZcRqqu");
        address.setAddress1("kGAtmqQUsWJSnoHgRNniOhTtA7UvxXq0n0TPdQpeMGdiU0MkSe");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setZipcode("C3vk54");
            address.setAddress3("7hE24SaerhvKfbWHLgRBU6scllZC9SKWxY9w6S2VdXVXyudZVM");
            address.setAddressLabel("vJApkAjIv0j");
            address.setLongitude("DwkKqxXEn7YL07uuMiJKgjNJlT1oms22UbxVfgil124N7HuUgB");
            address.setVersionId(1);
            address.setLatitude("H3orTR5A7kjmWMDmKGQgBGGwOxsLkzSpM2geSfbZt7DsEGRoKP");
            address.setAddress2("jQhaNkJzQFwTqDPJRnMGhvcTN2sBDmp0IKonpAmLd04TPrpvXh");
            address.setAddress1("nvpI9zBauehrTBJEBGdrMAv7Miv4VzCktbbpnTiQaGiHdbW5A6");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "8wHY1IktZw2j"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "wuRChJvzHJedXpVKrHLOmfuTi3tLak5YAP2rMOEr2o7uo60aJv2Jl9tlO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "ECBSpfUpZolQk5FXsaKz6uzW7jLRXterlHkuTHBFhFvGZRJwNxQvXaPw9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "oDvHkDq9H6wJMzxI8MDPnU0MRxhkkMRCroKQHKjLRcxElfpD67baokbyt"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "0t7NH4X"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "P79ZpX0ClJtDjPrE9whAkt8BnLzAI2ABAzGYziqUqdPxfpiNQe03jnkTKBA7qODX1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "xJcODeJk82GZBjkOqWv4Y20wzN2UmI06fQcPwa5BzWW2rSMJ2NKtnVoF7UpH1jZho"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
