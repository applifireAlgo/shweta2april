Ext.define('Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.RetailerModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "retailercode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "retailername",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "distributorcode",
          "reference": "Distributor",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});