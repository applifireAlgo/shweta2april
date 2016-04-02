Ext.define('Newpro2.newpro2.shared.com.model.aaaboundedcontext.authentication.LoginModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "loginPk",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "loginId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "serverAuthImage",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "serverAuthText",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "failedLoginAttempts",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "User",
          "reference": "UserModel"
     }, {
          "name": "CoreContacts",
          "reference": "CoreContactsModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});